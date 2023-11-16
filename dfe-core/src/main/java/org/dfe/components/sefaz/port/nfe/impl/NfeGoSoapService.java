package org.dfe.components.sefaz.port.nfe.impl;

import org.dfe.components.sefaz.port.nfe.AbstractNfeSoapService;
import org.dfe.enums.internal.nf.NfeAuthorizer;
import org.dfe.interfaces.internal.config.NfConfig;

public final class NfeGoSoapService extends AbstractNfeSoapService {
    public NfeGoSoapService(NfConfig config) {
        super(config);
    }

    public NfeGoSoapService() {
        super();
    }

    @Override
    public NfeAuthorizer getAuthorizer() {
        return NfeAuthorizer.GO;
    }
}
