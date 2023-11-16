package org.dfe.components.security.chain;

import org.dfe.interfaces.security.CertificateChainService;

public abstract class CertificateChainFactory implements CertificateChainService {

    public static CertificateChainFactory getInstance() {
        return CertificateChainHolder.INSTANCE;
    }

    private static class CertificateChainHolder {
        static final CertificateChainFactory INSTANCE = new CertificateChainServiceImpl();
    }

}
