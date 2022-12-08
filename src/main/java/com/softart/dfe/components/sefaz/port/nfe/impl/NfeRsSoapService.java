package com.softart.dfe.components.sefaz.port.nfe.impl;

import com.softart.dfe.components.sefaz.port.nfe.AbstractNfeSoapService;
import com.softart.dfe.enums.internal.nf.NfeAuthorizer;
import com.softart.dfe.interfaces.internal.config.NfConfig;

public final class NfeRsSoapService extends AbstractNfeSoapService {
    public NfeRsSoapService(NfConfig config) {
        super(config);
    }

    public NfeRsSoapService() {
        super();
    }

    @Override
    public NfeAuthorizer getAuthorizer() {
        return NfeAuthorizer.RS;
    }
}
