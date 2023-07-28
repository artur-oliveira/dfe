package com.softart.dfe.interfaces.internal;

import javax.net.ssl.TrustManager;
import javax.net.ssl.X509KeyManager;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.time.ZonedDateTime;

/**
 * Defining a Java interface named `KeyStoreInfo`. This interface contains several methods that define the behavior of a
 * class that implements this interface. The methods are related to loading and retrieving certificates and certificate
 * chains from input streams, as well as retrieving information about the certificates such as their expiration date and
 * alias.
 */
public interface KeyStoreInfo {

    /**
     * Returns the alias of the certificate.
     *
     * @return The alias of the certificate.
     */
    String getAlias();

    /**
     * The function `getKeyEntry()` returns a `KeyStore.PrivateKeyEntry` object.
     *
     * @return The method `getKeyEntry()` is returning a `KeyStore.PrivateKeyEntry` object.
     */
    KeyStore.PrivateKeyEntry getKeyEntry();

    /**
     * The function `getKeyManagers()` returns an array of X509KeyManager objects.
     *
     * @return An array of X509KeyManager objects is being returned.
     */
    X509KeyManager[] getKeyManagers();

    /**
     * The function "getTrustManagers" returns an array of TrustManagers.
     *
     * @return An array of TrustManager objects is being returned.
     */
    TrustManager[] getTrustManagers();

    /**
     * The function returns the private key associated with a key entry.
     *
     * @return The private key associated with the key entry.
     */
    default PrivateKey getKeyEntryPrivateKey() {
        return getKeyEntry().getPrivateKey();
    }

    /**
     * The function returns the X509Certificate associated with the key entry.
     *
     * @return The method is returning an X509Certificate object.
     */
    default X509Certificate getKeyEntryCertificate() {
        return (X509Certificate) getKeyEntry().getCertificate();
    }

    /**
     * The function "getExpiration" returns a ZonedDateTime object representing the expiration date.
     *
     * @return The method getExpiration() is returning a ZonedDateTime object.
     */
    ZonedDateTime getExpiration();

}
