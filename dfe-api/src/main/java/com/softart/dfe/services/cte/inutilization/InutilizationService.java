package com.softart.dfe.services.cte.inutilization;

import com.softart.dfe.enums.cte.CteEvent;
import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.Model;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.interfaces.internal.config.CteConfig;
import com.softart.dfe.interfaces.services.CteSefazService;
import com.softart.dfe.models.cte.inutilization.CteInutilization;
import com.softart.dfe.models.cte.inutilization.CteInutilizationRequest;
import com.softart.dfe.models.cte.inutilization.CteReturnInutilization;

import java.time.Year;
import java.time.temporal.ChronoField;

public interface InutilizationService extends CteSefazService {


    /**
     * A function that inutilizes a range of CTe numbers.
     *
     * @param model       The model of the CTe.
     * @param ano         The year of the inutilization
     * @param serie       The series of the CTe to be canceled.
     * @param start       The first number of the series to be canceled.
     * @param end         End of the range of numbers to be canceled.
     * @param motive      The reason for the cancellation.
     * @param environment The environment in which the request will be made.
     * @return A CteReturnInutilization object.
     */
    default CteReturnInutilization inutilizar(Model model, Number ano, Number serie, Number start, Number end, String motive, Environment environment) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        CteConfig config = getConfig().withEnviroment(environment);
        return CteReturnInutilization
                .builder()
                .build()
                .fromObject(getProviderFactory().getCteService(config)
                        .inutilization(CteInutilizationRequest
                                .builder()
                                .data(CteInutilization.build(ano, serie, start, end, motive, model, config).toObject())
                                .config(config).signer(getXmlSigner())
                                .validators(getValidatorFactory().cteValidator().inutilizationValidators())
                                .afterRequest(getProcess().afterInutilization())
                                .beforeRequest(getProcess().beforeInutilization())
                                .configureProvider(getConfigureProviderFactory())
                                .build()).second());
    }

    /**
     * Inutilizar(Model model, Number ano, Number serie, Number start, Number end, String motive, Environment environment)
     *
     * @param model  The model of the Cte.
     * @param ano    The year of the CTe
     * @param serie  The series of the CTe.
     * @param start  The first number of the range to be invalidated.
     * @param end    The last number of the range to be invalidated.
     * @param motive The reason for the inutilization.
     * @return The CteReturnInutilization object.
     */
    default CteReturnInutilization inutilizar(Model model, Number ano, Number serie, Number start, Number end, String motive) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return inutilizar(model, ano, serie, start, end, motive, getConfig().environment());
    }

    /**
     * A function that inutilizes a Cte.
     *
     * @param serie  The series of the CTe to be inutilized.
     * @param start  The first number of the series to be canceled.
     * @param end    The last number of the series to be canceled.
     * @param motive The reason for the inutilization.
     * @return The CteReturnInutilization object.
     */
    default CteReturnInutilization inutilizar(Number serie, Number start, Number end, String motive) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return inutilizar(getModel(), Year.now().get(ChronoField.YEAR), serie, start, end, motive);
    }

    /**
     * A function that inutilizes a CTe.
     *
     * @param serie The series of the CTe to be inutilized.
     * @param start The first number of the series to be canceled.
     * @param end   The last number of the series to be canceled.
     * @return The CteReturnInutilization object.
     */
    default CteReturnInutilization inutilizar(Number serie, Number start, Number end) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return inutilizar(serie, start, end, CteEvent.INUTILIZATION.getDefaultMessage());
    }

    /**
     * A function that inutilizar the CteReturnInutilization.
     *
     * @param serie  The series of the CTe to be inutilized.
     * @param number The number of the first CTe to be canceled.
     * @return The CteReturnInutilization object.
     */
    default CteReturnInutilization inutilizar(Number serie, Number number) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return inutilizar(serie, number, number);
    }

    /**
     * Returns the model that this view is associated with
     *
     * @return The model is being returned.
     */
    Model getModel();

}
