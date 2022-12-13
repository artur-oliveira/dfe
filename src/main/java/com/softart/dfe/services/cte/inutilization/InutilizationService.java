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

    /**
     * A function that inutilizes a range of CTe numbers.
     *
     * @param model  The model of the CTe.
     * @param ano    The year of the series to be canceled
     * @param serie  The series of the CTe to be canceled.
     * @param start  The first number of the series to be canceled
     * @param end    The last number of the sequence to be canceled.
     * @param motive The reason for the cancellation.
     * @return A CteReturnInutilization object.
     */
    default CteReturnInutilization inutilizar(Model model, Number ano, Number serie, Number start, Number end, String motive) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
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
