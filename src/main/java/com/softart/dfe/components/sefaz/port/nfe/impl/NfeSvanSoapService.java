package com.softart.dfe.components.sefaz.port.nfe.impl;

import com.softart.dfe.components.sefaz.port.nfe.AbstractNfeSoapService;
import com.softart.dfe.enums.internal.nf.NfeAuthorizer;
import com.softart.dfe.interfaces.internal.config.NfConfig;

public final class NfeSvanSoapService extends AbstractNfeSoapService {
    public NfeSvanSoapService(NfConfig config) {
        super(config);
    }

    public NfeSvanSoapService() {
        super();
    }

    @Override
    public NfeAuthorizer getAuthorizer() {
        return NfeAuthorizer.SVAN;
    }
}
