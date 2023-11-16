package org.dfe.services.cte.query_receipt;

import br.inf.portalfiscal.cte.send.TConsReciCTe;
import org.dfe.enums.internal.Environment;
import org.dfe.exceptions.ProcessException;
import org.dfe.exceptions.ValidationException;
import org.dfe.exceptions.port.SoapServiceGeneralException;
import org.dfe.exceptions.security.SecurityException;
import org.dfe.exceptions.services.NoProviderFound;
import org.dfe.interfaces.internal.config.CteConfig;
import org.dfe.interfaces.services.CteSefazService;
import org.dfe.models.cte.query_receipt.QueryReceipt;
import org.dfe.models.cte.query_receipt.QueryReceiptRequest;
import org.dfe.models.cte.query_receipt.ReturnQueryReceipt;

public interface CteQueryReceiptService extends CteSefazService {
    /**
     * It queries the receipt of a CTe.
     *
     * @param tConsReciCTe The object that contains the data to be sent to the SEFAZ.
     * @return A ReturnQueryReceipt object.
     */
    default ReturnQueryReceipt queryReceipt(TConsReciCTe tConsReciCTe) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        CteConfig config = getConfig().withEnviroment(tConsReciCTe.getTpAmb());
        return ReturnQueryReceipt
                .builder()
                .build()
                .fromObject(getProviderFactory()
                        .getCteService(config)
                        .queryReceipt(QueryReceiptRequest
                                .builder()
                                .data(tConsReciCTe)
                                .validators(getValidatorFactory().cteValidator().queryReceiptValidators())
                                .signer(getXmlSigner())
                                .config(config)
                                .configureProvider(getConfigureProviderFactory())
                                .beforeRequest(getProcess().beforeQueryReceipt())
                                .afterRequest(getProcess().afterQueryReceipt())
                                .build()));
    }

    /**
     * It converts the queryReceipt object to an object and then calls the queryReceipt function.
     *
     * @param queryReceipt The query receipt object.
     * @return The return value is a ReturnQueryReceipt object.
     */
    default ReturnQueryReceipt queryReceipt(QueryReceipt queryReceipt) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return queryReceipt(queryReceipt.toObject());
    }


    /**
     * It queries the status of a receipt
     *
     * @param receipt     The receipt number to be queried.
     * @param environment The environment you want to use.
     * @return ReturnQueryReceipt
     */
    default ReturnQueryReceipt queryReceipt(String receipt, Environment environment) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return queryReceipt(QueryReceipt.builder().tpAmb(environment.getCode()).nRec(receipt).build());
    }

    /**
     * It queries the receipt of a transaction.
     *
     * @param receipt The receipt number to query
     * @return A ReturnQueryReceipt object.
     */
    default ReturnQueryReceipt queryReceipt(String receipt) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return queryReceipt(receipt, getConfig().environment());
    }
}
