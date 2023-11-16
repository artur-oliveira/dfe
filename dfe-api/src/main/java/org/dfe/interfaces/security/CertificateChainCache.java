package org.dfe.interfaces.security;

import java.io.IOException;

/**
 * Declaring a public interface named `CertificateChainCache`. This interface defines two methods: `getFromCache` and
 * `addToCache`. The purpose of this interface is to provide a contract for classes that implement it to define how to
 * retrieve and store certificate chains in a cache.
 */
public interface CertificateChainCache {

    /**
     * The function returns a byte array from cache based on a given certificate chain and may throw an IOException.
     *
     * @param certificateChain certificateChain is a data structure that contains a chain of X.509 certificates, where each
     *                         certificate in the chain (except the root certificate) is signed by the private key of the next certificate in the
     *                         chain. This chain of certificates is used to establish trust between parties in a secure communication. The byte
     * @return A byte array containing the data retrieved from the cache for the given certificate chain.
     * @throws IOException IOException
     */
    byte[] getFromCache(CertificateChain certificateChain) throws IOException;

    /**
     * This function adds a certificate chain and its corresponding byte array to a cache.
     *
     * @param generate The "generate" parameter is of type CertificateChain, which is likely a class representing a chain
     *                 of digital certificates. It is used as a reference to the certificate chain that is being added to the cache.
     * @param bytes    The parameter "bytes" is a byte array that contains the binary data of a certificate chain. This byte
     *                 array is used to store the certificate chain in a cache.
     * @throws IOException IOException
     */
    void addToCache(CertificateChain generate, byte[] bytes) throws IOException;


}
