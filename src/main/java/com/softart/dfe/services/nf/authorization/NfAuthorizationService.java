package com.softart.dfe.services.nf.authorization;

import br.inf.portalfiscal.nfe.send.TEnviNFe;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.interfaces.sefaz.nf.common.NfCommonService;
import com.softart.dfe.interfaces.services.NfSefazService;
import com.softart.dfe.interfaces.validation.nf.common.NfCommonValidator;
import com.softart.dfe.interfaces.xml.XMLTransformer;
import com.softart.dfe.models.nf.authorization.Nf;
import com.softart.dfe.models.nf.authorization.NfAuthorizationRequest;
import com.softart.dfe.models.nf.authorization.ReturnNf;
import com.softart.dfe.components.internal.xml.unmarshaller.NfUnmarshaller;

import java.util.Collection;
import java.util.Collections;

public interface NfAuthorizationService extends NfSefazService {

    TEnviNFe getEnviNfe(Collection<Nf> nfs) throws ProcessException;


    default ReturnNf authorization(TEnviNFe enviNFe) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return ReturnNf
                .builder()
                .build()
                .fromObject(getService()
                        .authorize(NfAuthorizationRequest
                                .builder()
                                .data(enviNFe)
                                .config(getConfig())
                                .afterRequest(getProcess().afterAuthorization())
                                .beforeRequest(getProcess().beforeAuthorization())
                                .signer(getXmlSigner())
                                .configureProvider(getConfigureProviderFactory())
                                .validators(getValidator().authorizationValidators())
                                .build()).second());
    }

    default ReturnNf authorization(Collection<Nf> nfe) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return authorization(getEnviNfe(nfe));
    }

    default ReturnNf authorization(Nf nfe) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return authorization(Collections.singleton(nfe));
    }

    default ReturnNf authorization(String xml, XMLTransformer<Nf> xmlTransformer) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return authorization(xmlTransformer.transform(xml));
    }

    default ReturnNf authorizationFromEnviNfe(String xml) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return authorization(xml, x -> Nf.builder().build().fromObject(NfUnmarshaller.enviNfe(xml).getValue().getNFe().get(0)));
    }

    default ReturnNf authorizationFromNfe(String xml) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return authorization(xml, x -> Nf.builder().build().fromObject(NfUnmarshaller.nfe(xml).getValue()));
    }

    NfCommonService getService() throws NoProviderFound, SoapServiceGeneralException;

    NfCommonValidator getValidator();
}
