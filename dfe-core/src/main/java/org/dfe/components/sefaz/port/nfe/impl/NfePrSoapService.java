package org.dfe.components.sefaz.port.nfe.impl;

import org.dfe.components.sefaz.port.nfe.AbstractNfeSoapService;
import org.dfe.enums.internal.nf.NfeAuthorizer;
import org.dfe.interfaces.internal.config.NfConfig;

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
