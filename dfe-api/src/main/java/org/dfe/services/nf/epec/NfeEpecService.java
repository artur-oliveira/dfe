package org.dfe.services.nf.epec;

import br.inf.portalfiscal.nfe.event_epec.TEnvEvento;
import br.inf.portalfiscal.nfe.event_epec.TUf;
import org.dfe.components.internal.xml.unmarshaller.NfUnmarshallerFactory;
import org.dfe.enums.nf.identification.NFType;
import org.dfe.exceptions.ProcessException;
import org.dfe.exceptions.ValidationException;
import org.dfe.exceptions.port.SoapServiceGeneralException;
import org.dfe.exceptions.security.SecurityException;
import org.dfe.exceptions.services.NoProviderFound;
import org.dfe.interfaces.internal.config.NfeConfig;
import org.dfe.interfaces.services.NfSefazService;
import org.dfe.interfaces.xml.XMLTransformer;
import org.dfe.models.nf.authorization.Nf;
import org.dfe.models.nf.epec.NfeEpec;
import org.dfe.models.nf.epec.NfeEpecRequest;
import org.dfe.models.nf.epec.ReturnNfeEpec;
import org.dfe.models.nf.epec.SendNfeEpec;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public interface NfeEpecService extends NfSefazService {

    /**
     * A function that sends an event to the Sefaz.
     *
     * @param tEnvEvento The object that contains the data to be sent to the SEFAZ.
     * @return A ReturnNfeEpec object.
     */
    default ReturnNfeEpec epec(TEnvEvento tEnvEvento) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        NfeConfig config = getConfig().withEnviroment(tEnvEvento.getEvento().stream().findFirst().map(it -> it.getInfEvento().getTpAmb()).orElse(getConfig().environment().getCode()));
        return ReturnNfeEpec.builder().build().fromObject(getProviderFactory()
                .getNfeService(config)
                .epec(NfeEpecRequest.builder().data(tEnvEvento)
                        .config(config)
                        .signer(getXmlSigner())
                        .validators(getValidatorFactory().nfeValidator().epecValidators())
                        .afterRequest(getProcess().afterEpec())
                        .beforeRequest(getProcess().beforeEpec())
                        .configureProvider(getConfigureProviderFactory()).build())
                .second());
    }

    /**
     * It converts the SendNfeEpec object to an object and then calls the epec function.
     *
     * @param sendNfeEpec Object of type SendNfeEpec, which contains the data to be sent to the Epec service.
     * @return ReturnNfeEpec
     */
    default ReturnNfeEpec epec(SendNfeEpec sendNfeEpec) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return epec(sendNfeEpec.toObject());
    }

    /**
     * Send a NfeEpec object to the Sefaz and return a ReturnNfeEpec object
     *
     * @param nfeEpec NfeEpec object with the data to be sent.
     * @return ReturnNfeEpec
     */
    default ReturnNfeEpec epec(NfeEpec nfeEpec) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return epec(SendNfeEpec.build(nfeEpec));
    }

    /**
     * A function that sends an event to the Sefaz.
     *
     * @param infEvento The event information.
     * @return ReturnNfeEpec
     */
    default ReturnNfeEpec epec(NfeEpec.InfEvento infEvento) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return epec(SendNfeEpec.build(infEvento));
    }

    /**
     * A function that sends an event to the NF-e.
     *
     * @param accessKey The access key of the NF-e.
     * @param detEvento The event to be sent.
     * @return ReturnNfeEpec
     */
    default ReturnNfeEpec epec(String accessKey, NfeEpec.InfEvento.DetEvento detEvento) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return epec(SendNfeEpec.build(accessKey, detEvento, getConfig()));
    }

    /**
     * It sends an Epec to the Sefaz.
     *
     * @param accessKey                  The access key of the NFe.
     * @param emissionDate               Date of emission of the document in the format yyyy-MM-dd
     * @param type                       NFType.NF_TYPE_ENTRADA or NFType.NF_TYPE_SAIDA
     * @param stateRegistration          State registration of the company that is sending the document.
     * @param uf                         The state of the sender.
     * @param cnpj                       CNPJ of the company that will receive the NFe.
     * @param cpf                        CPF of the recipient
     * @param foreignId                  The foreignId is the number of the foreign document that is being replaced.
     * @param recipientStateRegistration State registration of the recipient.
     * @param totalValue                 Total value of the invoice
     * @param totalIcms                  Total ICMS value
     * @param totalIcmsSt                Total ICMS ST
     * @return ReturnNfeEpec
     */
    default ReturnNfeEpec epec(String accessKey, String emissionDate, NFType type, String stateRegistration, TUf uf, String cnpj, String cpf, String foreignId, String recipientStateRegistration, String totalValue, String totalIcms, String totalIcmsSt) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return epec(SendNfeEpec.build(accessKey, emissionDate, type, stateRegistration, uf, cnpj, cpf, foreignId, recipientStateRegistration, totalValue, totalIcms, totalIcmsSt, getConfig()));
    }

    /**
     * A function that receives a parameter of type Nf and returns a ReturnNfeEpec.
     *
     * @param n The NF object to be sent.
     * @return ReturnNfeEpec
     */
    default ReturnNfeEpec epec(Nf n) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return epec(Collections.singletonList(n));
    }

    /**
     * "Send a list of invoices to the Epec service and return the result."
     *
     * @param nfs List of NF objects
     * @return ReturnNfeEpec
     */
    default ReturnNfeEpec epec(List<Nf> nfs) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return epec(SendNfeEpec.build(nfs, getConfig()));
    }

    /**
     * It sends an Epec to the Sefaz
     *
     * @param transformer The transformer that will be used to transform the XML into a Nf object.
     * @param xml         The XML of the NF-e to be sent.
     * @return ReturnNfeEpec
     */
    default ReturnNfeEpec epec(XMLTransformer<Nf> transformer, String xml) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return epec(transformer.transform(xml));
    }

    /**
     * Given an XML string, return an Epec object
     *
     * @param xml The XML of the NF-e to be converted to Epec.
     * @return ReturnNfeEpec
     */
    default ReturnNfeEpec epecFromNfe(String xml) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return epec((o) -> Nf.builder().build().fromObject(NfUnmarshallerFactory.getInstance().nfe(o).getValue()), xml);
    }

    /**
     * It receives an XML string, converts it to a list of NF objects, and then calls the epec function
     *
     * @param xml XML of the NF-e to be canceled.
     * @return ReturnNfeEpec
     */
    default ReturnNfeEpec epecFromEnviNfe(String xml) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return epec(NfUnmarshallerFactory.getInstance().enviNfe(xml).getValue().getNFe().stream().map(it -> Nf.builder().build().fromObject(it)).collect(Collectors.toList()));
    }

    @Override
    NfeConfig getConfig();
}
