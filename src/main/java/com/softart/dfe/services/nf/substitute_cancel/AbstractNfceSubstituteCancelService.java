package com.softart.dfe.services.nf.substitute_cancel;

import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.models.nf.substitute_cancel.ReturnNfceSubstituteCancel;
import com.softart.dfe.services.nf.query_protocol.NfQueryProtocolService;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractNfceSubstituteCancelService implements NfSubstituteCancelService {

    @Override
    public ReturnNfceSubstituteCancel substituteCancel(String accessKey, String accessKeyRef) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return substituteCancel(accessKey, accessKeyRef, getNfQueryProtocolService().queryProtocol(accessKey).getProtNFe().getInfProt().getNProt());
    }

    public abstract NfQueryProtocolService getNfQueryProtocolService();
}
