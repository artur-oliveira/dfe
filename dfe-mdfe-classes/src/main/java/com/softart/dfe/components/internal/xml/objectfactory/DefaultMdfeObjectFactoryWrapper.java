package com.softart.dfe.components.internal.xml.objectfactory;

import br.inf.portalfiscal.mdfe.classes.TMdfeProc;
import lombok.Getter;

@Getter
final class DefaultMdfeObjectFactoryWrapper extends MdfeObjectFactoryWrapperFactory {

    private final br.inf.portalfiscal.mdfe.classes.ObjectFactory objectFactory = new br.inf.portalfiscal.mdfe.classes.ObjectFactory();
    private final br.inf.portalfiscal.mdfe.distribution.ObjectFactory distributionObjectFactory = new br.inf.portalfiscal.mdfe.distribution.ObjectFactory();

    @Override
    public TMdfeProc mdfeProc() {
        return getObjectFactory().createTMdfeProc();
    }
}

