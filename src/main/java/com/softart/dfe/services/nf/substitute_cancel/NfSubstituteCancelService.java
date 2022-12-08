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

    default ReturnNfceSubstituteCancel substituteCancel(String accessKey, String accessKeyRef, String protocol, String justification, String sequenceNumber) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return substituteCancel(SendNfceSubstituteCancel.cancel(accessKey, accessKeyRef, protocol, justification, sequenceNumber, getConfig()));
    }

    default ReturnNfceSubstituteCancel substituteCancel(String accessKey, String accessKeyRef, String protocol, String justification) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return substituteCancel(accessKey, accessKeyRef, protocol, justification, "1");
    }

    default ReturnNfceSubstituteCancel substituteCancel(String accessKey, String accessKeyRef, String protocol) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return substituteCancel(accessKey, accessKeyRef, protocol, NFEvent.SUBSTITUTE_CANCEL.getDefaultMessage());
    }

    ReturnNfceSubstituteCancel substituteCancel(String accessKey, String accessKeyRef) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException;

}
