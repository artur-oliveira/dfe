package com.softart.dfe.interfaces.security;

/**
 * The code is defining a Java interface called `CertificateChainService`. This interface declares two methods: `generate`
 * and `getPassword`. Any class that implements this interface must provide implementations for these two methods. The
 * `generate` method takes a `CertificateChain` object as input and returns a byte array. The `getPassword` method returns
 * a String.
 */
public interface CertificateChainService {

    /**
     * Generates a certificate chain from the given certificate chain
     *
     * @param generate The certificate chain to be generated.
     * @return A byte array of the certificate chain.
     */
    byte[] generate(CertificateChain generate);

    /**
     * This function returns the password.
     *
     * @return The password.
     */
    String getPassword();

}
