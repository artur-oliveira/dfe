package org.dfe.components.sefaz.port.cte4.impl;

import org.dfe.components.sefaz.port.cte4.AbstractCte4SoapService;
import org.dfe.enums.internal.cte.Cte4Authorizer;

public final class Cte4SvrsSoapService extends AbstractCte4SoapService {
    @Override
    public Cte4Authorizer getAuthorizer() {
        return Cte4Authorizer.SVRS;
    }
}
