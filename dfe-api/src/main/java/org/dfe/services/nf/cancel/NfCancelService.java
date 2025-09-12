package org.dfe.services.nf.cancel;

import br.inf.portalfiscal.nfe.event_generic.TEnvEvento;
import br.inf.portalfiscal.nfe.event_generic.TRetEnvEvento;
import org.dfe.components.internal.xml.unmarshaller.NfUnmarshallerFactory;
import org.dfe.enums.internal.Environment;
import org.dfe.enums.internal.Model;
import org.dfe.enums.nf.NFEvent;
import org.dfe.exceptions.CircuitBreakerException;
import org.dfe.exceptions.ProcessException;
import org.dfe.exceptions.ValidationException;
import org.dfe.exceptions.port.SoapServiceGeneralException;
import org.dfe.exceptions.security.SecurityException;
import org.dfe.exceptions.services.NoProviderFound;
import org.dfe.interfaces.circuitbreaker.DfeOperation;
import org.dfe.interfaces.internal.Pair;
import org.dfe.interfaces.internal.config.NfConfig;
import org.dfe.interfaces.sefaz.nf.common.NfCommonService;
import org.dfe.interfaces.services.NfSefazService;
import org.dfe.interfaces.validation.nf.common.NfCommonValidator;
import org.dfe.models.nf.authorization.NfProcessed;
import org.dfe.models.nf.event.NfEventRequest;
import org.dfe.models.nf.event.ReturnNfEvent;
import org.dfe.models.nf.event.SendNfEvent;
import org.dfe.services.nf.query_protocol.NfQueryProtocolService;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@SuppressWarnings("unused")
public interface NfCancelService extends NfSefazService {

