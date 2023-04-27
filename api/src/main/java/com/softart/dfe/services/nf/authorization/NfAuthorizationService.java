package com.softart.dfe.services.nf.authorization;

import br.inf.portalfiscal.nfe.send.TEnviNFe;
import com.softart.dfe.components.internal.xml.unmarshaller.NfUnmarshallerFactory;
import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.interfaces.internal.config.NfConfig;
import com.softart.dfe.interfaces.sefaz.nf.common.NfCommonService;
import com.softart.dfe.interfaces.services.NfSefazService;
import com.softart.dfe.interfaces.validation.nf.common.NfCommonValidator;
import com.softart.dfe.interfaces.xml.XMLTransformer;
import com.softart.dfe.models.nf.authorization.Nf;
import com.softart.dfe.models.nf.authorization.NfAuthorizationRequest;
import com.softart.dfe.models.nf.authorization.ReturnSendNf;
import com.softart.dfe.models.nf.authorization.SendNf;

import java.util.Collection;
import java.util.Collections;

public interface NfAuthorizationService extends NfSefazService {

    /**
     * "Builds an EnviNFe object from a collection of NFs."
     *
     * @param nfs Collection of NF objects
     * @return The method is returning an object of type TEnviNFe.
     */
    default TEnviNFe getEnviNfe(Collection<Nf> nfs) {
        return SendNf.build(nfs, getConfig(), getXmlSigner()).toObject();
    }

    /**
     * A function that authorizes a NF-e.
     *
     * @param enviNFe The object that contains the data to be sent to the SEFAZ.
     * @return A ReturnSendNf object.
     */
    default ReturnSendNf authorization(TEnviNFe enviNFe) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        NfConfig config = getConfig().withEnviroment(enviNFe.getNFe().stream().findFirst().map(it -> it.getInfNFe().getIde().getTpAmb()).orElse(getConfig().environment().getCode()));
        return ReturnSendNf
                .builder()
                .build()
                .fromObject(getService(config.environment())
                        .authorize(NfAuthorizationRequest
                                .builder()
                                .data(enviNFe)
                                .config(config)
                                .afterRequest(getProcess().afterAuthorization())
                                .beforeRequest(getProcess().beforeAuthorization())
                                .signer(getXmlSigner())
                                .configureProvider(getConfigureProviderFactory())
                                .validators(getValidator().authorizationValidators())
                                .build()).second());
    }

    /**
     * A function that receives a collection of NFs and returns a ReturnSendNf object.
     *
     * @param nfe Collection of NF objects
     * @return ReturnSendNf
     */
    default ReturnSendNf authorization(Collection<Nf> nfe) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return authorization(getEnviNfe(nfe));
    }

    /**
     * A default method in the interface.
     *
     * @param nfe Nf object
     * @return ReturnSendNf
     */
    default ReturnSendNf authorization(Nf nfe) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return authorization(Collections.singleton(nfe));
    }

    /**
     * It takes an XML string and transforms it into an object of type Nf.
     *
     * @param xml            The XML to be transformed.
     * @param xmlTransformer A class that implements the XMLTransformer interface. This class is responsible for
     *                       transforming the XML into a Java object.
     * @return The return type is the class ReturnSendNf.
     */
    default ReturnSendNf authorization(String xml, XMLTransformer<Nf> xmlTransformer) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return authorization(xmlTransformer.transform(xml));
    }

    /**
     * Authorize a NFe from a XML string.
     *
     * @param xml XML string containing the NF-e to be sent.
     * @return ReturnSendNf
     */
    default ReturnSendNf authorizationFromEnviNfe(String xml) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return authorization(NfUnmarshallerFactory.getInstance().enviNfe(xml).getValue());
    }

    /**
     * "Authorize a NF-e from a XML string."
     * <p>
     * The first parameter is the XML string. The second parameter is a lambda expression that receives the XML string and
     * returns a NF-e object
     *
     * @param xml The XML of the NF-e to be sent.
     * @return ReturnSendNf
     */
    default ReturnSendNf authorizationFromNfe(String xml) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return authorization(xml, x -> Nf.builder().build().fromObject(NfUnmarshallerFactory.getInstance().nfe(xml).getValue()));
    }

    NfCommonService getService(Environment environment) throws NoProviderFound, SoapServiceGeneralException;

    NfCommonValidator getValidator();
}
