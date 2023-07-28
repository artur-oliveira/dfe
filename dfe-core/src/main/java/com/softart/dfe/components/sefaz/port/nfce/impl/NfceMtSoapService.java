package com.softart.dfe.components.sefaz.port.nfce.impl;

import com.softart.dfe.components.sefaz.port.nfce.AbstractNfceSoapService;
import com.softart.dfe.enums.internal.nf.NfceAuthorizer;
import com.softart.dfe.interfaces.internal.config.NfConfig;

public final class NfceMtSoapService extends AbstractNfceSoapService {

    public NfceMtSoapService() {
    }

    public NfceMtSoapService(NfConfig config) {
        super(config);
    }

    @Override
    public NfceAuthorizer getAuthorizer() {
        return NfceAuthorizer.MT;
    }
}
