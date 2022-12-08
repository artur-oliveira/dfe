package com.softart.dfe.services.nf.interested_actor;

import br.inf.portalfiscal.nfe.event_interested_actor.TEnvEvento;
import br.inf.portalfiscal.nfe.event_interested_actor.TRetEnvEvento;
import com.softart.dfe.enums.nf.NFEvent;
import com.softart.dfe.enums.nf.interested_actor.NFDownloadAuthorization;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.interfaces.internal.Pair;
import com.softart.dfe.models.nf.interested_actor.NfeInterestedActorRequest;
import com.softart.dfe.models.nf.interested_actor.ReturnNfeInterestedActor;
import com.softart.dfe.models.nf.interested_actor.SendNfeInterestedActor;
import com.softart.dfe.services.nf.query_protocol.NfQueryProtocolService;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractNfeInterestedActorService implements NfeInterestedActorService {

    @Override
    public ReturnNfeInterestedActor interestedActor(String accessKey, String cpf, String cnpj, String nseq, NFDownloadAuthorization authorization) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        Pair<TEnvEvento, TRetEnvEvento> response = getProviderFactory()
                .getNfeService(getConfig())
                .interestedActor(NfeInterestedActorRequest
                        .builder()
                        .data(SendNfeInterestedActor.interestedActor(accessKey, cpf, cnpj, nseq, authorization, getConfig()).toObject())
                        .config(getConfig())
                        .signer(getXmlSigner())
                        .validators(getValidatorFactory().nfeValidator().interestedActorValidators())
                        .afterRequest(getProcess().afterInterestedActor())
                        .beforeRequest(getProcess().beforeInterestedActor())
                        .configureProvider(getConfigureProviderFactory())
                        .build());

        return ReturnNfeInterestedActor.builder().build().fromObject(response.second());
    }

    @Override
    public ReturnNfeInterestedActor interestedActor(String accessKey, String cpf, String cnpj, NFDownloadAuthorization authorization) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return interestedActor(accessKey, cpf, cnpj, String.valueOf(getNfeQueryProtocolService().getLastSequenceNumber(accessKey, NFEvent.INTERESTED_ACTOR)), authorization);
    }

    @Override
    public ReturnNfeInterestedActor interestedActor(String accessKey, String cpf, String cnpj) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return interestedActor(accessKey, cpf, cnpj, NFDownloadAuthorization.YES);
    }

    protected abstract NfQueryProtocolService getNfeQueryProtocolService();


}
