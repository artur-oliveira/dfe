package com.softart.dfe.services.nf.query_protocol;

import com.softart.dfe.enums.nf.NFEvent;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.interfaces.sefaz.nf.common.NfCommonService;
import com.softart.dfe.interfaces.services.NfSefazService;
import com.softart.dfe.interfaces.validation.nf.common.NfCommonValidator;
import com.softart.dfe.models.nf.query_protocol.QueryProtocolNfe;
import com.softart.dfe.models.nf.query_protocol.QueryProtocolRequest;
import com.softart.dfe.models.nf.query_protocol.ReturnQueryProtocolNfe;

public interface NfQueryProtocolService extends NfSefazService {

    /**
     * It queries the protocol of the NFe.
     *
     * @param accessKey The access key of the NF-e.
     * @return A ReturnQueryProtocolNfe object.
     */
    default ReturnQueryProtocolNfe queryProtocol(String accessKey) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return ReturnQueryProtocolNfe
                .builder()
                .build()
                .fromObject(getService()
                        .queryProtocol(QueryProtocolRequest
                                .builder()
                                .data(QueryProtocolNfe.builder().chNFe(accessKey).tpAmb(getConfig().environment().getCode()).build().toObject())
                                .validators(getValidator().queryProtocolValidators())
                                .afterRequest(getProcess().afterQueryProtocol())
                                .beforeRequest(getProcess().beforeQueryProtocol())
                                .config(getConfig())
                                .configureProvider(getConfigureProviderFactory())
                                .build())
                        .second());
    }

    /**
     * * If the service is already instantiated, return it.
     * * If the service is not instantiated, try to instantiate it.
     * * If the service cannot be instantiated, throw an exception
     *
     * @return The service object.
     */
    NfCommonService getService() throws NoProviderFound, SoapServiceGeneralException;

    /**
     * > Returns the validator used by this class
     *
     * @return The validator object.
     */
    NfCommonValidator getValidator();

    /**
     * This function returns the last sequence number for the given event type
     *
     * @param accessKey The access key for the account.
     * @param eventType The event type you want to get the last sequence number for.
     * @return The last sequence number for the given event type.
     */
    Long getLastSequenceNumber(String accessKey, String eventType) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException;

    /**
     * > Get the last sequence number for a given event type
     *
     * @param accessKey The access key of the user who is making the request.
     * @param event     The event code for which you want to get the last sequence number.
     * @return The last sequence number for the given event.
     */
    default Long getLastSequenceNumber(String accessKey, NFEvent event) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return getLastSequenceNumber(accessKey, event.getCode());
    }
}
