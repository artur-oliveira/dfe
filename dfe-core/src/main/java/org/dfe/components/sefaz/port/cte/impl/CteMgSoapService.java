package org.dfe.components.sefaz.port.cte.impl;

import org.dfe.components.sefaz.port.cte.AbstractCteSoapService;
import org.dfe.enums.internal.cte.CteAuthorizer;

public final class CteMgSoapService extends AbstractCteSoapService {
    @Override
    public CteAuthorizer getAuthorizer() {
        return CteAuthorizer.MG;
    }
}
