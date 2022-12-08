package com.softart.dfe.components.sefaz.port.nfce.impl;

import com.softart.dfe.components.sefaz.port.nfce.AbstractNfceSoapService;
import com.softart.dfe.enums.internal.nf.NfceAuthorizer;
import com.softart.dfe.interfaces.internal.config.NfConfig;

public final class NfceSvrsSoapService extends AbstractNfceSoapService {

    public NfceSvrsSoapService() {
    }

    public NfceSvrsSoapService(NfConfig config) {
        super(config);
    }

    @Override
    public NfceAuthorizer getAuthorizer() {
        return NfceAuthorizer.SVRS;
    }
}
