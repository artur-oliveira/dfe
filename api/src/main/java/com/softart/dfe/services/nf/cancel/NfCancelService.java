package com.softart.dfe.services.nf.cancel;

import br.inf.portalfiscal.nfe.event_cancel.TEnvEvento;
import com.softart.dfe.components.internal.xml.unmarshaller.NfUnmarshallerFactory;
import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.nf.NFEvent;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.interfaces.internal.config.NfConfig;
import com.softart.dfe.interfaces.sefaz.nf.common.NfCommonService;
import com.softart.dfe.interfaces.services.NfSefazService;
import com.softart.dfe.interfaces.validation.nf.common.NfCommonValidator;
import com.softart.dfe.models.nf.authorization.NfProcessed;
import com.softart.dfe.models.nf.cancel.NfeCancelRequest;
import com.softart.dfe.models.nf.cancel.ReturnNfeCancel;
import com.softart.dfe.models.nf.cancel.SendNfeCancel;
import com.softart.dfe.services.nf.query_protocol.NfQueryProtocolService;

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
    default ReturnNfeCancel cancel(TEnvEvento tEnvEvento) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        NfConfig config = getConfig().withEnviroment(tEnvEvento.getEvento().stream().findFirst().map(it -> it.getInfEvento().getTpAmb()).orElse(getConfig().environment().getCode()));
        return ReturnNfeCancel.builder().build().fromObject(getService(config.environment())
                .cancel(NfeCancelRequest
                        .builder()
                        .data(tEnvEvento)
                        .config(config)
                        .signer(getXmlSigner())
                        .validators(getValidator().cancelValidators())
                        .afterRequest(getProcess().afterCancel())
                        .beforeRequest(getProcess().beforeCancel())
                        .configureProvider(getConfigureProviderFactory())
                        .build()));
    }

    /**
     * It converts the sendNfeCancel object to an object and then calls the cancelar function.
     *
     * @param sendNfeCancel The object that contains the data to be sent to the cancellation service.
     * @return ReturnNfeCancel
     */
    default ReturnNfeCancel cancel(SendNfeCancel sendNfeCancel) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return cancel(sendNfeCancel.toObject());
    }

    /**
     * It cancels a processed NF
     *
     * @param processed The processed object that you want to cancel.
     * @param motive    The reason for the cancellation.
     * @return ReturnNfeCancel
     */
    default ReturnNfeCancel cancelProcessed(NfProcessed processed, String motive) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return cancelProcessed(Collections.singletonList(processed), motive);
    }

    /**
     * It cancels a processed NFe.
     *
     * @param processed The processed object that will be canceled.
     * @return ReturnNfeCancel
     */
    default ReturnNfeCancel cancelProcessed(NfProcessed processed) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return cancelProcessed(Collections.singletonList(processed));
    }

    /**
     * It cancels a list of processed NF-e
     *
     * @param processeds List of processed NF-e's to be canceled.
     * @param motive     The reason for the cancellation.
     * @return ReturnNfeCancel
     */
    default ReturnNfeCancel cancelProcessed(List<NfProcessed> processeds, String motive) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return cancel(SendNfeCancel.build(processeds, motive, getConfig()));
    }

    /**
     * It cancels a processed NFe.
     *
     * @param processeds List of NFProcessed objects.
     * @return ReturnNfeCancel
     */
    default ReturnNfeCancel cancelProcessed(List<NfProcessed> processeds) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return cancelProcessed(processeds, NFEvent.CANCEL.getDefaultMessage());
    }

    /**
     * It cancels a list of processed NF-e's, given a list of XML's
     *
     * @param xmlProcs Collection of XMLs in the NFe format.
     * @param motive   The reason for the cancellation.
     * @return A ReturnNfeCancel object.
     */
    default ReturnNfeCancel cancelXmlProc(Collection<String> xmlProcs, String motive) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return cancelProcessed(xmlProcs.stream().map(xmlProc -> NfProcessed.builder().build().fromObject(NfUnmarshallerFactory.getInstance().nfeProc(xmlProc).getValue())).collect(Collectors.toList()), motive);
    }

    /**
     * It cancels the XML process.
     *
     * @param xmlProcs Collection of XMLs to be canceled.
     * @return ReturnNfeCancel
     */
    default ReturnNfeCancel cancelXmlProc(Collection<String> xmlProcs) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return cancelXmlProc(xmlProcs, NFEvent.CANCEL.getDefaultMessage());
    }

    /**
     * It cancels the XML file.
     *
     * @param xmlProc The XML file of the NFe that you want to cancel.
     * @param motive  The reason for the cancellation.
     * @return ReturnNfeCancel
     */
    default ReturnNfeCancel cancelXmlProc(String xmlProc, String motive) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return cancelXmlProc(Collections.singletonList(xmlProc), motive);
    }

    /**
     * It cancels the XML file.
     *
     * @param xmlProc The XML file of the NFe that you want to cancel.
     * @return A list of ReturnNfeCancel objects.
     */
    default ReturnNfeCancel cancelXmlProc(String xmlProc) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
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
    default ReturnNfeCancel cancel(String accessKey, String protocol, String justification, String sequenceNumber) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return cancel(SendNfeCancel.cancel(accessKey, protocol, justification, sequenceNumber, getConfig()).toObject());
    }

    /**
     * It cancels the NFE.
     *
     * @param accessKey     The access key of the NFe.
     * @param protocol      The protocol number of the NFe to be canceled.
     * @param justification The justification for the cancellation.
     * @return ReturnNfeCancel
     */
    default ReturnNfeCancel cancel(String accessKey, String protocol, String justification) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return cancel(accessKey, protocol, justification, "1");
    }

    /**
     * It cancels the NFe.
     *
     * @param accessKey The access key of the NF-e to be canceled.
     * @param protocol  The protocol number of the NFe to be canceled.
     * @return ReturnNfeCancel
     */
    default ReturnNfeCancel cancel(String accessKey, String protocol) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return cancel(accessKey, protocol, NFEvent.CANCEL.getDefaultMessage());
    }

    /**
     * It cancels the NFe.
     *
     * @param accessKey The access key of the NFe to be canceled.
     * @return The return is an object of type ReturnNfeCancel.
     */
    default ReturnNfeCancel cancel(String accessKey) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return cancel(accessKey, String.valueOf(getNfQueryProtocolService().queryProtocol(accessKey).getProtNFe().getInfProt().getNProt()));
    }

    default ReturnNfeCancel cancelWithMotive(String accessKey, String motive) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return cancel(accessKey, String.valueOf(getNfQueryProtocolService().queryProtocol(accessKey).getProtNFe().getInfProt().getNProt()), motive);
    }

    /**
     * * If the service is already instantiated, return it.
     * * If the service is not instantiated, try to instantiate it.
     * * If the service cannot be instantiated, throw an exception
     *
     * @return The service object.
     */
    NfCommonService getService(Environment environment) throws NoProviderFound, SoapServiceGeneralException;

    /**
     * > Returns the validator used by this class
     *
     * @return The validator object.
     */
    NfCommonValidator getValidator();

    NfQueryProtocolService getNfQueryProtocolService();

}
