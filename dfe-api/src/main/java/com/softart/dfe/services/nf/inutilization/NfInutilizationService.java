package com.softart.dfe.services.nf.inutilization;

import br.inf.portalfiscal.nfe.send.TInutNFe;
import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.Model;
import com.softart.dfe.enums.nf.NFEvent;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.interfaces.internal.config.NfConfig;
import com.softart.dfe.interfaces.sefaz.nf.common.NfCommonService;
import com.softart.dfe.interfaces.services.NfSefazService;
import com.softart.dfe.interfaces.validation.nf.common.NfCommonValidator;
import com.softart.dfe.models.nf.inut.NfeInut;
import com.softart.dfe.models.nf.inut.NfeInutRequest;
import com.softart.dfe.models.nf.inut.ReturnNfeInut;

import java.time.Year;
import java.time.temporal.ChronoField;
import java.util.Objects;

public interface NfInutilizationService extends NfSefazService {

    /**
     * A function that receives a parameter of type TInutNFe and returns a ReturnNfeInut.
     *
     * @param inutNFe The object that contains the data to be sent to the SEFAZ.
     * @return ReturnNfeInut
     */
    default ReturnNfeInut inutilization(TInutNFe inutNFe) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        NfConfig config = getConfig().withEnviroment(inutNFe.getInfInut().getTpAmb());
        return ReturnNfeInut.builder().build().fromObject(getService(config.environment())
                .inutilization(NfeInutRequest
                        .builder()
                        .data(inutNFe)
                        .config(config).signer(getXmlSigner())
                        .validators(getValidator().inutValidators())
                        .afterRequest(getProcess().afterInutilization())
                        .beforeRequest(getProcess().beforeInutilization())
                        .configureProvider(getConfigureProviderFactory())
                        .build()));
    }

    /**
     * It receives a NfeInut object and returns a ReturnNfeInut object
     *
     * @param inut NfeInut object
     * @return The return is a ReturnNfeInut object, which contains the XML of the response from the SEFAZ.
     */
    default ReturnNfeInut inutilization(NfeInut inut) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return inutilization(inut.toObject());
    }

    /**
     * A function that receives the model, year, series, start, end and motive of the inutilization.
     *
     * @param model  The model of the NF-e to be canceled.
     * @param ano    The year of the invoice
     * @param serie  The series of the NFe to be canceled.
     * @param start  The first number of the invoice to be canceled.
     * @param end    The last number of the invoice to be canceled.
     * @param motive The reason for the inutilization.
     * @return ReturnNfeInut
     */
    default ReturnNfeInut inutilization(Model model, Number ano, Number serie, Number start, Number end, String motive) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return inutilization(model, ano, serie, start, end, motive, getConfig().environment());
    }

    /**
     * A function that receives a model, a year, a series, a start, an end, a motive and an environment and returns a
     * ReturnNfeInut.
     *
     * @param model       Model of the NF-e
     * @param ano         The year of the invoice
     * @param serie       The series of the NFe to be canceled.
     * @param start       The first number of the invoice to be canceled.
     * @param end         End of the range of invoices to be canceled.
     * @param motive      The reason for the cancellation.
     * @param environment The environment in which the request will be made.
     * @return The return is the object of the type ReturnNfeInut, which contains the XML of the inutilization request and
     * the XML of the inutilization response.
     */
    default ReturnNfeInut inutilization(Model model, Number ano, Number serie, Number start, Number end, String motive, Environment environment) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return inutilization(NfeInut
                .builder()
                .infInut(NfeInut.InfInut
                        .builder()
                        .ano(Year.of(ano.intValue()).toString().substring(2))
                        .serie(Objects.toString(serie))
                        .nnfIni(Objects.toString(start))
                        .nnfFin(Objects.toString(end))
                        .tpAmb(environment.getCode())
                        .xJust(motive)
                        .cnpj(getConfig().cnpj())
                        .cuf(getConfig().uf().getCode())
                        .mod(model.getCode()).build()).build());
    }


    /**
     * A function that is used to cancel a range of invoices.
     *
     * @param ano    The year of the document to be canceled.
     * @param serie  The series of the NF-e to be canceled.
     * @param start  The first number of the range of numbers to be canceled.
     * @param end    The last number of the series to be canceled.
     * @param motive The reason for the inutilization.
     * @return ReturnNfeInut
     */
    default ReturnNfeInut inutilization(Number ano, Number serie, Number start, Number end, String motive) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return inutilization(getModel(), ano, serie, start, end, motive, getConfig().environment());
    }

    default ReturnNfeInut inutilization(Number ano, Number serie, Number start, Number end, String motive, Environment environment) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return inutilization(getModel(), ano, serie, start, end, motive, environment);
    }

    /**
     * A function that inutilizes a range of NFe numbers.
     *
     * @param serie  The series of the NFe to be canceled.
     * @param start  The first number of the invoice series to be canceled.
     * @param end    The last number of the invoice series to be canceled.
     * @param motive The reason for the inutilization.
     * @return ReturnNfeInut
     */
    default ReturnNfeInut inutilization(Number serie, Number start, Number end, String motive) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return inutilization(Year.now().get(ChronoField.YEAR), serie, start, end, motive);
    }

    /**
     * A function that inutilizes a range of numbers.
     *
     * @param serie The series of the NF-e to be canceled.
     * @param start The first number of the invoice series to be canceled.
     * @param end   End of the range of numbers to be canceled.
     * @return ReturnNfeInut
     */
    default ReturnNfeInut inutilization(Number serie, Number start, Number end) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return inutilization(getModel(), Year.now().get(ChronoField.YEAR), serie, start, end, NFEvent.INUTILIZATION.getDefaultMessage());
    }

    /**
     * A function that receives two parameters and returns a value.
     *
     * @param serie  The series of the document to be canceled.
     * @param number The number of the first NFe to be canceled.
     * @return ReturnNfeInut
     */
    default ReturnNfeInut inutilization(Number serie, Number number) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return inutilization(serie, number, number);
    }

    /**
     * A function that inutilizes a NFe.
     *
     * @param serie  The serie of the NFe to be canceled.
     * @param number The number of the first NFe to be canceled.
     * @param motive The reason for the inutilization.
     * @return ReturnNfeInut
     */
    default ReturnNfeInut inutilization(Number serie, Number number, String motive) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return inutilization(serie, number, number, motive);
    }

    /**
     * * If the service is already instantiated, return it.
     * * If the service is not instantiated, try to instantiate it.
     * * If the service cannot be instantiated, throw an exception
     *
     * @return The service object.
     */
    NfCommonService getService(Environment environment) throws NoProviderFound, SoapServiceGeneralException;

    /**
     * Returns the validator used by this class
     *
     * @return The validator object.
     */
    NfCommonValidator getValidator();

    /**
     * Returns the model that this view is associated with
     *
     * @return The model is being returned.
     */
    Model getModel();

}
