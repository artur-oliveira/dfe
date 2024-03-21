package org.dfe.interfaces.xml.objectfactory;

public interface CteObjectFactoryWrapper {
    br.inf.portalfiscal.cte.distribution.ObjectFactory getDistributionObjectFactory();

    br.inf.portalfiscal.cte.send400.ObjectFactory getCte4ObjectFactory();

    br.inf.portalfiscal.cte.send400.TCteProc cteProc400();
}
