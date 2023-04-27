package com.softart.dfe.interfaces.security;

import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Date;

public interface KeyStoreParserService {

    KeyStore read(InputStream is, String keyStoreType, String keyStorePassword) throws IOException, KeyStoreException, CertificateException, NoSuchAlgorithmException;

    String getAlias(KeyStore keyStore) throws KeyStoreException;

    X509Certificate getCertificate(KeyStore keyStore) throws KeyStoreException;

    String getSubject(KeyStore certificate) throws KeyStoreException;

    Date getExpiration(KeyStore keyStore) throws KeyStoreException;

}
