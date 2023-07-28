package com.softart.dfe.services.nf.query_gtin;

import br.inf.portalfiscal.nfe.gtin.TConsGTIN;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.interfaces.internal.config.NfeConfig;
import com.softart.dfe.interfaces.services.NfSefazService;
import com.softart.dfe.models.nf.query_gtin.QueryGtinNf;
import com.softart.dfe.models.nf.query_gtin.QueryGtinRequest;
import com.softart.dfe.models.nf.query_gtin.ReturnQueryGtinNf;

public interface NfQueryGtinService extends NfSefazService {

    /**
     * It queries the GTIN (Global Trade Item Number) of a product.
     *
     * @param tConsGTIN The object that contains the data to be sent to the SEFAZ.
     * @return A ReturnQueryGtinNf object.
     */
    default ReturnQueryGtinNf queryGtin(TConsGTIN tConsGTIN) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return ReturnQueryGtinNf
                .builder()
                .build()
                .fromObject(
                        getProviderFactory().getNfeService(getConfig())
                                .queryGtin(QueryGtinRequest
                                        .builder()
                                        .data(tConsGTIN)
                                        .validators(getValidatorFactory().nfeValidator().queryGtinValidators())
                                        .afterRequest(getProcess().afterQueryGtin())
                                        .beforeRequest(getProcess().beforeQueryGtin())
                                        .config(getConfig())
                                        .configureProvider(getConfigureProviderFactory())
                                        .build())
                                .second()
                );
    }

    /**
     * It converts the queryGtinNf object to a queryGtinNf object.
     *
     * @param queryGtinNf The queryGtinNf object that contains the parameters for the query.
     * @return The return type is a ReturnQueryGtinNf object.
     */
    default ReturnQueryGtinNf queryGtin(QueryGtinNf queryGtinNf) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return queryGtin(queryGtinNf.toObject());
    }

    /**
     * It returns the GTIN information.
     *
     * @param gtin The GTIN of the product you want to query.
     * @return The return is a ReturnQueryGtinNf object.
     */
    default ReturnQueryGtinNf queryGtin(String gtin) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return queryGtin(QueryGtinNf.builder().gtin(gtin).build().toObject());
    }

    @Override
    NfeConfig getConfig();

}
