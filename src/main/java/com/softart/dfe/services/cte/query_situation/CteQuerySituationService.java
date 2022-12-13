package com.softart.dfe.services.cte.query_situation;

import com.softart.dfe.enums.cte.CteEvent;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.interfaces.services.CteSefazService;
import com.softart.dfe.models.cte.query_situation.CteQuerySituation;
import com.softart.dfe.models.cte.query_situation.CteQuerySituationRequest;
import com.softart.dfe.models.cte.query_situation.CteReturnQuerySituation;

public interface CteQuerySituationService extends CteSefazService {

    /**
     * It returns the situation of the CTe.
     *
     * @param accessKey The access key provided by the SEFAZ.
     * @return The return is a CteReturnQuerySituation object.
     */
    default CteReturnQuerySituation querySituation(String accessKey) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return CteReturnQuerySituation.builder().build().fromObject(getProviderFactory()
                .getCteService(getConfig())
                .querySituation(CteQuerySituationRequest
                        .builder()
                        .data(CteQuerySituation.build(accessKey, getConfig()).toObject())
                        .config(getConfig())
                        .beforeRequest(getProcess().beforeQuerySituation())
                        .afterRequest(getProcess().afterQuerySituation())
                        .validators(getValidatorFactory().cteValidator().querySituationValidators())
                        .configureProvider(getConfigureProviderFactory())
                        .build()));
    }

    /**
     * > Get the last sequence number for a given event type
     *
     * @param accessKey The access key for the user.
     * @param eventType The type of event you want to get the last sequence number for.
     * @return The last sequence number for the event type.
     */
    default Long getLastSequenceNumber(String accessKey, String eventType) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return querySituation(accessKey).getLastSequenceNumber(eventType);
    }

    /**
     * It returns the last sequence number for a given event.
     *
     * @param accessKey The access key of the provider.
     * @param event     The event code for which you want to get the last sequence number.
     * @return The last sequence number for the given event.
     */
    default Long getLastSequenceNumber(String accessKey, CteEvent event) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return getLastSequenceNumber(accessKey, event.getCode());
    }

    /**
     * > Returns the last sequence number for the given event type as a string
     *
     * @param accessKey The access key for the user.
     * @param eventType The type of event you want to get the last sequence number for.
     * @return The last sequence number for the event type.
     */
    default String getLastSequenceNumberAsString(String accessKey, String eventType) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return querySituation(accessKey).getLastSequenceNumberAsString(eventType);
    }

    /**
     * It returns the last sequence number as a string.
     *
     * @param accessKey The access key of the user who is requesting the sequence number.
     * @param event     The event code.
     * @return The last sequence number for the given event.
     */
    default String getLastSequenceNumberAsString(String accessKey, CteEvent event) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return getLastSequenceNumberAsString(accessKey, event.getCode());
    }
}
