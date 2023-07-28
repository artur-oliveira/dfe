package com.softart.dfe.components.internal.certificate;

import com.softart.dfe.exceptions.DfeUncheckedException;
import com.softart.dfe.exceptions.security.CertificateException;
import com.softart.dfe.interfaces.internal.KeyStoreInfo;
import com.softart.dfe.util.InputStreamUtils;
import com.softart.dfe.util.RequireUtils;
import lombok.Builder;

import java.time.ZonedDateTime;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public abstract class KeyStoreFactory implements KeyStoreInfo {

    private final static Map<CacheWrapper, ZonedDateTime> cacheMap = new ConcurrentHashMap<>();

    public static KeyStoreFactory getInstance() throws CertificateException {
        if (Objects.nonNull(System.getProperty("com.softart.dfe.certificate.bucket")) && Objects.nonNull(System.getProperty("com.softart.dfe.certificate.key"))) {
            return getS3Instance(System.getProperty("com.softart.dfe.certificate.bucket"), System.getProperty("com.softart.dfe.certificate.key"), RequireUtils.nonNull(System.getProperty("com.softart.dfe.certificate.password"), "The password of default certificate must be set with property com.softart.dfe.certificate.password"));
        }
        return getInstance(RequireUtils.nonNull(System.getProperty("com.softart.dfe.certificate.path"), "The path of certificate must be set with property com.softart.dfe.certificate.path"), RequireUtils.nonNull(System.getProperty("com.softart.dfe.certificate.password"), "The password of default certificate must be set with property com.softart.dfe.certificate.password"));
    }

    synchronized static KeyStoreFactory addInCache(int hash, KeyStoreFactory factory) {
        cacheMap.put(CacheWrapper.builder().hash(hash).keyStoreFactory(factory).build(), ZonedDateTime.now().plusSeconds(3600));
        return factory;
    }

    synchronized static KeyStoreFactory getFromCache(int hash) {
        CacheWrapper cacheWrapper = CacheWrapper.builder().hash(hash).build();
        ZonedDateTime exp = cacheMap.get(CacheWrapper.builder().hash(hash).build());
        return Objects.isNull(exp) || ZonedDateTime.now().isAfter(exp) ? null : cacheMap.keySet().stream().filter(it -> it.equals(cacheWrapper)).findFirst().orElseThrow(() -> new DfeUncheckedException("cannot find cached cert")).keyStoreFactory();
    }

    public static KeyStoreFactory getInstance(String certPath, String certPass) throws CertificateException {
        int hash = (certPath + certPass).hashCode();
        return Optional.ofNullable(getFromCache(hash)).orElseGet(() -> {
            try {
                return addInCache(hash, new PfxKeyStoreInfoImpl(InputStreamUtils.newFileInputStream(certPath), certPass));
            } catch (CertificateException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public static KeyStoreFactory getS3Instance(String bucket, String key, String certPass) throws CertificateException {
        int hash = (bucket + key + certPass).hashCode();
        return Optional.ofNullable(getFromCache(hash)).orElseGet(() -> {
            try {
                return addInCache(hash, new S3PfxKeyStoreInfoImpl(bucket, key, certPass));
            } catch (CertificateException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @Builder
    private record CacheWrapper(int hash, KeyStoreFactory keyStoreFactory) {

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof CacheWrapper that)) return false;
            return Objects.equals(hash, that.hash);
        }

        @Override
        public int hashCode() {
            return Objects.hash(hash);
        }
    }
}
