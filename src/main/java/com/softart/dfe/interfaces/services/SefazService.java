package com.softart.dfe.interfaces.services;

import com.softart.dfe.components.sefaz.DfeFactory;
import com.softart.dfe.components.validation.ValidatorFactory;
import com.softart.dfe.components.wsdl.ConfigureProviderFactory;
import com.softart.dfe.interfaces.internal.config.Config;
import com.softart.dfe.interfaces.process.DfProcess;
import com.softart.dfe.interfaces.xml.XMLSigner;

public interface SefazService {

    Config getConfig();

    XMLSigner getXmlSigner();

    DfProcess getProcess();

    DfeFactory getProviderFactory();

    ValidatorFactory getValidatorFactory();

    ConfigureProviderFactory getConfigureProviderFactory();

}