    /**
     * It cancels an invoice.
     *
     * @param tEnvEvento The object that contains the cancellation data.
     * @return A ReturnNfeCancel object.
     */
    default ReturnNfEvent cancel(TEnvEvento tEnvEvento) throws CircuitBreakerException, NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        NfConfig config = getConfig().withEnviroment(tEnvEvento.getEvento().stream().findFirst().map(it -> it.getInfEvento().getTpAmb()).orElse(getConfig().environment().getCode()));
        NfCommonService service = getService(config.environment());
        Pair<?, TRetEnvEvento> res = getCircuitBreakerRegistry().get(
                config.environment(),
                getModel(),
                config.webServiceUF(),
                DfeOperation.EVENT
        ).execute(() -> service.event(NfEventRequest
                .builder()
                .data(tEnvEvento)
                .config(config)
                .signer(getXmlSigner())
                .validators(getValidator().eventValidators())
                .afterRequest(getProcess().afterEvent())
                .beforeRequest(getProcess().beforeEvent())
                .configureProvider(getConfigureProviderFactory())
                .build()));
        return new ReturnNfEvent().fromObject(res);
    }

    /**
     * It converts the sendNfeCancel object to an object and then calls the cancelar function.
     *
     * @param sendNfEvent The object that contains the data to be sent to the cancellation service.
     * @return ReturnNfeCancel
     */
    default ReturnNfEvent cancel(SendNfEvent sendNfEvent) throws CircuitBreakerException, NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return cancel(sendNfEvent.toObject());
    }

    /**
     * It cancels a processed NF
     *
     * @param processed The processed object that you want to cancel.
     * @param motive    The reason for the cancellation.
     * @return ReturnNfeCancel
     */
    default ReturnNfEvent cancelProcessed(NfProcessed processed, String motive) throws CircuitBreakerException, NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return cancelProcessed(Collections.singletonList(processed), motive);
    }

    /**
     * It cancels a processed NFe.
     *
     * @param processed The processed object that will be canceled.
     * @return ReturnNfeCancel
     */
    default ReturnNfEvent cancelProcessed(NfProcessed processed) throws CircuitBreakerException, NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return cancelProcessed(Collections.singletonList(processed));
    }

    /**
     * It cancels a list of processed NF-e
     *
     * @param processeds List of processed NF-e's to be canceled.
     * @param motive     The reason for the cancellation.
     * @return ReturnNfeCancel
     */
    default ReturnNfEvent cancelProcessed(List<NfProcessed> processeds, String motive) throws CircuitBreakerException, NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return cancel(SendNfEvent.cancel(processeds, motive, getConfig()));
    }

    /**
     * It cancels a processed NFe.
     *
     * @param processeds List of NFProcessed objects.
     * @return ReturnNfeCancel
     */
    default ReturnNfEvent cancelProcessed(List<NfProcessed> processeds) throws CircuitBreakerException, NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return cancelProcessed(processeds, NFEvent.CANCEL.getDefaultMessage());
    }

    /**
     * It cancels a list of processed NF-e's, given a list of XML's
     *
     * @param xmlProcs Collection of XMLs in the NFe format.
     * @param motive   The reason for the cancellation.
     * @return A ReturnNfeCancel object.
     */
    default ReturnNfEvent cancelXmlProc(Collection<String> xmlProcs, String motive) throws CircuitBreakerException, NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return cancelProcessed(xmlProcs.stream().map(xmlProc -> NfProcessed.builder().build().fromObject(NfUnmarshallerFactory.getInstance().nfeProc(xmlProc).getValue())).collect(Collectors.toList()), motive);
    }

    /**
     * It cancels the XML process.
     *
     * @param xmlProcs Collection of XMLs to be canceled.
     * @return ReturnNfeCancel
     */
    default ReturnNfEvent cancelXmlProc(Collection<String> xmlProcs) throws CircuitBreakerException, NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return cancelXmlProc(xmlProcs, NFEvent.CANCEL.getDefaultMessage());
    }

    /**
     * It cancels the XML file.
     *
     * @param xmlProc The XML file of the NFe that you want to cancel.
     * @param motive  The reason for the cancellation.
     * @return ReturnNfeCancel
     */
    default ReturnNfEvent cancelXmlProc(String xmlProc, String motive) throws CircuitBreakerException, NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return cancelXmlProc(Collections.singletonList(xmlProc), motive);
    }

    /**
     * It cancels the XML file.
     *
     * @param xmlProc The XML file of the NFe that you want to cancel.
     * @return A list of ReturnNfeCancel objects.
     */
    default ReturnNfEvent cancelXmlProc(String xmlProc) throws CircuitBreakerException, NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return cancelXmlProc(Collections.singletonList(xmlProc));
    }

    /**
     * It cancels a NFe
     *
     * @param accessKey      The access key of the NF-e to be canceled.
     * @param protocol       The protocol number of the NF-e to be canceled.
     * @param justification  Justification for cancellation
     * @param sequenceNumber The number of the NF-e to be canceled.
     * @return ReturnNfeCancel
     */
    default ReturnNfEvent cancel(String accessKey, String protocol, String justification, String sequenceNumber) throws CircuitBreakerException, NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return cancel(SendNfEvent.cancel(accessKey, protocol, justification, sequenceNumber, getConfig()).toObject());
    }

    /**
     * It cancels the NFE.
     *
     * @param accessKey     The access key of the NFe.
     * @param protocol      The protocol number of the NFe to be canceled.
     * @param justification The justification for the cancellation.
     * @return ReturnNfeCancel
     */
    default ReturnNfEvent cancel(String accessKey, String protocol, String justification) throws CircuitBreakerException, NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return cancel(accessKey, protocol, justification, "1");
    }

    /**
     * It cancels the NFe.
     *
     * @param accessKey The access key of the NF-e to be canceled.
     * @param protocol  The protocol number of the NFe to be canceled.
     * @return ReturnNfeCancel
     */
    default ReturnNfEvent cancel(String accessKey, String protocol) throws CircuitBreakerException, NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return cancel(accessKey, protocol, NFEvent.CANCEL.getDefaultMessage());
    }

    /**
     * It cancels the NFe.
     *
     * @param accessKey The access key of the NFe to be canceled.
     * @return The return is an object of type ReturnNfeCancel.
     */
    default ReturnNfEvent cancel(String accessKey) throws CircuitBreakerException, NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return cancel(accessKey, String.valueOf(getNfQueryProtocolService().queryProtocol(accessKey).getProtNFe().getInfProt().getNProt()));
    }

    default ReturnNfEvent cancelWithMotive(String accessKey, String motive) throws CircuitBreakerException, NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return cancel(accessKey, String.valueOf(getNfQueryProtocolService().queryProtocol(accessKey).getProtNFe().getInfProt().getNProt()), motive);
    }

    /**
     * * If the service is already instantiated, return it.
     * * If the service is not instantiated, try to instantiate it.
     * * If the service cannot be instantiated, throw an exception
     *
     * @return The service object.
     */
    NfCommonService getService(Environment environment) throws CircuitBreakerException, NoProviderFound, SoapServiceGeneralException;

    Model getModel();

    /**
     * Returns the validator used by this class
     *
     * @return The validator object.
     */
    NfCommonValidator getValidator();

    NfQueryProtocolService getNfQueryProtocolService();

}
