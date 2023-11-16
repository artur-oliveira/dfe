package org.dfe.components.sefaz.port.nfe.impl;

import org.dfe.components.sefaz.port.nfe.AbstractNfeSoapService;
import org.dfe.enums.internal.nf.NfeAuthorizer;
import org.dfe.interfaces.internal.config.NfConfig;

public final class NfeSvrcsSoapService extends AbstractNfeSoapService {
    public NfeSvrcsSoapService(NfConfig config) {
        super(config);
    }

    public NfeSvrcsSoapService() {
        super();
    }

    @Override
    public NfeAuthorizer getAuthorizer() {
        return NfeAuthorizer.SVCRS;
    }

    @Override
    public NfeAuthorizer getServiceFinderAuthorizer() {
        return NfeAuthorizer.SVRS;
    }
}
