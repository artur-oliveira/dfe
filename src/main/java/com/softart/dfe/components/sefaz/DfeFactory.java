package com.softart.dfe.components.sefaz;

import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.interfaces.internal.config.CteConfig;
import com.softart.dfe.interfaces.internal.config.NfConfig;
import com.softart.dfe.interfaces.sefaz.cte.CteService;
import com.softart.dfe.interfaces.sefaz.nf.nfce.NfceService;
import com.softart.dfe.interfaces.sefaz.nf.nfe.NfeService;

public abstract class DfeFactory {

    public static DfeFactory getInstance() {
        return DfeFactoryHolder.DFE_LOCATOR_IMPL;
    }

    public abstract NfeService getNfeService(NfConfig config) throws NoProviderFound, SoapServiceGeneralException;

    public abstract NfceService getNfceService(NfConfig config) throws NoProviderFound, SoapServiceGeneralException;

    public abstract CteService getCteService(CteConfig config) throws NoProviderFound, SoapServiceGeneralException;

    private static class DfeFactoryHolder {
        static final DfeFactory DFE_LOCATOR_IMPL = new DfeLocatorImpl();
    }

}
