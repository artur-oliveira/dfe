package com.softart.dferestapi.services.certificate;

import com.amazonaws.services.s3.model.ObjectMetadata;
import com.softart.dfe.exceptions.security.CertificateException;
import com.softart.dfe.interfaces.internal.KeyStoreInfo;
import com.softart.dfe.util.DateUtils;
import com.softart.dfe.util.InputStreamUtils;
import com.softart.dferestapi.components.aws.S3;
import com.softart.dferestapi.components.certificate.S3PfxKeyStoreInfoImpl;
import com.softart.dferestapi.configuration.properties.KeyStoreConfigurationProperties;
import com.softart.dferestapi.services.encrypt.EncryptService;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.Optional;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;

@Service
@Getter
@Setter
public final class KeyStoreServiceImpl implements KeyStoreService {

    private final S3 s3;
    private final EncryptService encryptService;
    private final Map<String, CachedKeyInfo> cachedKeyInfoMap = new ConcurrentHashMap<>();
    private final KeyStoreConfigurationProperties keyStoreConfigurationProperties;

    public KeyStoreServiceImpl(
            S3 s3,
            EncryptService encryptService,
            KeyStoreConfigurationProperties keyStoreConfigurationProperties
    ) {
        this.s3 = s3;
        this.encryptService = encryptService;
        this.keyStoreConfigurationProperties = keyStoreConfigurationProperties;
    }

    @Override
    public synchronized KeyStoreInfo getKeyStore(final String certificateMd5, final String certificatePassword) {
        return Optional.ofNullable(getCachedKeyInfoMap().get(certificateMd5)).orElseGet(() -> {
            try {
                CachedKeyInfo cachedKeyInfo = new CachedKeyInfo(new S3PfxKeyStoreInfoImpl(getS3().getS3Properties().getBucket(), getCertificatePath(certificateMd5), certificatePassword));
                getCachedKeyInfoMap().put(certificateMd5, cachedKeyInfo);
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        getCachedKeyInfoMap().remove(certificateMd5);
                    }
                }, DateUtils.date(cachedKeyInfo.removeFromCache()));
            } catch (CertificateException e) {
                throw new RuntimeException(e);
            }
            return getCachedKeyInfoMap().get(certificateMd5);
        }).getInfo();
    }

    String getCertificatePath(final String key) {
        return String.join("/", getKeyStoreConfigurationProperties().getBaseCertificatePath(), key);
    }

    @Override
    @SneakyThrows
    public void addKeyStore(final String certificateMd5, final byte[] bytes) {
        try (InputStream bais = InputStreamUtils.newByteArrayInputStream(bytes)) {
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentLength(bytes.length);
            getS3().upload(getCertificatePath(certificateMd5), bais, metadata);
        }
    }

    @Getter
    private final static class CachedKeyInfo {
        private final ZonedDateTime timeStamp = ZonedDateTime.now();
        private final KeyStoreInfo info;

        public CachedKeyInfo(KeyStoreInfo info) {
            this.info = info;
        }

        public ZonedDateTime removeFromCache() {
            ZonedDateTime expire = getTimeStamp().plusHours(24L);
            if (getInfo().getExpiration().isAfter(expire)) return expire;
            return getInfo().getExpiration();
        }
    }

}
