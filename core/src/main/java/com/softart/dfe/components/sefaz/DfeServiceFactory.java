package com.softart.dfe.components.sefaz;

import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.interfaces.internal.config.CteConfig;
import com.softart.dfe.interfaces.internal.config.MdfeConfig;
import com.softart.dfe.interfaces.internal.config.NfConfig;
import com.softart.dfe.interfaces.sefaz.cte.CteService;
import com.softart.dfe.interfaces.sefaz.mdfe.MdfeService;
import com.softart.dfe.interfaces.sefaz.nf.nfce.NfceService;
import com.softart.dfe.interfaces.sefaz.nf.nfe.NfeService;
import com.softart.dfe.interfaces.services.DfeService;

public abstract class DfeServiceFactory implements DfeService {

    /**
     * If the DfeFactoryHolder class has not been loaded, load it. If the DfeFactoryHolder class has been loaded, but the
     * DFE_LOCATOR_IMPL field has not been initialized, initialize it. If the DFE_LOCATOR_IMPL field has been initialized,
     * return it.
     *
     * @return The DfeFactoryHolder.DFE_LOCATOR_IMPL is being returned.
     */
    public static DfeServiceFactory getInstance() {
        return DfeFactoryHolder.DFE_LOCATOR_IMPL;
    }

    private static class DfeFactoryHolder {
        static final DfeServiceFactory DFE_LOCATOR_IMPL = new DefaultDfeServiceImpl();
    }

}
