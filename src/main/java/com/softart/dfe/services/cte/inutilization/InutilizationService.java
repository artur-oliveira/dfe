package com.softart.dfe.services.cte.inutilization;

import com.softart.dfe.enums.cte.CteEvent;
import com.softart.dfe.enums.internal.Model;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.interfaces.services.CteSefazService;
import com.softart.dfe.models.cte.inutilization.CteInutilization;
import com.softart.dfe.models.cte.inutilization.CteInutilizationRequest;
import com.softart.dfe.models.cte.inutilization.CteReturnInutilization;

import java.time.Year;
import java.time.temporal.ChronoField;

public interface InutilizationService extends CteSefazService {

    default CteReturnInutilization inutilizar(Model model, int ano, int serie, int start, int end, String motive) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return CteReturnInutilization
                .builder()
                .build()
                .fromObject(getProviderFactory().getCteService(getConfig())
                        .inutilization(CteInutilizationRequest
                                .builder()
                                .data(CteInutilization.build(ano, serie, start, end, motive, model, getConfig()).toObject())
                                .config(getConfig()).signer(getXmlSigner())
                                .validators(getValidatorFactory().cteValidator().inutilizationValidators())
                                .afterRequest(getProcess().afterInutilization())
                                .beforeRequest(getProcess().beforeInutilization())
                                .configureProvider(getConfigureProviderFactory())
                                .build()).second());
    }

    default CteReturnInutilization inutilizar(int serie, int start, int end, String motive) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return inutilizar(getModel(), Year.now().get(ChronoField.YEAR), serie, start, end, motive);
    }

    default CteReturnInutilization inutilizar(int serie, int start, int end) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return inutilizar(getModel(), Year.now().get(ChronoField.YEAR), serie, start, end, CteEvent.INUTILIZATION.getDefaultMessage());
    }

    Model getModel();

}
