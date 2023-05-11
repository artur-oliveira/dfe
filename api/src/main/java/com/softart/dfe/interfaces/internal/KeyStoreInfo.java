package com.softart.dfe.interfaces.internal;

import com.softart.dfe.enums.internal.KeyType;
import com.softart.dfe.exceptions.security.CertificateException;

import java.io.InputStream;
import java.security.KeyStore;
import java.time.ZonedDateTime;

/**
 * Defining a Java interface named `KeyStoreInfo`. This interface contains several methods that define the behavior of a
 * class that implements this interface. The methods are related to loading and retrieving certificates and certificate
 * chains from input streams, as well as retrieving information about the certificates such as their expiration date and
 * alias.
 */
public interface KeyStoreInfo {

    /**
     * Loads a certificate from the given input stream
     *
     * @param inputStream The input stream of the certificate.
     * @param type        The type of the certificate. For example, X.509.
     */
    void loadCertificate(InputStream inputStream, String type) throws CertificateException;

    /**
     * Loads a certificate from an input stream
     *
     * @param inputStream The input stream of the certificate file.
     */
    default void loadCertificate(InputStream inputStream) throws CertificateException {
        loadCertificate(inputStream, KeyType.PFX.getType());
    }


    /**
     * Loads a certificate chain from the specified input stream
     *
     * @param inputStream The input stream containing the certificates.
     * @param type        The type of the certificate chain.
     */
    void loadCertificateChain(InputStream inputStream, String type) throws CertificateException;

    /**
     * Loads a certificate chain from an input stream.
     *
     * @param inputStream The input stream of the certificate chain file.
     */
    default void loadCertificateChain(InputStream inputStream) throws CertificateException {
        loadCertificateChain(inputStream, KeyType.JKS.getType());
    }

    /**
     * This function returns a KeyStore object that contains the certificate that was used to sign the JAR file.
     *
     * @return A KeyStore object.
     */
    KeyStore certificate() throws CertificateException;

    /**
     * Returns the password for the certificate
     *
     * @return The password for the certificate.
     */
    String certificatePassword();

    /**
     * Returns the certificate chain associated with this keystore entry.
     *
     * @return A KeyStore object that contains the certificate chain.
     */
    KeyStore certificateChain() throws CertificateException;

    /**
     * Returns the password for the certificate chain file
     *
     * @return A String
     */
    String certificateChainPassword();

    /**
     * Returns the alias of the certificate.
     *
     * @return The alias of the certificate.
     */
    String getAlias();

    ZonedDateTime getExpiration();

}
