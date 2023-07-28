package com.softart.dfe.components.sefaz.port.nfe.impl;

import com.softart.dfe.components.sefaz.port.nfe.AbstractNfeSoapService;
import com.softart.dfe.enums.internal.nf.NfeAuthorizer;
import com.softart.dfe.interfaces.internal.config.NfConfig;

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
