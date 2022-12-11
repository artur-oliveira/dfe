package com.softart.dfe.components.sefaz;

import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.interfaces.internal.config.CteConfig;
import com.softart.dfe.interfaces.internal.config.MdfeConfig;
import com.softart.dfe.interfaces.internal.config.NfConfig;
import com.softart.dfe.interfaces.sefaz.port.CteSoapService;
import com.softart.dfe.interfaces.sefaz.port.MdfeSoapService;
import com.softart.dfe.interfaces.sefaz.port.NfceSoapService;
import com.softart.dfe.interfaces.sefaz.port.NfeSoapService;

public abstract class SoapServiceFactory {

    public static SoapServiceFactory getInstance() {
        return SoapServiceFactoryHolder.SOAP_LOCATOR_IMPL;
    }

    public abstract NfeSoapService getNfeSoapService(NfConfig config) throws SoapServiceGeneralException;

    public abstract NfceSoapService getNfceSoapService(NfConfig config) throws SoapServiceGeneralException;

    public abstract CteSoapService getCteSoapService(CteConfig config) throws SoapServiceGeneralException;

    public abstract MdfeSoapService getMdfeSoapService(MdfeConfig config) throws SoapServiceGeneralException;

    private static class SoapServiceFactoryHolder {
        static final SoapServiceFactory SOAP_LOCATOR_IMPL = new SoapServiceLocatorImpl();
    }

}
