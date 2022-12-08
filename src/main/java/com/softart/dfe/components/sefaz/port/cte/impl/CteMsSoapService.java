package com.softart.dfe.components.sefaz.port.cte.impl;

import com.softart.dfe.components.sefaz.port.cte.AbstractCteSoapService;
import com.softart.dfe.enums.internal.cte.CteAuthorizer;

public final class CteMsSoapService extends AbstractCteSoapService {
    @Override
    public CteAuthorizer getAuthorizer() {
        return CteAuthorizer.MS;
    }
}
