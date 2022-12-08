package com.softart.dfe.services.nf.inutilization;

import br.inf.portalfiscal.nfe.send.TInutNFe;
import br.inf.portalfiscal.nfe.send.TRetInutNFe;
import com.softart.dfe.enums.internal.Model;
import com.softart.dfe.enums.nf.NFEvent;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.interfaces.internal.Pair;
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

    default ReturnNfeInut inutilizar(Model model, int ano, int serie, int start, int end, String motive) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        Pair<TInutNFe, TRetInutNFe> inut = getService()
                .inutilization(NfeInutRequest
                        .builder()
                        .data(NfeInut
                                .builder()
                                .infInut(NfeInut.InfInut
                                        .builder()
                                        .ano(Year.of(ano).toString().substring(2))
                                        .serie(Objects.toString(serie))
                                        .nnfIni(Objects.toString(start))
                                        .nnfFin(Objects.toString(end))
                                        .tpAmb(getConfig().environment().getCode())
                                        .xJust(motive)
                                        .cnpj(getConfig().cnpj())
                                        .cuf(getConfig().uf().getCode())
                                        .mod(model.getCode()).build()).build().toObject())
                        .config(getConfig()).signer(getXmlSigner())
                        .validators(getValidator().inutValidators())
                        .afterRequest(getProcess().afterInutilization())
                        .beforeRequest(getProcess().beforeInutilization())
                        .configureProvider(getConfigureProviderFactory())
                        .build());
        return ReturnNfeInut.builder().build().fromObject(inut.second());
    }

    default ReturnNfeInut inutilizar(int serie, int start, int end, String motive) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return inutilizar(getModel(), Year.now().get(ChronoField.YEAR), serie, start, end, motive);
    }

    default ReturnNfeInut inutilizar(int serie, int start, int end) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return inutilizar(getModel(), Year.now().get(ChronoField.YEAR), serie, start, end, NFEvent.INUTILIZATION.getDefaultMessage());
    }

    NfCommonService getService() throws NoProviderFound, SoapServiceGeneralException;

    NfCommonValidator getValidator();

    Model getModel();

}
