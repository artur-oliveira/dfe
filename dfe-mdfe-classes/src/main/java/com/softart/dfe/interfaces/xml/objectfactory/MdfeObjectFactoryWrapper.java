package com.softart.dfe.interfaces.xml.objectfactory;

import br.inf.portalfiscal.mdfe.classes.TMdfeProc;

public interface MdfeObjectFactoryWrapper {
    br.inf.portalfiscal.mdfe.classes.ObjectFactory getObjectFactory();

    br.inf.portalfiscal.mdfe.distribution.ObjectFactory getDistributionObjectFactory();

    TMdfeProc mdfeProc();
}
