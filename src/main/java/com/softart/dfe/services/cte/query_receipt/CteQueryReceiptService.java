package com.softart.dfe.services.cte.query_receipt;

import br.inf.portalfiscal.cte.send.TConsReciCTe;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.interfaces.services.CteSefazService;
import com.softart.dfe.models.cte.query_receipt.QueryReceipt;
import com.softart.dfe.models.cte.query_receipt.QueryReceiptRequest;
import com.softart.dfe.models.cte.query_receipt.ReturnQueryReceipt;

public interface CteQueryReceiptService extends CteSefazService {
    default ReturnQueryReceipt queryReceipt(TConsReciCTe tConsReciCTe) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return ReturnQueryReceipt
                .builder()
                .build()
                .fromObject(getProviderFactory()
                        .getCteService(getConfig())
                        .queryReceipt(QueryReceiptRequest
                                .builder()
                                .data(tConsReciCTe)
                                .validators(getValidatorFactory().cteValidator().queryReceiptValidators())
                                .signer(getXmlSigner())
                                .config(getConfig())
                                .configureProvider(getConfigureProviderFactory())
                                .beforeRequest(getProcess().beforeQueryReceipt())
                                .afterRequest(getProcess().afterQueryReceipt())
                                .build()));
    }

    default ReturnQueryReceipt queryReceipt(QueryReceipt queryReceipt) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return queryReceipt(queryReceipt.toObject());
    }
    default ReturnQueryReceipt queryReceipt(String receipt) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return queryReceipt(QueryReceipt.builder().tpAmb(getConfig().environment().getCode()).nRec(receipt).build());
    }
}
