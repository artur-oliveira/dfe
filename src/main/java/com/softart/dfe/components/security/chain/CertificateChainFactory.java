package com.softart.dfe.components.security.chain;

import com.softart.dfe.interfaces.security.CertificateChainService;

public abstract class CertificateChainFactory implements CertificateChainService {

    public static CertificateChainFactory getInstance() {
        return CertificateChainHolder.INSTANCE;
    }

    private static class CertificateChainHolder {
        static final CertificateChainFactory INSTANCE = new CertificateChainServiceImpl();
    }

}
