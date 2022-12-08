package com.softart.dfe.components.sefaz.port.nfe.impl;

import com.softart.dfe.components.sefaz.port.nfe.AbstractNfeSoapService;
import com.softart.dfe.enums.internal.nf.NfeAuthorizer;
import com.softart.dfe.interfaces.internal.config.NfConfig;

public final class NfePrSoapService extends AbstractNfeSoapService {
    public NfePrSoapService(NfConfig config) {
        super(config);
    }

    public NfePrSoapService() {
        super();
    }

    @Override
    public NfeAuthorizer getAuthorizer() {
        return NfeAuthorizer.PR;
    }
}
