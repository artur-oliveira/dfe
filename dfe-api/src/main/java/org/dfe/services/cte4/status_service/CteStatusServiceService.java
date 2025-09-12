package org.dfe.services.cte4.status_service;

import br.inf.portalfiscal.cte.send400.TRetConsStatServ;
import org.dfe.enums.internal.Environment;
import org.dfe.enums.internal.Model;
import org.dfe.enums.internal.UF;
import org.dfe.exceptions.CircuitBreakerException;
import org.dfe.exceptions.ProcessException;
import org.dfe.exceptions.ValidationException;
import org.dfe.exceptions.port.SoapServiceGeneralException;
import org.dfe.exceptions.security.SecurityException;
import org.dfe.exceptions.services.NoProviderFound;
import org.dfe.interfaces.circuitbreaker.DfeOperation;
import org.dfe.interfaces.internal.Pair;
import org.dfe.interfaces.internal.config.CteConfig;
import org.dfe.interfaces.sefaz.cte4.Cte4Service;
import org.dfe.interfaces.services.Cte4SefazService;
import org.dfe.models.cte4.status_service.CteReturnStatusService;
import org.dfe.models.cte4.status_service.CteStatusService;
import org.dfe.models.cte4.status_service.CteStatusServiceRequest;

public interface CteStatusServiceService extends Cte4SefazService {


    /**
     * It returns the status of the CTe service.
     *
     * @param uf          The state of the CTe.
     * @param environment Environment.HOMOLOGATION or Environment.PRODUCTION
     * @return A CteReturnStatusService object.
     */
    default CteReturnStatusService statusService(UF uf, Environment environment) throws CircuitBreakerException, NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        CteConfig config = getConfig().withEnviroment(environment).withWebServiceUf(uf);

        Cte4Service service = getProviderFactory().getCte4Service(config);
        Pair<?, TRetConsStatServ> res = getCircuitBreakerRegistry().get(
                config.environment(),
                Model.CTE,
                config.webServiceUF(),
                DfeOperation.STATUS_SERVICE
        ).execute(() -> service.statusService(CteStatusServiceRequest
                .builder()
                .data(CteStatusService.builder().cuf(uf.getCode()).tpAmb(environment.getCode()).build().toObject())
                .validators(getValidatorFactory().cte4Validator().statusServiceValidators())
                .afterRequest(getProcess().afterStatusService())
                .beforeRequest(getProcess().beforeStatusService())
                .configureProvider(getConfigureProviderFactory())
                .config(config)
                .build()));

        return new CteReturnStatusService().fromObject(res);
    }


    /**
     * It returns the status of the CTe service.
     *
     * @return A CteReturnStatusService object.
     */
    default CteReturnStatusService statusService() throws CircuitBreakerException, NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return statusService(getConfig().uf(), getConfig().environment());
    }

}
