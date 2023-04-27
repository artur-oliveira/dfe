package com.softart.dfe.interfaces.security;

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
