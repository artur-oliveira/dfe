package org.dfe.components.security.chain.cache;

import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;
import org.dfe.exceptions.DfeOptionalException;
import org.dfe.interfaces.security.CertificateChain;
import org.dfe.util.DateUtils;
import org.dfe.util.DfeOptional;
import org.dfe.util.IOUtils;
import org.dfe.util.S3Utils;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

final class CertificateChainCacheS3 extends CertificateChainCacheFactory {

    String getKeyName(CertificateChain chain) {
        return String.join("/", "chain", chain.fileName());
    }

    String getBucket() {
        return DfeOptional.ofEmpty(System.getProperty("org.dfe.chain.cache.s3.bucket")).orElseThrow(() -> new DfeOptionalException("org.dfe.chain.cache.s3.bucket must be set"));
    }

    @Override
    public byte[] getFromCache(CertificateChain certificateChain) throws IOException {
        try {
            S3Object object = S3Utils.getObject(getBucket(), getKeyName(certificateChain));

            if (ChronoUnit.DAYS.between(DateUtils.localDate(object.getObjectMetadata().getLastModified()), LocalDate.now()) < DAYS_IN_CACHE) {
                try (InputStream is = object.getObjectContent()) {
                    return IOUtils.readAllBytes(is);
                }
            }
        } catch (AmazonS3Exception ignored) {
        }
        return null;
    }

    @Override
    public void addToCache(CertificateChain certificateChain, byte[] bytes) throws IOException {
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setExpirationTime(DateUtils.date(LocalDateTime.now().plusDays(DAYS_IN_CACHE)));
        S3Utils.putObject(getKeyName(certificateChain), bytes, metadata);
    }
}
