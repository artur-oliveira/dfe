package org.dfe.interfaces.security;

import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableEntryException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Date;

/**
 * Declaring a Java interface named `KeyStoreParserService` with several method signatures that define the behavior of a
 * service that can parse and extract information from a Java KeyStore object. The methods include `read`, which reads a
 * KeyStore from an input stream, `getAlias`, which retrieves the alias of a certificate in the KeyStore, `getCertificate`,
 * which retrieves the X509Certificate object from the KeyStore, `getSubject`, which retrieves the subject of the
 * certificate, and `getExpiration`, which retrieves the expiration date of the certificate. This interface can be
 * implemented by a class that provides the actual implementation of these methods.
 */
public interface KeyStoreParserService {

    /**
     * This function reads a KeyStore from an InputStream with a specified type and password.
     *
     * @param is               The input stream from which the KeyStore data will be read.
     * @param keyStoreType     keyStoreType is a string parameter that specifies the type of KeyStore to be used. It can be one
     *                         of the following values: "JKS" (Java KeyStore), "PKCS12" (Public-Key Cryptography Standards #12), "JCEKS" (Java
     *                         Cryptography Extension
     * @param keyStorePassword The password used to protect the integrity of the keystore. It is used to decrypt the
     *                         private keys and certificates stored in the keystore.
     * @return The method is returning a KeyStore object that represents a storage facility for cryptographic keys and
     * certificates.
     * @throws IOException              IOException
     * @throws KeyStoreException        KeyStoreException
     * @throws CertificateException     CertificateException
     * @throws NoSuchAlgorithmException NoSuchAlgorithmException
     */
    KeyStore read(InputStream is, String keyStoreType, String keyStorePassword) throws IOException, KeyStoreException, CertificateException, NoSuchAlgorithmException;

    /**
     * This function returns the alias of a KeyStore object in Java, and throws a KeyStoreException if there is an error.
     *
     * @param keyStore The `keyStore` parameter is an instance of the `KeyStore` class, which represents a storage facility
     *                 for cryptographic keys and certificates. It can be used to store, retrieve, and manage keys and certificates for use
     *                 in various security-related operations. The `getAlias` method is a method of
     * @return A String representing the alias of a key in the provided KeyStore.
     * @throws KeyStoreException KeyStoreException
     */
    String getAlias(KeyStore keyStore) throws KeyStoreException;

    /**
     * This function retrieves an X509 certificate from a KeyStore.
     *
     * @param keyStore The `keyStore` parameter is a reference to a `KeyStore` object, which is a repository of
     *                 cryptographic keys and certificates. It can be used to store, retrieve, and manage private keys, public keys, and
     *                 digital certificates. The `getCertificate` method takes a `KeyStore`
     * @return The method `getCertificate` returns an `X509Certificate` object from the specified `KeyStore`.
     */
    X509Certificate getCertificate(KeyStore keyStore) throws KeyStoreException;

    /**
     * The function returns the subject of a given KeyStore certificate.
     *
     * @param certificate The parameter "certificate" is of type KeyStore, which is a class in Java that represents a
     *                    storage facility for cryptographic keys and certificates. It can be used to store, retrieve, and manage digital
     *                    certificates and their associated private keys. In this method, the KeyStore parameter is used to retrieve
     *                    information
     * @return A string representing the subject of the certificate stored in the provided KeyStore object.
     * @throws KeyStoreException KeyStoreException
     */
    String getSubject(KeyStore certificate) throws KeyStoreException;

    /**
     * This function retrieves the expiration date of a KeyStore.
     *
     * @param keyStore The "keyStore" parameter is an instance of the Java KeyStore class, which represents a storage
     *                 facility for cryptographic keys and certificates. It can be used to store, retrieve, and manage keys and
     *                 certificates for various purposes, such as SSL/TLS encryption, code signing, and authentication. The "
     * @return The method `getExpiration` is expected to return a `Date` object that represents the expiration date of the
     * certificates in the specified `KeyStore`.
     * @throws KeyStoreException KeyStoreException
     */
    Date getExpiration(KeyStore keyStore) throws KeyStoreException;

    /**
     * The function getPasswordProtection returns a PasswordProtection object for a given password.
     *
     * @param password The password to protect the KeyStore.
     * @return The method is returning a PasswordProtection object.
     */
    KeyStore.PasswordProtection getPasswordProtection(String password);

    /**
     * The function returns a private key entry from a KeyStore using the specified alias and password.
     *
     * @param alias    The alias is a unique identifier for a specific entry in the keystore. It is used to retrieve the
     *                 private key entry associated with the alias.
     * @param password The password is a string that is used to protect the private key entry in the keystore. It is used
     *                 to verify the integrity of the keystore and to unlock the private key entry.
     * @param keyStore The `keyStore` parameter is an instance of the `KeyStore` class. It represents a storage facility
     *                 for cryptographic keys and certificates. It can be used to load, store, and manage keys and certificates.
     * @return The method is returning a KeyStore.PrivateKeyEntry object.
     */
    KeyStore.PrivateKeyEntry getPrivateKeyEntry(String alias, String password, KeyStore keyStore) throws KeyStoreException, UnrecoverableEntryException, NoSuchAlgorithmException;

}
