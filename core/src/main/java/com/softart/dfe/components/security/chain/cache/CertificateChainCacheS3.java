package com.softart.dfe.components.security.chain.cache;

import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.softart.dfe.interfaces.security.CertificateChain;
import com.softart.dfe.util.DateUtils;
import com.softart.dfe.util.IOUtils;
import com.softart.dfe.util.S3Utils;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;

final class CertificateChainCacheS3 extends CertificateChainCacheFactory {

    String getKeyName(CertificateChain chain) {
        return String.join("/", "chain", chain.fileName());
    }

    @Override
    public byte[] getFromCache(CertificateChain certificateChain) throws IOException {
        try {
            try (InputStream is = S3Utils.getObject(getKeyName(certificateChain)).getObjectContent()) {
                return IOUtils.readAllBytes(is);
            }
        } catch (AmazonS3Exception e) {
            return null;
        }
    }

    @Override
    public void addToCache(CertificateChain certificateChain, byte[] bytes) throws IOException {
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setExpirationTime(DateUtils.date(LocalDateTime.now().plusDays(DAYS_IN_CACHE)));
        S3Utils.putObject(getKeyName(certificateChain), bytes, metadata);
    }
}
