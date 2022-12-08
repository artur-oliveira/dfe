package com.softart.dfe.interfaces.internal;

import com.softart.dfe.enums.internal.KeyType;
import com.softart.dfe.exceptions.security.CertificateException;

import java.io.InputStream;
import java.security.KeyStore;

public interface KeyStoreInfo {

    void loadCertificate(InputStream inputStream, String type) throws CertificateException;

    default void loadCertificate(InputStream inputStream) throws CertificateException {
        loadCertificate(inputStream, KeyType.PFX.getType());
    }


    void loadCertificateChain(InputStream inputStream, String type) throws CertificateException;

    default void loadCertificateChain(InputStream inputStream) throws CertificateException {
        loadCertificateChain(inputStream, KeyType.JKS.getType());
    }

    KeyStore certificate() throws CertificateException;

    String certificatePassword();

    KeyStore certificateChain() throws CertificateException;

    String certificateChainPassword();

    String getAlias() throws CertificateException;

}
