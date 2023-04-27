package com.softart.dfe.services.cte.query_situation;

import com.softart.dfe.enums.cte.CteEvent;
import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.interfaces.internal.config.CteConfig;
import com.softart.dfe.interfaces.services.CteSefazService;
import com.softart.dfe.models.cte.query_situation.CteQuerySituation;
import com.softart.dfe.models.cte.query_situation.CteQuerySituationRequest;
import com.softart.dfe.models.cte.query_situation.CteReturnQuerySituation;

public interface CteQuerySituationService extends CteSefazService {


    /**
     * It queries the situation of a CTe.
     *
     * @param chCTe       CTe key
     * @param environment Environment of the CTe.
     * @return A CteReturnQuerySituation object.
     */
    default CteReturnQuerySituation querySituation(String chCTe, Environment environment) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        CteConfig config = getConfig().withEnviroment(environment);
        return CteReturnQuerySituation.builder().build().fromObject(getProviderFactory()
                .getCteService(config)
                .querySituation(CteQuerySituationRequest
                        .builder()
                        .data(CteQuerySituation.build(chCTe, config).toObject())
                        .config(config)
                        .beforeRequest(getProcess().beforeQuerySituation())
                        .afterRequest(getProcess().afterQuerySituation())
                        .validators(getValidatorFactory().cteValidator().querySituationValidators())
                        .configureProvider(getConfigureProviderFactory())
                        .build()));
    }

    /**
     * Query the status of a CTe
     *
     * @param chCTe CTe key
     * @return The CteReturnQuerySituation object.
     */
    default CteReturnQuerySituation querySituation(String chCTe) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return querySituation(chCTe, getConfig().environment());
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
