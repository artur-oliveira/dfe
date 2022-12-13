package com.softart.dfe.services.nf.substitute_cancel;

import br.inf.portalfiscal.nfe.event_substitute_cancel.TEnvEvento;
import br.inf.portalfiscal.nfe.event_substitute_cancel.TRetEnvEvento;
import com.softart.dfe.enums.nf.NFEvent;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.interfaces.internal.Pair;
import com.softart.dfe.interfaces.services.NfSefazService;
import com.softart.dfe.models.nf.substitute_cancel.NfceSubstituteCancelRequest;
import com.softart.dfe.models.nf.substitute_cancel.ReturnNfceSubstituteCancel;
import com.softart.dfe.models.nf.substitute_cancel.SendNfceSubstituteCancel;

public interface NfSubstituteCancelService extends NfSefazService {

    /**
     * A function that cancels a substitute NFCe.
     *
     * @param substituteCancel The object that contains the data to be sent to the SEFAZ.
     * @return The return is a ReturnNfceSubstituteCancel object.
     */
    default ReturnNfceSubstituteCancel substituteCancel(SendNfceSubstituteCancel substituteCancel) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        Pair<TEnvEvento, TRetEnvEvento> response = getProviderFactory().getNfceService(getConfig())
                .substituteCancel(NfceSubstituteCancelRequest
                        .builder()
                        .data(substituteCancel.toObject())
                        .config(getConfig())
                        .signer(getXmlSigner())
                        .validators(getValidatorFactory().nfceValidator().substituteCancelValidators())
                        .afterRequest(getProcess().afterSubstituteCancel())
                        .beforeRequest(getProcess().beforeSubstituteCancel())
                        .configureProvider(getConfigureProviderFactory())
                        .build());

        return ReturnNfceSubstituteCancel.builder().build().fromObject(response.second());
    }

    /**
     * It cancels a substitute NFC-e
     *
     * @param accessKey      The access key of the NFC-e to be canceled.
     * @param accessKeyRef   The access key of the original invoice.
     * @param protocol       The protocol number of the original invoice.
     * @param justification  The justification for the cancellation.
     * @param sequenceNumber The sequence number of the NFC-e to be canceled.
     * @return The return is the object ReturnNfceSubstituteCancel, which contains the following attributes:
     */
    default ReturnNfceSubstituteCancel substituteCancel(String accessKey, String accessKeyRef, String protocol, String justification, String sequenceNumber) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return substituteCancel(SendNfceSubstituteCancel.cancel(accessKey, accessKeyRef, protocol, justification, sequenceNumber, getConfig()));
    }

    /**
     * A function that cancels a substitute invoice.
     *
     * @param accessKey     The access key of the NFC-e.
     * @param accessKeyRef  The access key of the NFCe that will be canceled.
     * @param protocol      The protocol number of the NFC-e to be canceled.
     * @param justification The justification for the cancellation.
     * @return The return is a ReturnNfceSubstituteCancel object.
     */
    default ReturnNfceSubstituteCancel substituteCancel(String accessKey, String accessKeyRef, String protocol, String justification) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return substituteCancel(accessKey, accessKeyRef, protocol, justification, "1");
    }

    /**
     * It cancels a substitute.
     *
     * @param accessKey    The access key of the NFC-e.
     * @param accessKeyRef The access key reference, which is the access key of the NFC-e that is being canceled.
     * @param protocol     The protocol used to send the message.
     * @return The return is the object ReturnNfceSubstituteCancel.
     */
    default ReturnNfceSubstituteCancel substituteCancel(String accessKey, String accessKeyRef, String protocol) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return substituteCancel(accessKey, accessKeyRef, protocol, NFEvent.SUBSTITUTE_CANCEL.getDefaultMessage());
    }

    /**
     * Cancels a substitute NFC-e
     *
     * @param accessKey    The access key of the NFC-e to be canceled.
     * @param accessKeyRef The access key of the NFC-e that will be canceled.
     * @return ReturnNfceSubstituteCancel
     */
    ReturnNfceSubstituteCancel substituteCancel(String accessKey, String accessKeyRef) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException;

}
