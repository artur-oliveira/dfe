package com.softart.dfe.components.internal.certificate;

import com.softart.dfe.exceptions.security.CertificateException;
import com.softart.dfe.interfaces.internal.KeyStoreInfo;
import com.softart.dfe.util.InputStreamUtils;
import com.softart.dfe.util.RequireUtils;

import java.util.Objects;

public abstract class KeyStoreFactory implements KeyStoreInfo {

    public static KeyStoreFactory getInstance() throws CertificateException {
        if (Objects.nonNull(System.getProperty("com.softart.dfe.certificate.bucket")) && Objects.nonNull(System.getProperty("com.softart.dfe.certificate.key"))) {
            return getS3Instance(System.getProperty("com.softart.dfe.certificate.bucket"), System.getProperty("com.softart.dfe.certificate.key"), RequireUtils.nonNull(System.getProperty("com.softart.dfe.certificate.password"), "The password of default certificate must be set with property com.softart.dfe.certificate.password"));
        }
        return getInstance(RequireUtils.nonNull(System.getProperty("com.softart.dfe.certificate.path"), "The path of certificate must be set with property com.softart.dfe.certificate.path"), RequireUtils.nonNull(System.getProperty("com.softart.dfe.certificate.password"), "The password of default certificate must be set with property com.softart.dfe.certificate.password"));
    }

    public static KeyStoreFactory getInstance(String certPath, String certPass) throws CertificateException {
        return new PfxKeyStoreInfoImpl(InputStreamUtils.newFileInputStream(certPath), certPass);
    }

    public static KeyStoreFactory getS3Instance(String bucket, String key, String certPass) throws CertificateException {
        return new S3PfxKeyStoreInfoImpl(bucket, key, certPass);
    }
}
