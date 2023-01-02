package com.softart.dfe.services.nf.interested_actor;

import com.softart.dfe.enums.nf.NFEvent;
import com.softart.dfe.enums.nf.interested_actor.NFDownloadAuthorization;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.models.nf.interested_actor.ReturnNfeInterestedActor;
import com.softart.dfe.services.nf.query_protocol.NfQueryProtocolService;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractNfeInterestedActorService implements NfeInterestedActorService {

    @Override
    public ReturnNfeInterestedActor interestedActor(String accessKey, String cpf, String cnpj, NFDownloadAuthorization authorization) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return interestedActor(accessKey, cpf, cnpj, String.valueOf(getNfeQueryProtocolService().getLastSequenceNumber(accessKey, NFEvent.INTERESTED_ACTOR)), authorization);
    }

    protected abstract NfQueryProtocolService getNfeQueryProtocolService();


}
