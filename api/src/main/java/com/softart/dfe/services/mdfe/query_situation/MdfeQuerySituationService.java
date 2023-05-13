package com.softart.dfe.services.mdfe.query_situation;

import br.inf.portalfiscal.mdfe.classes.TConsSitMDFe;
import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.mdfe.MdfeEvent;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.interfaces.internal.config.MdfeConfig;
import com.softart.dfe.interfaces.services.MdfeSefazService;
import com.softart.dfe.models.mdfe.query_situation.MdfeQuerySituation;
import com.softart.dfe.models.mdfe.query_situation.MdfeQuerySituationRequest;
import com.softart.dfe.models.mdfe.query_situation.MdfeReturnQuerySituation;

public interface MdfeQuerySituationService extends MdfeSefazService {

    /**
     * It creates a request object, sends it to the provider, and returns a response object
     *
     * @param tConsSitMDFe The object that contains the query parameters.
     * @return A MdfeReturnQuerySituation object.
     */
    default MdfeReturnQuerySituation querySituation(TConsSitMDFe tConsSitMDFe) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        MdfeConfig config = getConfig().withEnviroment(tConsSitMDFe.getTpAmb());
        return MdfeReturnQuerySituation
                .builder()
                .build()
                .fromObject(getProviderFactory()
                        .getMdfeService(config)
                        .querySituation(MdfeQuerySituationRequest
                                .builder()
                                .data(tConsSitMDFe)
                                .config(config)
                                .signer(getXmlSigner())
                                .validators(getValidatorFactory().mdfeValidator().querySituationValidators())
                                .afterRequest(getProcess().afterQuerySituation())
                                .beforeRequest(getProcess().beforeQuerySituation())
                                .configureProvider(getConfigureProviderFactory())
                                .build()));
    }

    /**
     * It queries the situation of a MDF-e
     *
     * @param o The o object is a MdfeQuerySituation object.
     * @return The return is a MdfeReturnQuerySituation object.
     */
    default MdfeReturnQuerySituation querySituation(MdfeQuerySituation o) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return querySituation(o.toObject());
    }


    /**
     * It queries the situation of a MDF-e
     *
     * @param accessKey   The access key of the MDF-e.
     * @param environment The environment you want to use.
     * @return The return of the querySituation method is a MdfeReturnQuerySituation object.
     */
    default MdfeReturnQuerySituation querySituation(String accessKey, Environment environment) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return querySituation(MdfeQuerySituation.build(accessKey, getConfig().withEnviroment(environment)));
    }

    /**
     * It queries the situation of a MDF-e
     *
     * @param accessKey The access key of the MDF-e.
     * @return The return is a MdfeReturnQuerySituation object.
     */
    default MdfeReturnQuerySituation querySituation(String accessKey) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return querySituation(accessKey, getConfig().environment());
    }

    /**
     * Get the last sequence number for a given event type
     *
     * @param accessKey The access key for the user.
     * @param eventType The type of event you want to get the last sequence number for.
     * @return The last sequence number for the event type.
     */
    default Long getLastSequenceNumber(String accessKey, String eventType) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return querySituation(accessKey).getLastSequenceNumber(eventType);
    }

    /**
     * Get the last sequence number of the event
     *
     * @param accessKey The access key of the provider.
     * @param event     The event that you want to get the last sequence number.
     * @return The last sequence number of the event.
     */
    default Long getLastSequenceNumber(String accessKey, MdfeEvent event) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return getLastSequenceNumber(accessKey, event.getCode());
    }

    /**
     * It returns the last sequence number of the given event, as a string
     *
     * @param accessKey The access key of the provider.
     * @param event     The event that you want to get the last sequence number.
     * @return The last sequence number of the event.
     */
    default String getLastSequenceNumberAsString(String accessKey, MdfeEvent event) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return getLastSequenceNumberAsString(accessKey, event.getCode());
    }

    /**
     * Returns the last sequence number for the given event type as a string
     *
     * @param accessKey The access key for the user.
     * @param eventType The type of event you want to get the last sequence number for.
     * @return The last sequence number for the event type.
     */
    default String getLastSequenceNumberAsString(String accessKey, String eventType) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return querySituation(accessKey).getLastSequenceNumberAsString(eventType);
    }
}
