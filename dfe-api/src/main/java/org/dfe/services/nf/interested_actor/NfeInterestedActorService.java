package org.dfe.services.nf.interested_actor;

import br.inf.portalfiscal.nfe.event_interested_actor.TEnvEvento;
import org.dfe.enums.nf.NFEvent;
import org.dfe.enums.nf.interested_actor.NFDownloadAuthorization;
import org.dfe.exceptions.ProcessException;
import org.dfe.exceptions.ValidationException;
import org.dfe.exceptions.port.SoapServiceGeneralException;
import org.dfe.exceptions.security.SecurityException;
import org.dfe.exceptions.services.NoProviderFound;
import org.dfe.interfaces.internal.config.NfeConfig;
import org.dfe.interfaces.services.NfSefazService;
import org.dfe.models.nf.interested_actor.NfeInterestedActorRequest;
import org.dfe.models.nf.interested_actor.ReturnNfeInterestedActor;
import org.dfe.models.nf.interested_actor.SendNfeInterestedActor;
import org.dfe.services.nf.query_protocol.NfeQueryProtocolService;

public interface NfeInterestedActorService extends NfSefazService {

    /**
     * A function that sends an interested actor to the SEFAZ.
     *
     * @param tEnvEvento The object that will be sent to the SEFAZ.
     * @return A ReturnNfeInterestedActor object.
     */
    default ReturnNfeInterestedActor interestedActor(TEnvEvento tEnvEvento) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        NfeConfig config = getConfig().withEnviroment(tEnvEvento.getEvento().stream().findFirst().map(it -> it.getInfEvento().getTpAmb()).orElse(getConfig().environment().getCode()));
        return ReturnNfeInterestedActor.builder().build().fromObject(getProviderFactory()
                .getNfeService(config)
                .interestedActor(NfeInterestedActorRequest
                        .builder()
                        .data(tEnvEvento)
                        .config(config)
                        .signer(getXmlSigner())
                        .validators(getValidatorFactory().nfeValidator().interestedActorValidators())
                        .afterRequest(getProcess().afterInterestedActor())
                        .beforeRequest(getProcess().beforeInterestedActor())
                        .configureProvider(getConfigureProviderFactory())
                        .build()));
    }

    /**
     * It converts the sendNfeInterestedActor object to an object and then calls the interestedActor function.
     *
     * @param sendNfeInterestedActor The object that contains the data to be sent to the webservice.
     * @return The return is the object of the class ReturnNfeInterestedActor.
     */
    default ReturnNfeInterestedActor interestedActor(SendNfeInterestedActor sendNfeInterestedActor) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
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
     * @return ReturnNfeInterestedActor
     */
    default ReturnNfeInterestedActor interestedActor(String accessKey, String cpf, String cnpj, String nseq, NFDownloadAuthorization authorization) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return interestedActor(SendNfeInterestedActor.interestedActor(accessKey, cpf, cnpj, nseq, authorization, getConfig()));
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
    default ReturnNfeInterestedActor interestedActor(String accessKey, String cpf, String cnpj, NFDownloadAuthorization authorization) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return interestedActor(accessKey, cpf, cnpj, String.valueOf(getNfeQueryProtocolService().getLastSequenceNumber(accessKey, NFEvent.INTERESTED_ACTOR)), authorization);
    }

    /**
     * It returns the interested actor of a NFE
     *
     * @param accessKey The access key of the user who is making the request.
     * @param cpf       CPF of the interested party
     * @param cnpj      The CNPJ of the company that is interested in the NFe.
     * @return ReturnNfeInterestedActor
     */
    default ReturnNfeInterestedActor interestedActor(String accessKey, String cpf, String cnpj) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return interestedActor(accessKey, cpf, cnpj, NFDownloadAuthorization.YES);
    }

    /**
     * It returns the interested actor of a NFE
     *
     * @param accessKey The access key of the user who is making the request.
     * @param cpf       CPF of the interested party
     * @param cnpj      The CNPJ of the company that is interested in the NFe.
     * @return ReturnNfeInterestedActor
     */
    default ReturnNfeInterestedActor noInterestedActor(String accessKey, String cpf, String cnpj) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return interestedActor(accessKey, cpf, cnpj, NFDownloadAuthorization.NO);
    }

    NfeQueryProtocolService getNfeQueryProtocolService();

    @Override
    NfeConfig getConfig();
}
