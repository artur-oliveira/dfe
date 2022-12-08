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

    NfCommonService getService() throws NoProviderFound, SoapServiceGeneralException;

    NfCommonValidator getValidator();

    Long getLastSequenceNumber(String accessKey, String eventType) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException;

    default Long getLastSequenceNumber(String accessKey, NFEvent event) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return getLastSequenceNumber(accessKey, event.getCode());
    }
}
