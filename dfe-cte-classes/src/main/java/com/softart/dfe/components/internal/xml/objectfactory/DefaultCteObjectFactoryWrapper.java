package com.softart.dfe.components.internal.xml.objectfactory;

import br.inf.portalfiscal.cte.send.TCteProc;
import lombok.Getter;

@Getter
final class DefaultCteObjectFactoryWrapper extends CteObjectFactoryWrapperFactory {

    private final br.inf.portalfiscal.cte.distribution.ObjectFactory distributionObjectFactory = new br.inf.portalfiscal.cte.distribution.ObjectFactory();
    private final br.inf.portalfiscal.cte.send.ObjectFactory cteObjectFactory = new br.inf.portalfiscal.cte.send.ObjectFactory();
    private final br.inf.portalfiscal.cte.send400.ObjectFactory cte4ObjectFactory = new br.inf.portalfiscal.cte.send400.ObjectFactory();

    @Override
    public TCteProc cteProc() {
        return getCteObjectFactory().createTCteProc();
    }

    @Override
    public br.inf.portalfiscal.cte.send400.TCteProc cteProc400() {
        return getCte4ObjectFactory().createTCteProc();
    }
}
