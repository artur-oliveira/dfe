package com.softart.dfe.interfaces.security;

public interface CertificateChainService {

    byte[] generate(CertificateChain generate);

    String getPassword();

}
