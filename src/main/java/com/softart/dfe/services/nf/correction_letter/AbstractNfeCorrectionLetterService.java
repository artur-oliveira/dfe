package com.softart.dfe.services.nf.correction_letter;

import br.inf.portalfiscal.nfe.event_correction_letter.TEnvEvento;
import br.inf.portalfiscal.nfe.event_correction_letter.TRetEnvEvento;
import com.softart.dfe.enums.nf.NFEvent;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.interfaces.internal.Pair;
import com.softart.dfe.models.nf.correction_letter.NfeCorrectionLetterRequest;
import com.softart.dfe.models.nf.correction_letter.ReturnNfeCorrectionLetter;
import com.softart.dfe.models.nf.correction_letter.SendNfeCorrectionLetter;
import com.softart.dfe.services.nf.query_protocol.NfQueryProtocolService;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractNfeCorrectionLetterService implements NfeCorrectionLetterService {

    @Override
    public ReturnNfeCorrectionLetter correctionLetter(String accessKey, String correction, String nseq) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        Pair<TEnvEvento, TRetEnvEvento> response = getProviderFactory()
                .getNfeService(getConfig())
                .correctionLetter(NfeCorrectionLetterRequest
                        .builder()
                        .data(SendNfeCorrectionLetter.correctionLetter(accessKey, correction, nseq, getConfig()).toObject())
                        .config(getConfig())
                        .signer(getXmlSigner())
                        .validators(getValidatorFactory().nfeValidator().correctionLetterValidators())
                        .afterRequest(getProcess().afterCorrectionLetter())
                        .beforeRequest(getProcess().beforeCorrectionLetter())
                        .configureProvider(getConfigureProviderFactory())
                        .build());

        return ReturnNfeCorrectionLetter.builder().build().fromObject(response.second());
    }

    @Override
    public ReturnNfeCorrectionLetter correctionLetter(String accessKey, String correction) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return correctionLetter(accessKey, correction, String.valueOf(getNfeQueryProtocolService().getLastSequenceNumber(accessKey, NFEvent.CORRECTION_LETTER)));
    }

    protected abstract NfQueryProtocolService getNfeQueryProtocolService();


}
