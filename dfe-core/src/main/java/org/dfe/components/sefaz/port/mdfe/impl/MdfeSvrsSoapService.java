package org.dfe.components.sefaz.port.mdfe.impl;

import org.dfe.components.sefaz.port.mdfe.AbstractMdfeSoapService;
import org.dfe.enums.internal.mdfe.MdfeAuthorizer;

public final class MdfeSvrsSoapService extends AbstractMdfeSoapService {
    @Override
    public MdfeAuthorizer getAuthorizer() {
        return MdfeAuthorizer.SVRS;
    }
}
