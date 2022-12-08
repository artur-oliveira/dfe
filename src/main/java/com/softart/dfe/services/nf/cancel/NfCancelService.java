package com.softart.dfe.services.nf.cancel;

import br.inf.portalfiscal.nfe.event_cancel.TEnvEvento;
import br.inf.portalfiscal.nfe.event_cancel.TRetEnvEvento;
import com.softart.dfe.enums.nf.NFEvent;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.interfaces.internal.Pair;
import com.softart.dfe.interfaces.sefaz.nf.common.NfCommonService;
import com.softart.dfe.interfaces.services.NfSefazService;
import com.softart.dfe.interfaces.validation.nf.common.NfCommonValidator;
import com.softart.dfe.models.nf.cancel.NfeCancelRequest;
import com.softart.dfe.models.nf.cancel.ReturnNfeCancel;
import com.softart.dfe.models.nf.cancel.SendNfeCancel;

public interface NfCancelService extends NfSefazService {

    default ReturnNfeCancel cancelar(String accessKey, String protocol, String justification, String sequenceNumber) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        Pair<TEnvEvento, TRetEnvEvento> response = getService()
                .cancel(NfeCancelRequest
                        .builder()
                        .data(SendNfeCancel.cancel(accessKey, protocol, justification, sequenceNumber, getConfig()).toObject())
                        .config(getConfig())
                        .signer(getXmlSigner())
                        .validators(getValidator().cancelValidators())
                        .afterRequest(getProcess().afterCancel())
                        .beforeRequest(getProcess().beforeCancel())
                        .configureProvider(getConfigureProviderFactory())
                        .build());

        return ReturnNfeCancel.builder().build().fromObject(response.second());
    }

    default ReturnNfeCancel cancelar(String accessKey, String protocol, String justification) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return cancelar(accessKey, protocol, justification, "1");
    }

    default ReturnNfeCancel cancelar(String accessKey, String protocol) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return cancelar(accessKey, protocol, NFEvent.CANCEL.getDefaultMessage());
    }

    ReturnNfeCancel cancelar(String accessKey) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException;

    NfCommonService getService() throws NoProviderFound, SoapServiceGeneralException;

    NfCommonValidator getValidator();
}
