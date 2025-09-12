package org.dfe.services.nf.return_authorization;

import br.inf.portalfiscal.nfe.send.TRetConsReciNFe;
import org.dfe.enums.internal.Environment;
import org.dfe.enums.internal.Model;
import org.dfe.exceptions.CircuitBreakerException;
import org.dfe.exceptions.ProcessException;
import org.dfe.exceptions.ValidationException;
import org.dfe.exceptions.port.SoapServiceGeneralException;
import org.dfe.exceptions.security.SecurityException;
import org.dfe.exceptions.services.NoProviderFound;
import org.dfe.interfaces.circuitbreaker.DfeOperation;
import org.dfe.interfaces.internal.Pair;
import org.dfe.interfaces.internal.config.NfConfig;
import org.dfe.interfaces.sefaz.nf.common.NfCommonService;
import org.dfe.interfaces.services.NfSefazService;
import org.dfe.interfaces.validation.nf.common.NfCommonValidator;
import org.dfe.models.nf.return_authorization.QueryReceiptNfe;
import org.dfe.models.nf.return_authorization.QueryReceiptNfeRequest;
import org.dfe.models.nf.return_authorization.ReturnQueryReceiptNfe;

public interface NfReturnAuthorizationService extends NfSefazService {

    /**
     * It queries the receipt of the NFe.
     *
     * @param receipt The receipt number returned by the Sefaz.
     * @return A ReturnQueryReceiptNfe object.
     */
    default ReturnQueryReceiptNfe queryReceipt(String receipt) throws CircuitBreakerException, NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return queryReceipt(receipt, getConfig().environment());
    }

    default ReturnQueryReceiptNfe queryReceipt(String receipt, Environment environment) throws CircuitBreakerException, NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        NfConfig config = getConfig().withEnviroment(environment);
        NfCommonService service = getService(environment);
        Pair<?, TRetConsReciNFe> res = getCircuitBreakerRegistry().get(
                environment,
                getModel(),
                config.webServiceUF(),
                DfeOperation.QUERY_RECEIPT
        ).execute(() -> service.queryReceipt(QueryReceiptNfeRequest
                .builder()
                .data(QueryReceiptNfe.builder().nRec(receipt).tpAmb(environment.getCode()).build().toObject())
                .validators(getValidator().returnAuthorizationValidators())
                .afterRequest(getProcess().afterReturnAuthorization())
                .beforeRequest(getProcess().beforeReturnAuthorization())
                .configureProvider(getConfigureProviderFactory())
                .config(config)
                .build()));
        return new ReturnQueryReceiptNfe().fromObject(res);
    }

    Model getModel();

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
    NfCommonService getService(Environment environment) throws CircuitBreakerException, NoProviderFound, SoapServiceGeneralException;

}
