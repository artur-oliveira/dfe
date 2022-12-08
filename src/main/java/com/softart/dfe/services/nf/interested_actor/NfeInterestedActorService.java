package com.softart.dfe.services.nf.interested_actor;

import com.softart.dfe.enums.nf.interested_actor.NFDownloadAuthorization;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.interfaces.services.NfSefazService;
import com.softart.dfe.models.nf.interested_actor.ReturnNfeInterestedActor;

public interface NfeInterestedActorService extends NfSefazService {

    ReturnNfeInterestedActor interestedActor(String accessKey, String cpf, String cnpj, String nseq, NFDownloadAuthorization authorization) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException;

    ReturnNfeInterestedActor interestedActor(String accessKey, String cpf, String cnpj, NFDownloadAuthorization authorization) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException;

    ReturnNfeInterestedActor interestedActor(String accessKey, String cpf, String cnpj) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException;

}
