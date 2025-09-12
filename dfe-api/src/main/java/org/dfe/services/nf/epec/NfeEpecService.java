package org.dfe.services.nf.epec;

import br.inf.portalfiscal.nfe.event_generic.TEnvEvento;
import br.inf.portalfiscal.nfe.event_generic.TRetEnvEvento;
import br.inf.portalfiscal.nfe.send.TUf;
import org.dfe.components.internal.xml.unmarshaller.NfUnmarshallerFactory;
import org.dfe.enums.internal.Model;
import org.dfe.enums.internal.UF;
import org.dfe.enums.internal.nf.NfeAuthorizer;
import org.dfe.enums.nf.identification.NFType;
import org.dfe.exceptions.CircuitBreakerException;
import org.dfe.exceptions.ProcessException;
import org.dfe.exceptions.ValidationException;
import org.dfe.exceptions.port.SoapServiceGeneralException;
import org.dfe.exceptions.security.SecurityException;
import org.dfe.exceptions.services.NoProviderFound;
import org.dfe.interfaces.circuitbreaker.DfeOperation;
import org.dfe.interfaces.internal.Pair;
import org.dfe.interfaces.internal.config.NfeConfig;
import org.dfe.interfaces.sefaz.nf.nfe.NfeService;
import org.dfe.interfaces.services.NfSefazService;
import org.dfe.interfaces.xml.XMLTransformer;
import org.dfe.models.nf.authorization.Nf;
import org.dfe.models.nf.event.DetEpecEvent;
import org.dfe.models.nf.event.NfEventRequest;
import org.dfe.models.nf.event.ReturnNfEvent;
import org.dfe.models.nf.event.SendNfEvent;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public interface NfeEpecService extends NfSefazService {

    /**
     * A function that sends an event to the Sefaz.
     *
     * @param tEnvEvento The object that contains the data to be sent to the SEFAZ.
     * @return A ReturnNfEvent object.
     */
    default ReturnNfEvent epec(TEnvEvento tEnvEvento) throws CircuitBreakerException, NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        NfeConfig config = getConfig().withEnviroment(tEnvEvento.getEvento().stream().findFirst().map(it -> it.getInfEvento().getTpAmb()).orElse(getConfig().environment().getCode()));
        NfeService service = getProviderFactory().getNfeService(config, NfeAuthorizer.AN);
        Pair<?, TRetEnvEvento> res = getCircuitBreakerRegistry().get(
                config.environment(),
                Model.NFE,
                UF.NACIONAL,
                DfeOperation.EVENT
        ).execute(() -> service.eventAN(NfEventRequest.builder().data(tEnvEvento)
                .config(config)
                .signer(getXmlSigner())
                .validators(getValidatorFactory().nfeValidator().eventValidators())
                .afterRequest(getProcess().afterEvent())
                .beforeRequest(getProcess().beforeEvent())
                .configureProvider(getConfigureProviderFactory()).build()
        ));
        return new ReturnNfEvent().fromObject(res);
    }

    /**
     * It converts the SendNfeEpec object to an object and then calls the epec function.
     *
     * @param sendNfeEpec Object of type SendNfeEpec, which contains the data to be sent to the Epec service.
     * @return ReturnNfEvent
     */
    default ReturnNfEvent epec(SendNfEvent sendNfeEpec) throws CircuitBreakerException, NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return epec(sendNfeEpec.toObject());
    }


    /**
     * A function that sends an event to the NF-e.
     *
     * @param accessKey The access key of the NF-e.
     * @param detEvento The event to be sent.
     * @return ReturnNfEvent
     */
    default ReturnNfEvent epec(String accessKey, DetEpecEvent detEvento) throws CircuitBreakerException, NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return epec(SendNfEvent.epecEvent(accessKey, detEvento, getConfig()));
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
     * @return ReturnNfEvent
     */
    default ReturnNfEvent epec(String accessKey, String emissionDate, NFType type, String stateRegistration, TUf uf, String cnpj, String cpf, String foreignId, String recipientStateRegistration, String totalValue, String totalIcms, String totalIcmsSt) throws CircuitBreakerException, NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return epec(SendNfEvent.epecEvent(accessKey, emissionDate, type, stateRegistration, uf, cnpj, cpf, foreignId, recipientStateRegistration, totalValue, totalIcms, totalIcmsSt, getConfig()));
    }

    /**
     * A function that receives a parameter of type Nf and returns a ReturnNfEvent.
     *
     * @param n The NF object to be sent.
     * @return ReturnNfEvent
     */
    default ReturnNfEvent epec(Nf n) throws CircuitBreakerException, NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return epec(Collections.singletonList(n));
    }

    /**
     * "Send a list of invoices to the Epec service and return the result."
     *
     * @param nfs List of NF objects
     * @return ReturnNfEvent
     */
    default ReturnNfEvent epec(List<Nf> nfs) throws CircuitBreakerException, NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return epec(SendNfEvent.epecEvent(nfs, getConfig()));
    }

    /**
     * It sends an Epec to the Sefaz
     *
     * @param transformer The transformer that will be used to transform the XML into a Nf object.
     * @param xml         The XML of the NF-e to be sent.
     * @return ReturnNfEvent
     */
    default ReturnNfEvent epec(XMLTransformer<Nf> transformer, String xml) throws CircuitBreakerException, NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return epec(transformer.transform(xml));
    }

    /**
     * Given an XML string, return an Epec object
     *
     * @param xml The XML of the NF-e to be converted to Epec.
     * @return ReturnNfEvent
     */
    default ReturnNfEvent epecFromNfe(String xml) throws CircuitBreakerException, NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return epec((o) -> Nf.builder().build().fromObject(NfUnmarshallerFactory.getInstance().nfe(o).getValue()), xml);
    }

    /**
     * It receives an XML string, converts it to a list of NF objects, and then calls the epec function
     *
     * @param xml XML of the NF-e to be canceled.
     * @return ReturnNfEvent
     */
    default ReturnNfEvent epecFromEnviNfe(String xml) throws CircuitBreakerException, NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return epec(NfUnmarshallerFactory.getInstance().enviNfe(xml).getValue().getNFe().stream().map(it -> Nf.builder().build().fromObject(it)).collect(Collectors.toList()));
    }

    @Override
    NfeConfig getConfig();
}
