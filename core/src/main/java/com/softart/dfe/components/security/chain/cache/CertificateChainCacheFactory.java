package com.softart.dfe.components.security.chain.cache;

import com.softart.dfe.components.security.chain.CertificateChainFactory;
import com.softart.dfe.interfaces.security.CertificateChainCache;

public abstract class CertificateChainCacheFactory implements CertificateChainCache {

    protected static final long DAYS_IN_CACHE = Long.parseLong(System.getProperty("com.softart.dfe.security.chain.cache.days", "14"));
    private static final String DEFAULT_CERTIFICATE_CHAIN_CACHE = System.getProperty("com.softart.dfe.chain.cache", "filesystem");

    public static CertificateChainCacheFactory getInstance() {
        switch (DEFAULT_CERTIFICATE_CHAIN_CACHE) {
            case "filesystem":
                return Holder.FILE_SYSTEM;
            case "s3":
                return Holder.S3;
            default:
                throw new UnsupportedOperationException("cannot get certificate chain cache from " + DEFAULT_CERTIFICATE_CHAIN_CACHE);
        }
    }

    private static final class Holder {
        static CertificateChainCacheFactory FILE_SYSTEM = new CertificateChainCacheFileSystem();
        static CertificateChainCacheFactory S3 = new CertificateChainCacheS3();
    }
}
