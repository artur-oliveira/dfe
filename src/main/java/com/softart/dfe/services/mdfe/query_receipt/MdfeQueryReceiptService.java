package com.softart.dfe.services.mdfe.query_receipt;

import br.inf.portalfiscal.mdfe.classes.TConsReciMDFe;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.interfaces.services.MdfeSefazService;
import com.softart.dfe.models.mdfe.query_receipt.MdfeQueryReceipt;
import com.softart.dfe.models.mdfe.query_receipt.MdfeQueryReceiptRequest;
import com.softart.dfe.models.mdfe.query_receipt.MdfeReturnQueryReceipt;

public interface MdfeQueryReceiptService extends MdfeSefazService {

    /**
     * It queries the receipt of the MDFe.
     *
     * @param tConsReciMDFe The object that contains the receipt number.
     * @return A MdfeReturnQueryReceipt object.
     */
    default MdfeReturnQueryReceipt queryReceipt(TConsReciMDFe tConsReciMDFe) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return MdfeReturnQueryReceipt
                .builder()
                .build()
                .fromObject(getProviderFactory()
                        .getMdfeService(getConfig())
                        .queryReceipt(MdfeQueryReceiptRequest
                                .builder()
                                .data(tConsReciMDFe)
                                .config(getConfig())
                                .signer(getXmlSigner())
                                .validators(getValidatorFactory().mdfeValidator().queryReceiptValidators())
                                .afterRequest(getProcess().afterQueryReceipt())
                                .beforeRequest(getProcess().beforeQueryReceipt())
                                .configureProvider(getConfigureProviderFactory())
                                .build()));
    }

    /**
     * It queries the receipt of a MDF-e
     *
     * @param queryReceipt The query receipt object.
     * @return The return is a MdfeReturnQueryReceipt object.
     */
    default MdfeReturnQueryReceipt queryReceipt(MdfeQueryReceipt queryReceipt) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return queryReceipt(queryReceipt.toObject());
    }

    /**
     * It queries the receipt of a MDF-e
     *
     * @param receipt The receipt number of the query.
     * @return The return is a MdfeReturnQueryReceipt object.
     */
    default MdfeReturnQueryReceipt queryReceipt(String receipt) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return queryReceipt(MdfeQueryReceipt.build(receipt, getConfig()));
    }

}
