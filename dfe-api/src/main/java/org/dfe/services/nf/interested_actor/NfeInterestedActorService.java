package org.dfe.services.nf.interested_actor;

import br.inf.portalfiscal.nfe.event_generic.TEnvEvento;
import br.inf.portalfiscal.nfe.event_generic.TRetEnvEvento;
import org.dfe.enums.internal.Model;
import org.dfe.enums.internal.nf.NfeAuthorizer;
import org.dfe.enums.nf.NFEvent;
import org.dfe.enums.nf.interested_actor.NFDownloadAuthorization;
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

public interface NfeInterestedActorService extends NfSefazService {

    /**
     * A function that sends an interested actor to the SEFAZ.
     *
     * @param tEnvEvento The object that will be sent to the SEFAZ.
     * @return A ReturnNfEvent object.
     */
    default ReturnNfEvent interestedActor(TEnvEvento tEnvEvento) throws CircuitBreakerException, NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        NfeConfig config = getConfig().withEnviroment(tEnvEvento.getEvento().stream().findFirst().map(it -> it.getInfEvento().getTpAmb()).orElse(getConfig().environment().getCode()));
        NfeService service = getProviderFactory().getNfeService(config, NfeAuthorizer.AN);
        Pair<?, TRetEnvEvento> res = getCircuitBreakerRegistry().get(
                config.environment(),
                Model.NFE,
                config.webServiceUF(),
                DfeOperation.EVENT
        ).execute(() -> service.eventAN(NfEventRequest
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
     * It converts the SendNfEvent object to an object and then calls the interestedActor function.
     *
     * @param sendNfeInterestedActor The object that contains the data to be sent to the webservice.
     * @return The return is the object of the class ReturnNfEvent.
     */
    default ReturnNfEvent interestedActor(SendNfEvent sendNfeInterestedActor) throws CircuitBreakerException, NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return interestedActor(sendNfeInterestedActor.toObject());
    }

    /**
     * A function that returns the interested actor.
     *
     * @param accessKey     The access key of the NF-e.
     * @param cpf           CPF of the interested party
     * @param cnpj          CNPJ of the company that will receive the NF-e.
     * @param nseq          The sequence number of the NF-e.
     * @param authorization The authorization object returned by the authorization method.
     * @return ReturnNfEvent
     */
    default ReturnNfEvent interestedActor(String accessKey, String cpf, String cnpj, String nseq, NFDownloadAuthorization authorization) throws CircuitBreakerException, NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return interestedActor(SendNfEvent.interestedActor(accessKey, cpf, cnpj, nseq, authorization, getConfig()));
    }

    /**
     * It returns the interested actor of a NFe
     *
     * @param accessKey     The access key of the interested actor.
     * @param cpf           The CPF of the interested party.
     * @param cnpj          The CNPJ of the company that is interested in the NFe.
     * @param authorization The authorization object returned by the method "authorizeDownload"
     * @return The interested actor is the person who is responsible for the NF-e.
     */
    default ReturnNfEvent interestedActor(String accessKey, String cpf, String cnpj, NFDownloadAuthorization authorization) throws CircuitBreakerException, NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return interestedActor(accessKey, cpf, cnpj, String.valueOf(getNfeQueryProtocolService().getLastSequenceNumber(accessKey, NFEvent.INTERESTED_ACTOR)), authorization);
    }

    /**
     * It returns the interested actor of a NFE
     *
     * @param accessKey The access key of the user who is making the request.
     * @param cpf       CPF of the interested party
     * @param cnpj      The CNPJ of the company that is interested in the NFe.
     * @return ReturnNfEvent
     */
    default ReturnNfEvent interestedActor(String accessKey, String cpf, String cnpj) throws CircuitBreakerException, NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return interestedActor(accessKey, cpf, cnpj, NFDownloadAuthorization.YES);
    }

    /**
     * It returns the interested actor of a NFE
     *
     * @param accessKey The access key of the user who is making the request.
     * @param cpf       CPF of the interested party
     * @param cnpj      The CNPJ of the company that is interested in the NFe.
     * @return ReturnNfEvent
     */
    default ReturnNfEvent noInterestedActor(String accessKey, String cpf, String cnpj) throws CircuitBreakerException, NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return interestedActor(accessKey, cpf, cnpj, NFDownloadAuthorization.NO);
    }

    NfeQueryProtocolService getNfeQueryProtocolService();

    @Override
    NfeConfig getConfig();
}
