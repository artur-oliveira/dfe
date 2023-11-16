package org.dfe.components.sefaz.port.nfe.impl;

import org.dfe.components.sefaz.port.nfe.AbstractNfeSoapService;
import org.dfe.enums.internal.nf.NfeAuthorizer;
import org.dfe.interfaces.internal.config.NfConfig;

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
