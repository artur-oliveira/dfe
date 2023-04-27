package com.softart.dfe.components.internal.certificate;

import com.softart.dfe.exceptions.security.CertificateException;
import com.softart.dfe.interfaces.internal.KeyStoreInfo;
import com.softart.dfe.util.InputStreamUtils;
import com.softart.dfe.util.RequireUtils;

public abstract class KeyStoreFactory implements KeyStoreInfo {

    public static KeyStoreFactory getInstance() throws CertificateException {
        return getInstance(RequireUtils.nonNull(System.getProperty("com.softart.dfe.certificate.path"), "The path of certificate must be set with property com.softart.dfe.certificate.path"), RequireUtils.nonNull(System.getProperty("com.softart.dfe.certificate.password"), "The password of default certificate must be set with property com.softart.dfe.certificate.password"));
    }

    public static KeyStoreFactory getInstance(String certPath, String certPass) throws CertificateException {
        return new PfxKeyStoreInfoImpl(InputStreamUtils.newFileInputStream(certPath), certPass);
    }
}
