package org.dfe.services.nf.correction_letter;

import br.inf.portalfiscal.nfe.event_correction_letter.TEnvEvento;
import org.dfe.enums.nf.NFEvent;
import org.dfe.exceptions.ProcessException;
import org.dfe.exceptions.ValidationException;
import org.dfe.exceptions.port.SoapServiceGeneralException;
import org.dfe.exceptions.security.SecurityException;
import org.dfe.exceptions.services.NoProviderFound;
import org.dfe.interfaces.internal.config.NfeConfig;
import org.dfe.interfaces.services.NfSefazService;
import org.dfe.models.nf.correction_letter.NfeCorrectionLetterRequest;
import org.dfe.models.nf.correction_letter.ReturnNfeCorrectionLetter;
import org.dfe.models.nf.correction_letter.SendNfeCorrectionLetter;
import org.dfe.services.nf.query_protocol.NfeQueryProtocolService;

public interface NfeCorrectionLetterService extends NfSefazService {

    /**
     * It sends a correction letter to the SEFAZ.
     *
     * @param tEnvEvento The object that contains the data to be sent to the SEFAZ.
     * @return A ReturnNfeCorrectionLetter object.
     */
    default ReturnNfeCorrectionLetter correctionLetter(TEnvEvento tEnvEvento) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        NfeConfig config = getConfig().withEnviroment(tEnvEvento.getEvento().stream().findFirst().map(it -> it.getInfEvento().getTpAmb()).orElse(getConfig().environment().getCode()));

        return ReturnNfeCorrectionLetter.builder().build().fromObject(getProviderFactory()
                .getNfeService(config)
                .correctionLetter(NfeCorrectionLetterRequest
                        .builder()
                        .data(tEnvEvento)
                        .config(config)
                        .signer(getXmlSigner())
                        .validators(getValidatorFactory().nfeValidator().correctionLetterValidators())
                        .afterRequest(getProcess().afterCorrectionLetter())
                        .beforeRequest(getProcess().beforeCorrectionLetter())
                        .configureProvider(getConfigureProviderFactory())
                        .build()));
    }

    /**
     * It converts the SendNfeCorrectionLetter object to an object of type ReturnNfeCorrectionLetter.
     *
     * @param sendNfeCorrectionLetter Object containing the data to be sent to the SEFAZ.
     * @return ReturnNfeCorrectionLetter
     */
    default ReturnNfeCorrectionLetter correctionLetter(SendNfeCorrectionLetter sendNfeCorrectionLetter) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return correctionLetter(sendNfeCorrectionLetter.toObject());
    }

    /**
     * It sends a correction letter to the SEFAZ
     *
     * @param accessKey  The access key of the NF-e to be corrected.
     * @param correction The correction number, which is the number of the correction letter.
     * @param nseq       The sequence number of the NF-e to be corrected.
     * @return ReturnNfeCorrectionLetter
     */
    default ReturnNfeCorrectionLetter correctionLetter(String accessKey, String correction, String nseq) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return correctionLetter(SendNfeCorrectionLetter.correctionLetter(accessKey, correction, nseq, getConfig()).toObject());
    }

    /**
     * It returns a correction letter for a given access key and correction.
     *
     * @param accessKey  The access key of the NFe that you want to correct.
     * @param correction The correction letter to be sent to the SEFAZ.
     * @return The return of the correction letter.
     */
    default ReturnNfeCorrectionLetter correctionLetter(String accessKey, String correction) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return correctionLetter(accessKey, correction, String.valueOf(getNfeQueryProtocolService().getLastSequenceNumber(accessKey, NFEvent.CORRECTION_LETTER)));
    }

    NfeQueryProtocolService getNfeQueryProtocolService();

    @Override
    NfeConfig getConfig();

}
