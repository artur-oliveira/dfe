package org.dfe.components.sefaz.port.nfe.impl;

import org.dfe.components.sefaz.port.nfe.AbstractNfeSoapService;
import org.dfe.enums.internal.nf.NfeAuthorizer;
import org.dfe.interfaces.internal.config.NfConfig;

public final class NfeAnSoapService extends AbstractNfeSoapService {
    public NfeAnSoapService(NfConfig config) {
        super(config);
    }

    public NfeAnSoapService() {
        super();
    }

    @Override
    public NfeAuthorizer getAuthorizer() {
        return NfeAuthorizer.AN;
    }
}
