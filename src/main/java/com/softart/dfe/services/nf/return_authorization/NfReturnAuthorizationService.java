package com.softart.dfe.services.nf.return_authorization;

import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.interfaces.sefaz.nf.common.NfCommonService;
import com.softart.dfe.interfaces.services.NfSefazService;
import com.softart.dfe.interfaces.validation.nf.common.NfCommonValidator;
import com.softart.dfe.models.nf.return_authorization.QueryReceiptNfe;
import com.softart.dfe.models.nf.return_authorization.QueryReceiptNfeRequest;
import com.softart.dfe.models.nf.return_authorization.ReturnQueryReceiptNfe;

public interface NfReturnAuthorizationService extends NfSefazService {

    default ReturnQueryReceiptNfe queryReceipt(String receipt) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return ReturnQueryReceiptNfe
                .builder()
                .build()
                .fromObject(getService().queryReceipt(
                        QueryReceiptNfeRequest
                                .builder()
                                .data(QueryReceiptNfe.builder().nRec(receipt).tpAmb(getConfig().environment().getCode()).build().toObject())
                                .validators(getValidator().returnAuthorizationValidators())
                                .afterRequest(getProcess().afterReturnAuthorization())
                                .beforeRequest(getProcess().beforeReturnAuthorization())
                                .configureProvider(getConfigureProviderFactory())
                                .config(getConfig())
                                .build()
                ).second());
    }

    NfCommonValidator getValidator();

    NfCommonService getService() throws NoProviderFound, SoapServiceGeneralException;

}
