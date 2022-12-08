package com.softart.dfe.services.cte.query_situation;

import com.softart.dfe.enums.cte.CteEvent;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.interfaces.services.CteSefazService;
import com.softart.dfe.models.cte.query_situation.CteReturnQuerySituation;

public interface CteQuerySituationService extends CteSefazService {

    CteReturnQuerySituation querySituation(String accessKey) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException;

    Long getLastSequenceNumber(String accessKey, String eventType) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException;

    default Long getLastSequenceNumber(String accessKey, CteEvent event) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return getLastSequenceNumber(accessKey, event.getCode());
    }
}
