package org.dfe.components.security.chain.cache;

import org.dfe.exceptions.DfeOptionalException;
import org.dfe.interfaces.security.CertificateChain;
import org.dfe.util.DateUtils;
import org.dfe.util.DfeOptional;
import org.dfe.util.IOUtils;
import org.dfe.util.S3Utils;
import software.amazon.awssdk.core.ResponseBytes;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;
import software.amazon.awssdk.services.s3.model.S3Exception;

import java.io.IOException;
import java.io.InputStream;
import java.time.Instant;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

final class CertificateChainCacheS3 extends CertificateChainCacheFactory {

    private final boolean enableDayCache = DfeOptional.ofEmpty(System.getProperty("org.dfe.chain.cache.s3.enable-day-cache")).map(Boolean::parseBoolean).orElse(true);
    private final String bucket = DfeOptional.ofEmpty(System.getProperty("org.dfe.chain.cache.s3.bucket")).orElseThrow(() -> new DfeOptionalException("org.dfe.chain.cache.s3.bucket must be set"));

    String getKeyName(CertificateChain chain) {
        return String.join("/", "chain", chain.fileName());
    }

    String getBucket() {
        return bucket;
    }

    boolean canUseCache(Instant cacheDate) {
        return (Objects.nonNull(cacheDate) && ChronoUnit.DAYS.between(DateUtils.localDate(cacheDate), LocalDate.now()) < DAYS_IN_CACHE) || !enableDayCache;
    }

    @Override
    public byte[] getFromCache(CertificateChain certificateChain) throws IOException {
        try {
            ResponseBytes<GetObjectResponse> object = S3Utils.getObject(getBucket(), getKeyName(certificateChain));

            if (canUseCache(object.response().lastModified())) {
                try (InputStream is = object.asInputStream()) {
                    return IOUtils.readAllBytes(is);
                }
            }
        } catch (S3Exception ignored) {
        }
        return null;
    }

    @Override
    public void addToCache(CertificateChain certificateChain, byte[] bytes) throws IOException {
        S3Utils.putObject(getBucket(), getKeyName(certificateChain), bytes);
    }
}
