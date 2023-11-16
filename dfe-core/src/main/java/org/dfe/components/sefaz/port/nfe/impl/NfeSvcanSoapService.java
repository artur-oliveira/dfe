package org.dfe.components.sefaz.port.nfe.impl;

import org.dfe.components.sefaz.port.nfe.AbstractNfeSoapService;
import org.dfe.enums.internal.nf.NfeAuthorizer;
import org.dfe.interfaces.internal.config.NfConfig;

public final class NfeSvcanSoapService extends AbstractNfeSoapService {
    public NfeSvcanSoapService(NfConfig config) {
        super(config);
    }

    public NfeSvcanSoapService() {
        super();
    }

    @Override
    public NfeAuthorizer getAuthorizer() {
        return NfeAuthorizer.SVCAN;
    }
}
