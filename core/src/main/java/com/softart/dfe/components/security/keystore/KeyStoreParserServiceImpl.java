package com.softart.dfe.components.security.keystore;

import com.softart.dfe.exceptions.DfeUncheckedException;

import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Date;

final class KeyStoreParserServiceImpl extends KeyStoreParserFactory {

    @Override
    public KeyStore read(InputStream is, String keyStoreType, String keyStorePassword) throws IOException, KeyStoreException, CertificateException, NoSuchAlgorithmException {
        try (InputStream inputStream = is) {
            final KeyStore ks = KeyStore.getInstance(keyStoreType);
            try {
                ks.load(inputStream, keyStorePassword.toCharArray());
            } catch (IOException e) {
                throw new DfeUncheckedException(e.getMessage());
            }
            return ks;
        }
    }

    @Override
    public String getAlias(KeyStore keyStore) throws KeyStoreException {
        return keyStore.aliases().nextElement();
    }

    @Override
    public X509Certificate getCertificate(KeyStore keyStore) throws KeyStoreException {
        return (X509Certificate) keyStore.getCertificate(getAlias(keyStore));
    }

    @Override
    public String getSubject(KeyStore certificate) throws KeyStoreException {
        return Arrays.stream(getCertificate(certificate).getSubjectX500Principal().getName().split(",")).findFirst().orElse(getAlias(certificate));
    }

    @Override
    public Date getExpiration(KeyStore keyStore) throws KeyStoreException {
        return getCertificate(keyStore).getNotAfter();
    }
}
