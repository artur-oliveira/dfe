package com.softart.dfe.services.nf.correction_letter;

import com.softart.dfe.enums.nf.NFEvent;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.models.nf.correction_letter.ReturnNfeCorrectionLetter;
import com.softart.dfe.services.nf.query_protocol.NfQueryProtocolService;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractNfeCorrectionLetterService implements NfeCorrectionLetterService {

    @Override
    public ReturnNfeCorrectionLetter correctionLetter(String accessKey, String correction) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return correctionLetter(accessKey, correction, String.valueOf(getNfeQueryProtocolService().getLastSequenceNumber(accessKey, NFEvent.CORRECTION_LETTER)));
    }

    protected abstract NfQueryProtocolService getNfeQueryProtocolService();


}
