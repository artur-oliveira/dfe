package com.softart.dfe.components.sefaz.port.nfce.impl;

import com.softart.dfe.components.sefaz.port.nfce.AbstractNfceSoapService;
import com.softart.dfe.enums.internal.nf.NfceAuthorizer;
import com.softart.dfe.interfaces.internal.config.NfConfig;

public final class NfceMsSoapService extends AbstractNfceSoapService {

    public NfceMsSoapService() {
    }

    public NfceMsSoapService(NfConfig config) {
        super(config);
    }

    @Override
    public NfceAuthorizer getAuthorizer() {
        return NfceAuthorizer.MS;
    }
}
