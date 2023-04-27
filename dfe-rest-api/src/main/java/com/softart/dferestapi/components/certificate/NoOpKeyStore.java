package com.softart.dferestapi.components.certificate;

import com.softart.dfe.exceptions.security.CertificateException;
import com.softart.dfe.interfaces.internal.KeyStoreInfo;

import java.io.InputStream;
import java.security.KeyStore;
import java.time.ZonedDateTime;

public final class NoOpKeyStore implements KeyStoreInfo {
    @Override
    public void loadCertificate(InputStream inputStream, String type) throws CertificateException {
        throw new UnsupportedOperationException("not implemented");
    }

    @Override
    public void loadCertificateChain(InputStream inputStream, String type) throws CertificateException {
        throw new UnsupportedOperationException("not implemented");
    }

    @Override
    public KeyStore certificate() throws CertificateException {
        throw new UnsupportedOperationException("not implemented");

    }

    @Override
    public String certificatePassword() {
        throw new UnsupportedOperationException("not implemented");

    }

    @Override
    public KeyStore certificateChain() throws CertificateException {
        throw new UnsupportedOperationException("not implemented");

    }

    @Override
    public String certificateChainPassword() {
        throw new UnsupportedOperationException("not implemented");

    }

    @Override
    public String getAlias() {
        throw new UnsupportedOperationException("not implemented");
    }

    @Override
    public ZonedDateTime getExpiration() {
        throw new UnsupportedOperationException("not implemented");
    }
}
