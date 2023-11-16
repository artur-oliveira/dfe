package org.dfe.components.sefaz.port.nfce.impl;

import org.dfe.components.sefaz.port.nfce.AbstractNfceSoapService;
import org.dfe.enums.internal.nf.NfceAuthorizer;
import org.dfe.interfaces.internal.config.NfConfig;

public final class NfceAmSoapService extends AbstractNfceSoapService {

    public NfceAmSoapService() {
    }

    public NfceAmSoapService(NfConfig config) {
        super(config);
    }

    @Override
    public NfceAuthorizer getAuthorizer() {
        return NfceAuthorizer.AM;
    }
}
