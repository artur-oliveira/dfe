package com.softart.dfe.services.mdfe.query_receipt;

import br.inf.portalfiscal.mdfe.classes.TConsReciMDFe;
import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.interfaces.internal.config.MdfeConfig;
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
        MdfeConfig config = getConfig().withEnviroment(tConsReciMDFe.getTpAmb());
        return MdfeReturnQueryReceipt
                .builder()
                .build()
                .fromObject(getProviderFactory()
                        .getMdfeService(config)
                        .queryReceipt(MdfeQueryReceiptRequest
                                .builder()
                                .data(tConsReciMDFe)
                                .config(config)
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
     * @param receipt     The receipt number of the query.
     * @param environment The environment you want to use.
     * @return The return of the query receipt is a MdfeReturnQueryReceipt object.
     */
    default MdfeReturnQueryReceipt queryReceipt(String receipt, Environment environment) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return queryReceipt(MdfeQueryReceipt.build(receipt, getConfig().withEnviroment(environment)));
    }

    /**
     * Query the receipt of a MDF-e
     *
     * @param receipt The receipt number of the MDFe.
     * @return The return is a MdfeReturnQueryReceipt object.
     */
    default MdfeReturnQueryReceipt queryReceipt(String receipt) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return queryReceipt(receipt, getConfig().environment());
    }

}
