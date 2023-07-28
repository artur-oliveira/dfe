package com.softart.dfe.services.nf.return_authorization;

import com.softart.dfe.enums.internal.Environment;
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

    /**
     * It queries the receipt of the NFe.
     *
     * @param receipt The receipt number returned by the Sefaz.
     * @return A ReturnQueryReceiptNfe object.
     */
    default ReturnQueryReceiptNfe queryReceipt(String receipt) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return queryReceipt(receipt, getConfig().environment());
    }

    default ReturnQueryReceiptNfe queryReceipt(String receipt, Environment environment) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return ReturnQueryReceiptNfe
                .builder()
                .build()
                .fromObject(getService(environment).queryReceipt(
                        QueryReceiptNfeRequest
                                .builder()
                                .data(QueryReceiptNfe.builder().nRec(receipt).tpAmb(environment.getCode()).build().toObject())
                                .validators(getValidator().returnAuthorizationValidators())
                                .afterRequest(getProcess().afterReturnAuthorization())
                                .beforeRequest(getProcess().beforeReturnAuthorization())
                                .configureProvider(getConfigureProviderFactory())
                                .config(getConfig().withEnviroment(environment))
                                .build()
                ).second());
    }

    /**
     * Returns the validator used by this class
     *
     * @return The validator object.
     */
    NfCommonValidator getValidator();

    /**
     * This function returns a service object that can be used to make calls to the NfCommonService
     *
     * @param environment The environment you want to connect to.
     * @return A service object that can be used to call the service.
     */
    NfCommonService getService(Environment environment) throws NoProviderFound, SoapServiceGeneralException;

}
