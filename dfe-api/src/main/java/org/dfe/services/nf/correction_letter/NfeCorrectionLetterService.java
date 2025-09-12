package org.dfe.services.nf.correction_letter;

import br.inf.portalfiscal.nfe.event_generic.TEnvEvento;
import br.inf.portalfiscal.nfe.event_generic.TRetEnvEvento;
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
import org.dfe.interfaces.internal.config.NfeConfig;
import org.dfe.interfaces.sefaz.nf.nfe.NfeService;
import org.dfe.interfaces.services.NfSefazService;
import org.dfe.models.nf.event.NfEventRequest;
import org.dfe.models.nf.event.ReturnNfEvent;
import org.dfe.models.nf.event.SendNfEvent;
import org.dfe.services.nf.query_protocol.NfeQueryProtocolService;

public interface NfeCorrectionLetterService extends NfSefazService {

    /**
     * It sends a correction letter to the SEFAZ.
     *
     * @param tEnvEvento The object that contains the data to be sent to the SEFAZ.
     * @return A ReturnNfEvent object.
     */
    default ReturnNfEvent correctionLetter(TEnvEvento tEnvEvento) throws CircuitBreakerException, NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        NfeConfig config = getConfig().withEnviroment(tEnvEvento.getEvento().stream().findFirst().map(it -> it.getInfEvento().getTpAmb()).orElse(getConfig().environment().getCode()));
        NfeService service = getProviderFactory().getNfeService(config);
        Pair<?, TRetEnvEvento> res = getCircuitBreakerRegistry().get(
                config.environment(),
                Model.NFE,
                config.webServiceUF(),
                DfeOperation.EVENT
        ).execute(() -> service.event(NfEventRequest
                .builder()
                .data(tEnvEvento)
                .config(config)
                .signer(getXmlSigner())
                .validators(getValidatorFactory().nfeValidator().eventValidators())
                .afterRequest(getProcess().afterEvent())
                .beforeRequest(getProcess().beforeEvent())
                .configureProvider(getConfigureProviderFactory())
                .build()));
        return new ReturnNfEvent().fromObject(res);
    }

    /**
     * It converts the SendNfeCorrectionLetter object to an object of type ReturnNfEvent.
     *
     * @param sendNfeCorrectionLetter Object containing the data to be sent to the SEFAZ.
     * @return ReturnNfEvent
     */
    default ReturnNfEvent correctionLetter(SendNfEvent sendNfeCorrectionLetter) throws CircuitBreakerException, NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return correctionLetter(sendNfeCorrectionLetter.toObject());
    }

    /**
     * It sends a correction letter to the SEFAZ
     *
     * @param accessKey  The access key of the NF-e to be corrected.
     * @param correction The correction number, which is the number of the correction letter.
     * @param nseq       The sequence number of the NF-e to be corrected.
     * @return ReturnNfEvent
     */
    default ReturnNfEvent correctionLetter(String accessKey, String correction, String nseq) throws CircuitBreakerException, NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return correctionLetter(SendNfEvent.correctionLetter(
                accessKey, correction, nseq, getConfig()
        ).toObject());
    }

    /**
     * It returns a correction letter for a given access key and correction.
     *
     * @param accessKey  The access key of the NFe that you want to correct.
     * @param correction The correction letter to be sent to the SEFAZ.
     * @return The return of the correction letter.
     */
    default ReturnNfEvent correctionLetter(String accessKey, String correction) throws CircuitBreakerException, NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return correctionLetter(accessKey, correction, String.valueOf(getNfeQueryProtocolService().getLastSequenceNumber(accessKey, NFEvent.CORRECTION_LETTER)));
    }

    NfeQueryProtocolService getNfeQueryProtocolService();

    @Override
    NfeConfig getConfig();

}
