package org.dfe.services.nf.query_register;

import br.inf.portalfiscal.nfe.send.TConsCad;
import br.inf.portalfiscal.nfe.send.TUfConsCad;
import org.dfe.enums.internal.UF;
import org.dfe.exceptions.ProcessException;
import org.dfe.exceptions.ValidationException;
import org.dfe.exceptions.port.SoapServiceGeneralException;
import org.dfe.exceptions.security.SecurityException;
import org.dfe.exceptions.services.NoProviderFound;
import org.dfe.interfaces.internal.config.NfeConfig;
import org.dfe.interfaces.services.NfSefazService;
import org.dfe.models.nf.query_register.QueryRegister;
import org.dfe.models.nf.query_register.QueryRegisterRequest;
import org.dfe.models.nf.query_register.ReturnQueryRegister;
import org.dfe.util.StringUtils;

public interface NfeQueryRegisterService extends NfSefazService {


    default ReturnQueryRegister queryRegister(TConsCad tConsCad) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return ReturnQueryRegister
                .builder()
                .build()
                .fromObject(
                        getProviderFactory().getNfeService(getConfig().withWebServiceUf(UF.valueOf(tConsCad.getInfCons().getUF().name())))
                                .queryRegister(QueryRegisterRequest
                                        .builder()
                                        .data(tConsCad)
                                        .validators(getValidatorFactory().nfeValidator().queryRegisterValidators())
                                        .afterRequest(getProcess().afterQueryRegister())
                                        .beforeRequest(getProcess().beforeQueryRegister())
                                        .config(getConfig())
                                        .configureProvider(getConfigureProviderFactory())
                                        .build())
                                .second()
                );
    }

    default ReturnQueryRegister queryRegister(QueryRegister queryRegister) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return queryRegister(queryRegister.toObject());
    }

    default ReturnQueryRegister queryRegister(String cnpj, String uf) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return queryRegister(QueryRegister.builder().infCons(QueryRegister.InfCons.builder().cnpj(StringUtils.extractDigits(cnpj)).uf(TUfConsCad.valueOf(uf)).build()).build().toObject());
    }

    default ReturnQueryRegister queryRegister(String cnpj, UF uf) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return queryRegister(cnpj, uf.name());
    }

    default ReturnQueryRegister queryRegisterCpf(String cpf, String uf) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return queryRegister(QueryRegister.builder().infCons(QueryRegister.InfCons.builder().cpf(cpf).uf(TUfConsCad.valueOf(uf)).build()).build().toObject());
    }

    default ReturnQueryRegister queryRegisterCpf(String cpf, UF uf) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return queryRegisterCpf(cpf, uf.name());
    }

    default ReturnQueryRegister queryRegisterIe(String ie, String uf) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return queryRegister(QueryRegister.builder().infCons(QueryRegister.InfCons.builder().ie(ie).uf(TUfConsCad.valueOf(uf)).build()).build().toObject());
    }

    default ReturnQueryRegister queryRegisterIe(String ie, UF uf) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return queryRegisterIe(ie, uf.name());
    }

    @Override
    NfeConfig getConfig();

}
