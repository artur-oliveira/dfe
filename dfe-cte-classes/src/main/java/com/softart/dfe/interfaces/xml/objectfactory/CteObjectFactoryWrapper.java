package com.softart.dfe.interfaces.xml.objectfactory;

public interface CteObjectFactoryWrapper {
    br.inf.portalfiscal.cte.distribution.ObjectFactory getDistributionObjectFactory();

    br.inf.portalfiscal.cte.send.ObjectFactory getCteObjectFactory();

    br.inf.portalfiscal.cte.send400.ObjectFactory getCte4ObjectFactory();

    br.inf.portalfiscal.cte.send400.TCteProc cteProc400();

    br.inf.portalfiscal.cte.send.TCteProc cteProc();
}
