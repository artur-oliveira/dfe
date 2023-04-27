package com.softart.dferestapi.services.nfce;


import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.interfaces.internal.config.NfceConfig;
import com.softart.dfe.models.nf.authorization.ReturnSendNf;
import com.softart.dfe.models.nf.authorization.SendNf;
import com.softart.dfe.models.nf.cancel.NfeCancel;
import com.softart.dfe.models.nf.cancel.ReturnNfeCancel;
import com.softart.dfe.models.nf.cancel.SendNfeCancel;
import com.softart.dfe.models.nf.inut.ReturnNfeInut;
import com.softart.dfe.models.nf.query_protocol.ReturnQueryProtocolNfe;
import com.softart.dfe.models.nf.query_status_service.ReturnQueryStatusServiceNf;
import com.softart.dfe.models.nf.return_authorization.ReturnQueryReceiptNfe;
import com.softart.dfe.models.nf.substitute_cancel.NfceSubstituteCancel;
import com.softart.dfe.models.nf.substitute_cancel.ReturnNfceSubstituteCancel;
import com.softart.dfe.models.nf.substitute_cancel.SendNfceSubstituteCancel;
import com.softart.dfe.services.nf.authorization.NfceAuthorizationServiceImpl;
import com.softart.dfe.services.nf.cancel.NfceCancelServiceImpl;
import com.softart.dfe.services.nf.inutilization.NfceInutilizationServiceImpl;
import com.softart.dfe.services.nf.query_protocol.NfceQueryProtocolServiceImpl;
import com.softart.dfe.services.nf.query_status_service.NfceQueryStatusServiceImpl;
import com.softart.dfe.services.nf.return_authorization.NfceReturnAuthorizationServiceImpl;
import com.softart.dfe.services.nf.substitute_cancel.NfceSubstituteCancelServiceImpl;
import com.softart.dfe.util.RequireUtils;
import com.softart.dferestapi.models.nfe.event.CancelMultipleNfe;
import com.softart.dferestapi.models.nfe.event.CancelNfe;
import com.softart.dferestapi.models.nfe.event.SubstituteCancelMultipleNfce;
import com.softart.dferestapi.models.nfe.event.SubstituteCancelNfce;
import com.softart.dferestapi.models.nfe.inutilization.Inutilization;
import com.softart.dferestapi.services.config.DfeConfigurationService;
import lombok.Getter;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Getter
public final class NfceServiceImpl implements NfceService {

    private final DfeConfigurationService dfeConfigurationService;

    @Autowired
    public NfceServiceImpl(
            DfeConfigurationService dfeConfigurationService
    ) {
        this.dfeConfigurationService = dfeConfigurationService;
    }

    @Override
    public ReturnSendNf authorization(SendNf sendNf) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        NfceConfig config = getConfig();
        return new NfceAuthorizationServiceImpl(config).authorization(sendNf.getNFe());
    }

    @Override
    public ReturnNfeCancel cancel(CancelNfe o) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        NfceConfig config = getConfig();
        return new NfceCancelServiceImpl(config).cancel(o.getChNFe(), Optional.ofNullable(o.getNProt()).orElseGet(() -> getNProt(config, o.getChNFe())), o.getXJust());
    }

    @Override
    public ReturnNfeCancel cancel(CancelMultipleNfe cancelMultipleNfe) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        NfceConfig config = getConfig();

        return new NfceCancelServiceImpl(config).cancel(SendNfeCancel.build(cancelMultipleNfe
                .getData()
                .stream()
                .map(it -> NfeCancel.builder().infEvento(NfeCancel
                        .InfEvento
                        .builder()
                        .chNFe(it.getChNFe())
                        .nSeqEvento("1")
                        .cnpj(config.cnpj())
                        .cpf(config.cpf())
                        .cOrgao(config.uf().getCode())
                        .tpAmb(config.environment().getCode())
                        .detEvento(NfeCancel.InfEvento
                                .DetEvento
                                .builder()
                                .nProt(Optional.ofNullable(it.getNProt()).orElseGet(() -> getNProt(config, it.getChNFe())))
                                .xJust(it.getXJust())
                                .build())
                        .build()).build())
                .collect(Collectors.toList())));
    }

    @Override
    public ReturnNfceSubstituteCancel substituteCancel(SubstituteCancelNfce o) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        return new NfceSubstituteCancelServiceImpl(getConfig()).substituteCancelWithMessage(o.getChNFe(), o.getChNFeRef(), o.getXJust());
    }

    @Override
    public ReturnNfceSubstituteCancel substituteCancel(SubstituteCancelMultipleNfce o) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        NfceConfig config = getConfig();
        return new NfceSubstituteCancelServiceImpl(config).substituteCancel(SendNfceSubstituteCancel.build(o.getData().stream().map(it -> NfceSubstituteCancel.InfEvento.build(it.getChNFe(), it.getChNFeRef(), it.getNProt(), it.getXJust(), "1", config)).collect(Collectors.toList())));
    }

    @Override
    public ReturnQueryProtocolNfe queryProtocol(String accessKey, Environment environment) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        NfceConfig config = getConfig();
        return queryProtocol(config.withEnviroment(Optional.ofNullable(environment).orElseGet(config::environment)), accessKey);
    }

    private ReturnQueryProtocolNfe queryProtocol(NfceConfig config, String accessKey) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        return new NfceQueryProtocolServiceImpl(config).queryProtocol(accessKey);
    }

    @SneakyThrows
    private String getNProt(NfceConfig config, String chNFe) {
        return RequireUtils.nonNull(queryProtocol(config, chNFe).getProtNFe(), "cannot find protocol of nfce of " + chNFe).getInfProt().getNProt();
    }

    @Override
    public ReturnQueryReceiptNfe queryReceipt(String nRec, Environment environment) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        NfceConfig config = getConfig();
        return new NfceReturnAuthorizationServiceImpl(config.withEnviroment(Optional.ofNullable(environment).orElseGet(config::environment))).queryReceipt(nRec);
    }

    @Override
    public ReturnQueryStatusServiceNf queryStatusService(UF uf, Environment environment) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        NfceConfig config = getConfig();
        uf = Optional.ofNullable(uf).orElseGet(config::uf);
        environment = Optional.ofNullable(environment).orElseGet(config::environment);
        return new NfceQueryStatusServiceImpl(config).queryStatusService(uf, environment);
    }

    @Override
    public ReturnNfeInut inutilization(Inutilization o) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        return new NfceInutilizationServiceImpl(getConfig()).inutilization(o.getAno(), o.getSerie(), o.getNnfIni(), o.getNnfFin(), o.getXJust());
    }
}
