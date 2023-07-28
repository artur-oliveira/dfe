package com.softart.dfe.components.sefaz.port.cte4.impl;

import com.softart.dfe.components.sefaz.port.cte4.AbstractCte4SoapService;
import com.softart.dfe.enums.internal.cte.Cte4Authorizer;

public final class Cte4MtSoapService extends AbstractCte4SoapService {
    @Override
    public Cte4Authorizer getAuthorizer() {
        return Cte4Authorizer.MT;
    }
}
