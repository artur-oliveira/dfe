package com.softart.dfe.components.sefaz.port.mdfe.impl;

import com.softart.dfe.components.sefaz.port.mdfe.AbstractMdfeSoapService;
import com.softart.dfe.enums.internal.mdfe.MdfeAuthorizer;

public final class MdfeSvrsSoapService extends AbstractMdfeSoapService {
    @Override
    public MdfeAuthorizer getAuthorizer() {
        return MdfeAuthorizer.SVRS;
    }
}
