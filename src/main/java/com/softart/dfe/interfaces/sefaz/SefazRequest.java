package com.softart.dfe.interfaces.sefaz;

import com.softart.dfe.interfaces.internal.config.Config;
import com.softart.dfe.interfaces.process.AfterWebServiceRequest;
import com.softart.dfe.interfaces.process.BeforeWebServiceRequest;
import com.softart.dfe.interfaces.validation.Validator;
import com.softart.dfe.interfaces.wsdl.ConfigureProvider;
import com.softart.dfe.interfaces.xml.XML;
import com.softart.dfe.interfaces.xml.XMLSigner;

import java.util.Collection;

public interface SefazRequest<SEND extends XML, RETURN extends XML> {

    SEND getData();

    Config getConfig();

    Collection<? extends Validator<SEND>> getValidators();

    XMLSigner getSigner();

    ConfigureProvider getConfigureProvider();

    Collection<? extends BeforeWebServiceRequest<SEND>> getBeforeRequest();

    Collection<? extends AfterWebServiceRequest<SEND, RETURN>> getAfterRequest();

}
