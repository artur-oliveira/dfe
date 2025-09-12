package org.dfe.services.nf.manifestation;

import br.inf.portalfiscal.nfe.event_generic.TEnvEvento;
import br.inf.portalfiscal.nfe.event_generic.TRetEnvEvento;
import org.dfe.components.internal.PairImpl;
import org.dfe.enums.internal.Model;
import org.dfe.enums.internal.UF;
import org.dfe.enums.internal.nf.NfeAuthorizer;
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
import org.dfe.services.nf.query_protocol.NfQueryProtocolService;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public interface NfeManifestationService extends NfSefazService {

    /**
     * A function that returns the org.dfe.models.nf.event.ReturnNfEvent object, which is the object that contains the response of the
     * manifestation of the event.
     *
     * @param evento The event object to be sent to the SEFAZ.
     * @return The return is a org.dfe.models.nf.event.ReturnNfEvent object, which is a wrapper for the return of the webservice.
     */
    default ReturnNfEvent manifestation(TEnvEvento evento) throws CircuitBreakerException, NoProviderFound, ProcessException, ValidationException, SecurityException, SoapServiceGeneralException {
        NfeConfig config = getConfig().withEnviroment(evento.getEvento().stream().findFirst().map(it -> it.getInfEvento().getTpAmb()).orElse(getConfig().environment().getCode()));
        NfeService service = getProviderFactory().getNfeService(config, NfeAuthorizer.AN);
        Pair<?, TRetEnvEvento> res = getCircuitBreakerRegistry().get(
                config.environment(),
                Model.NFE,
                UF.NACIONAL,
                DfeOperation.EVENT
        ).execute(() -> service.eventAN(
                NfEventRequest
                        .builder()
                        .signer(getXmlSigner())
                        .config(config)
                        .data(evento)
                        .validators(getValidatorFactory().nfeValidator().eventValidators())
                        .configureProvider(getConfigureProviderFactory())
                        .afterRequest(getProcess().afterEvent())
                        .beforeRequest(getProcess().beforeEvent())
                        .build()
        ));
        return new ReturnNfEvent().fromObject(res);
    }

    /**
     * It sends a manifestation to the Sefaz
     *
     * @param manifestation Manifestation object
     * @return The return of the manifestation.
     */
    default ReturnNfEvent manifestation(SendNfEvent manifestation) throws CircuitBreakerException, NoProviderFound, ProcessException, ValidationException, SecurityException, SoapServiceGeneralException {
        return manifestation(manifestation.toObject());
    }

    /**
     * Confirm the receipt of the event.
     *
     * @param accessKey The access key of the NF-e.
     * @param nseq      The sequence number of the event.
     * @return The return is the object ReturnNfEvent, which contains the following attributes:
     */
    default ReturnNfEvent confirmation(String accessKey, String nseq) throws CircuitBreakerException, ProcessException, ValidationException, NoProviderFound, SecurityException, SoapServiceGeneralException {
        return manifestation(SendNfEvent.operationConfirmation(accessKey, nseq, getConfig()));
    }

    /**
     * This function sends a science manifestation to the Sefaz.
     *
     * @param pair Pair<String, String>
     * @return The return of the method is the object ReturnNfEvent, which contains the return of the operation.
     */
    default ReturnNfEvent science(List<Pair<String, String>> pair) throws CircuitBreakerException, ProcessException, ValidationException, NoProviderFound, SecurityException, SoapServiceGeneralException {
        return manifestation(SendNfEvent.operationScience(pair, getConfig()));
    }

    default ReturnNfEvent science(Pair<String, String> pair) throws CircuitBreakerException, ProcessException, ValidationException, NoProviderFound, SecurityException, SoapServiceGeneralException {
        return science(Collections.singletonList(pair));
    }

    /**
     * It returns a ReturnNfEvent object.
     *
     * @param accessKey The access key of the company that will be used to make the request.
     * @param nseq      The sequence number of the NF-e.
     * @return The return is a ReturnNfEvent object.
     */
    default ReturnNfEvent science(String accessKey, String nseq) throws CircuitBreakerException, ProcessException, ValidationException, NoProviderFound, SecurityException, SoapServiceGeneralException {
        return science(new PairImpl<>(accessKey, nseq));
    }

    /**
     * Ignore the event with the access key and sequence number, and the reason for the ignorance is the motive.
     *
     * @param accessKey The access key of the NF-e.
     * @param motive    The reason for the cancellation.
     * @param nseq      The number of the NF-e to be manifested.
     * @return The return is the object ReturnNfEvent, which contains the following attributes:
     */
    default ReturnNfEvent ignorance(String accessKey, String motive, String nseq) throws CircuitBreakerException, ProcessException, ValidationException, NoProviderFound, SecurityException, SoapServiceGeneralException {
        return manifestation(SendNfEvent.operationIgnorance(accessKey, nseq, motive, getConfig()));
    }

    /**
     * This function sends a message to the Sefaz informing that the operation was not performed.
     *
     * @param accessKey The access key of the NF-e.
     * @param motive    The reason for the cancellation.
     * @param nseq      The sequence number of the NF-e.
     * @return The return is the object ReturnNfEvent, which contains the return of the SEFAZ.
     */
    default ReturnNfEvent notPerformed(String accessKey, String motive, String nseq) throws CircuitBreakerException, ProcessException, ValidationException, NoProviderFound, SecurityException, SoapServiceGeneralException {
        return manifestation(SendNfEvent.operationNotPerformed(accessKey, nseq, motive, getConfig()));
    }

    /**
     * Confirms the receipt of the event of the Manifestation of the Interested Party
     *
     * @param accessKey The access key of the NF-e to be confirmed.
     * @return The return is a ReturnNfEvent object.
     */
    default ReturnNfEvent confirmation(String accessKey) throws CircuitBreakerException, ProcessException, ValidationException, NoProviderFound, SecurityException, SoapServiceGeneralException {
        return confirmation(accessKey, String.valueOf(getNfeQueryProtocolService().getLastSequenceNumber(accessKey, NFEvent.OPERATION_CONFIRMATION)));
    }

    /**
     * It returns the status of the NF-e.
     *
     * @param accessKey The access key of the NF-e.
     * @return The return is a object of type ReturnNfEvent.
     */
    default ReturnNfEvent science(String accessKey) throws CircuitBreakerException, ProcessException, ValidationException, NoProviderFound, SecurityException, SoapServiceGeneralException {
        return science(Collections.singletonList(accessKey));
    }

    /**
     * It returns a ReturnNfEvent object.
     *
     * @param accessKey Collection of access keys to be sent to the Sefaz.
     * @return The return is a collection of objects of type ReturnNfEvent.
     */
    default ReturnNfEvent science(Collection<String> accessKey) throws CircuitBreakerException, ProcessException, ValidationException, NoProviderFound, SecurityException, SoapServiceGeneralException {
        return science(accessKey.stream().map(it -> {
            try {
                return new PairImpl<>(it, String.valueOf(getNfeQueryProtocolService().getLastSequenceNumber(it, NFEvent.OPERATION_SCIENCE)));
            } catch (NoProviderFound | SecurityException | ProcessException | ValidationException |
                     SoapServiceGeneralException | CircuitBreakerException e) {
                throw new RuntimeException(e);
            }
        }).collect(Collectors.toList()));
    }

    /**
     * It returns the ignorance of the NF-e.
     *
     * @param accessKey The access key of the NF-e.
     * @param motive    The reason for the ignorance.
     * @return The return is a object of type ReturnNfEvent.
     */
    default ReturnNfEvent ignorance(String accessKey, String motive) throws CircuitBreakerException, ProcessException, ValidationException, NoProviderFound, SecurityException, SoapServiceGeneralException {
        return ignorance(accessKey, motive, String.valueOf(getNfeQueryProtocolService().getLastSequenceNumber(accessKey, NFEvent.OPERATION_IGNORANCE)));
    }

    /**
     * It cancels the manifest.
     *
     * @param accessKey The access key of the NF-e.
     * @param motive    The reason for the rejection of the event.
     * @return The return is a ReturnNfEvent object.
     */
    default ReturnNfEvent notPerformed(String accessKey, String motive) throws CircuitBreakerException, ProcessException, ValidationException, NoProviderFound, SecurityException, SoapServiceGeneralException {
        return notPerformed(accessKey, motive, String.valueOf(getNfeQueryProtocolService().getLastSequenceNumber(accessKey, NFEvent.OPERATION_NOT_PERFORMED)));
    }

    NfQueryProtocolService getNfeQueryProtocolService();

    @Override
    NfeConfig getConfig();
}
