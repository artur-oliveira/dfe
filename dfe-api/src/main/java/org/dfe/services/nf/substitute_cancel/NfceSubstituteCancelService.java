package org.dfe.services.nf.substitute_cancel;

import org.dfe.enums.nf.NFEvent;
import org.dfe.exceptions.CircuitBreakerException;
import org.dfe.exceptions.ProcessException;
import org.dfe.exceptions.ValidationException;
import org.dfe.exceptions.port.SoapServiceGeneralException;
import org.dfe.exceptions.security.SecurityException;
import org.dfe.exceptions.services.NoProviderFound;
import org.dfe.interfaces.internal.config.NfceConfig;
import org.dfe.interfaces.services.NfSefazService;
import org.dfe.models.nf.event.NfEventRequest;
import org.dfe.models.nf.event.ReturnNfEvent;
import org.dfe.models.nf.event.SendNfEvent;
import org.dfe.services.nf.query_protocol.NfceQueryProtocolService;

public interface NfceSubstituteCancelService extends NfSefazService {

    /**
     * A function that cancels a substitute NFCe.
     *
     * @param substituteCancel The object that contains the data to be sent to the SEFAZ.
     * @return The return is a org.dfe.models.nf.event.ReturnNfEvent object.
     */
    default ReturnNfEvent substituteCancel(SendNfEvent substituteCancel) throws CircuitBreakerException, NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        NfceConfig config = getConfig().withEnviroment(substituteCancel.getEvento().stream().findFirst().map(it -> it.getInfEvento().getTpAmb()).orElse(getConfig().environment().getCode()));
        return ReturnNfEvent.builder().build().fromObject(getProviderFactory().getNfceService(config)
                .event(NfEventRequest
                        .builder()
                        .data(substituteCancel.toObject())
                        .config(config)
                        .signer(getXmlSigner())
                        .validators(getValidatorFactory().nfceValidator().eventValidators())
                        .afterRequest(getProcess().afterEvent())
                        .beforeRequest(getProcess().beforeEvent())
                        .configureProvider(getConfigureProviderFactory())
                        .build()));
    }

    /**
     * It cancels a substitute NFC-e
     *
     * @param accessKey      The access key of the NFC-e to be canceled.
     * @param accessKeyRef   The access key of the original invoice.
     * @param protocol       The protocol number of the original invoice.
     * @param justification  The justification for the cancellation.
     * @param sequenceNumber The sequence number of the NFC-e to be canceled.
     * @return The return is the object ReturnNfEvent, which contains the following attributes:
     */
    default ReturnNfEvent substituteCancel(String accessKey, String accessKeyRef, String protocol, String justification, String sequenceNumber) throws CircuitBreakerException, NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return substituteCancel(SendNfEvent.substituteCancel(accessKey, accessKeyRef, protocol, justification, sequenceNumber, getConfig()));
    }

    /**
     * A function that cancels a substitute invoice.
     *
     * @param accessKey     The access key of the NFC-e.
     * @param accessKeyRef  The access key of the NFCe that will be canceled.
     * @param protocol      The protocol number of the NFC-e to be canceled.
     * @param justification The justification for the cancellation.
     * @return The return is a ReturnNfEvent object.
     */
    default ReturnNfEvent substituteCancel(String accessKey, String accessKeyRef, String protocol, String justification) throws CircuitBreakerException, NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return substituteCancel(accessKey, accessKeyRef, protocol, justification, "1");
    }

    /**
     * It cancels a substitute.
     *
     * @param accessKey    The access key of the NFC-e.
     * @param accessKeyRef The access key reference, which is the access key of the NFC-e that is being canceled.
     * @param protocol     The protocol used to send the message.
     * @return The return is the object ReturnNfEvent.
     */
    default ReturnNfEvent substituteCancel(String accessKey, String accessKeyRef, String protocol) throws CircuitBreakerException, NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return substituteCancel(accessKey, accessKeyRef, protocol, NFEvent.SUBSTITUTE_CANCEL.getDefaultMessage());
    }


    /**
     * It cancels a NFCe with a message
     *
     * @param accessKey    The access key of the NFC-e.
     * @param accessKeyRef The access key of the NFC-e that will be canceled.
     * @param message      The message to be sent to the Sefaz.
     * @return The return is the object ReturnNfEvent, which contains the following attributes:
     */
    default ReturnNfEvent substituteCancelWithMessage(String accessKey, String accessKeyRef, String message) throws CircuitBreakerException, NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return substituteCancel(accessKey, accessKeyRef, getNfceQueryProtocolService().queryProtocol(accessKey).getProtNFe().getInfProt().getNProt(), message);
    }

    /**
     * Cancels a substitute NFC-e
     *
     * @param accessKey    The access key of the NFC-e to be canceled.
     * @param accessKeyRef The access key of the NFC-e that will be canceled.
     * @return ReturnNfEvent
     */
    default ReturnNfEvent substituteCancel(String accessKey, String accessKeyRef) throws CircuitBreakerException, NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return substituteCancel(accessKey, accessKeyRef, NFEvent.SUBSTITUTE_CANCEL.getDefaultMessage());
    }

    NfceQueryProtocolService getNfceQueryProtocolService();

    @Override
    NfceConfig getConfig();
}
