package com.softart.dferestapi.services.nfe;


import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.interfaces.internal.config.NfeConfig;
import com.softart.dfe.models.nf.authorization.ReturnSendNf;
import com.softart.dfe.models.nf.authorization.SendNf;
import com.softart.dfe.models.nf.cancel.NfeCancel;
import com.softart.dfe.models.nf.cancel.ReturnNfeCancel;
import com.softart.dfe.models.nf.cancel.SendNfeCancel;
import com.softart.dfe.models.nf.correction_letter.NfeCorrectionLetter;
import com.softart.dfe.models.nf.correction_letter.ReturnNfeCorrectionLetter;
import com.softart.dfe.models.nf.correction_letter.SendNfeCorrectionLetter;
import com.softart.dfe.models.nf.distribution.NfeReturnDistribution;
import com.softart.dfe.models.nf.epec.NfeEpec;
import com.softart.dfe.models.nf.epec.ReturnNfeEpec;
import com.softart.dfe.models.nf.epec.SendNfeEpec;
import com.softart.dfe.models.nf.interested_actor.NfeInterestedActor;
import com.softart.dfe.models.nf.interested_actor.ReturnNfeInterestedActor;
import com.softart.dfe.models.nf.interested_actor.SendNfeInterestedActor;
import com.softart.dfe.models.nf.inut.ReturnNfeInut;
import com.softart.dfe.models.nf.manifestation.NfeManifestation;
import com.softart.dfe.models.nf.manifestation.NfeReturnManifestation;
import com.softart.dfe.models.nf.manifestation.NfeSendManifestation;
import com.softart.dfe.models.nf.query_protocol.ReturnQueryProtocolNfe;
import com.softart.dfe.models.nf.query_register.ReturnQueryRegister;
import com.softart.dfe.models.nf.query_status_service.ReturnQueryStatusServiceNf;
import com.softart.dfe.models.nf.return_authorization.ReturnQueryReceiptNfe;
import com.softart.dfe.services.nf.authorization.NfeAuthorizationServiceImpl;
import com.softart.dfe.services.nf.cancel.NfeCancelServiceImpl;
import com.softart.dfe.services.nf.correction_letter.NfeCorrectionLetterServiceImpl;
import com.softart.dfe.services.nf.distribution.NfeDistributionService;
import com.softart.dfe.services.nf.distribution.NfeDistributionServiceImpl;
import com.softart.dfe.services.nf.epec.NfeEpecServiceImpl;
import com.softart.dfe.services.nf.interested_actor.NfeInterestedActorServiceImpl;
import com.softart.dfe.services.nf.inutilization.NfeInutilizationServiceImpl;
import com.softart.dfe.services.nf.manifestation.NfeManifestationServiceImpl;
import com.softart.dfe.services.nf.query_protocol.NfeQueryProtocolServiceImpl;
import com.softart.dfe.services.nf.query_register.NfeQueryRegisterService;
import com.softart.dfe.services.nf.query_register.NfeQueryRegisterServiceImpl;
import com.softart.dfe.services.nf.query_status_service.NfeQueryStatusServiceImpl;
import com.softart.dfe.services.nf.return_authorization.NfeReturnAuthorizationServiceImpl;
import com.softart.dfe.util.DateUtils;
import com.softart.dfe.util.DecimalUtils;
import com.softart.dfe.util.RequireUtils;
import com.softart.dferestapi.exceptions.DfeRestApiException;
import com.softart.dferestapi.models.nfe.event.*;
import com.softart.dferestapi.models.nfe.inutilization.Inutilization;
import com.softart.dferestapi.services.config.DfeConfigurationService;
import lombok.Getter;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Getter
public final class NfeServiceImpl implements NfeService {

    private final DfeConfigurationService dfeConfigurationService;

    @Autowired
    public NfeServiceImpl(
            DfeConfigurationService dfeConfigurationService
    ) {
        this.dfeConfigurationService = dfeConfigurationService;
    }

    @Override
    public ReturnSendNf authorization(SendNf sendNf) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        NfeConfig config = getConfig();
        return new NfeAuthorizationServiceImpl(config).authorization(sendNf.getNFe());
    }

    @Override
    public ReturnNfeCancel cancel(CancelNfe o) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        NfeConfig config = getConfig();
        return new NfeCancelServiceImpl(config).cancel(o.getChNFe(), Optional.ofNullable(o.getNProt()).orElseGet(() -> getNProt(config, o.getChNFe())), o.getXJust());
    }

    @Override
    public ReturnNfeCancel cancel(CancelMultipleNfe cancelMultipleNfe) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        NfeConfig config = getConfig();
        return new NfeCancelServiceImpl(config).cancel(SendNfeCancel.build(cancelMultipleNfe
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
    public ReturnNfeCorrectionLetter correctionLetter(CorrectionNfe correctionNfe) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        NfeConfig config = getConfig();
        return new NfeCorrectionLetterServiceImpl(config).correctionLetter(correctionNfe.getChNFe(), correctionNfe.getXCorrecao(), correctionNfe.getNSeqEvento());
    }

    @Override
    public ReturnNfeCorrectionLetter correctionLetter(CorrectionMultipleNfe correctionMultipleNfe) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        NfeConfig config = getConfig();
        return new NfeCorrectionLetterServiceImpl(config).correctionLetter(SendNfeCorrectionLetter.correctionLetter(
                correctionMultipleNfe.getData().stream().map(it -> NfeCorrectionLetter.builder().infEvento(NfeCorrectionLetter
                                        .InfEvento.builder()
                                        .chNFe(it.getChNFe())
                                        .nSeqEvento(it.getNSeqEvento())
                                        .cnpj(config.cnpj())
                                        .cpf(config.cpf())
                                        .cOrgao(config.uf().getCode())
                                        .tpAmb(config.environment().getCode())
                                        .detEvento(NfeCorrectionLetter.InfEvento.DetEvento
                                                .builder()
                                                .xCorrecao(it.getXCorrecao())
                                                .build())
                                        .build())
                                .build())
                        .collect(Collectors.toList())
        ));
    }

    @Override
    public NfeReturnManifestation manifestation(ManifestNfe manifestNfe) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        NfeConfig config = getConfig();
        return new NfeManifestationServiceImpl(config).manifestation(NfeSendManifestation.build(NfeManifestation
                .builder()
                .infEvento(NfeManifestation.InfEvento
                        .builder()
                        .tpEvento(manifestNfe.getTpEvento().getCode())
                        .cOrgao(UF.RFB.getCode())
                        .tpAmb(config.environment().getCode())
                        .cnpj(config.cnpj())
                        .cpf(config.cpf())
                        .chNFe(manifestNfe.getChNFe())
                        .nSeqEvento(manifestNfe.getNSeqEvento())
                        .detEvento(NfeManifestation.InfEvento.DetEvento.builder().descEvento(manifestNfe.getTpEvento().getDescription()).build())
                        .build())
                .build()));
    }

    @Override
    public NfeReturnManifestation manifestation(ManifestMultipleNfe manifestMultipleNfe) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        NfeConfig config = getConfig();
        return new NfeManifestationServiceImpl(config).manifestation(
                NfeSendManifestation.build(
                        manifestMultipleNfe.getData().stream().map(it ->
                                        NfeManifestation
                                                .builder()
                                                .infEvento(NfeManifestation.InfEvento
                                                        .builder()
                                                        .tpEvento(it.getTpEvento().getCode())
                                                        .cOrgao(UF.RFB.getCode())
                                                        .tpAmb(config.environment().getCode())
                                                        .cnpj(config.cnpj())
                                                        .cpf(config.cpf())
                                                        .chNFe(it.getChNFe())
                                                        .nSeqEvento(it.getNSeqEvento())
                                                        .detEvento(NfeManifestation.InfEvento.DetEvento.builder().descEvento(it.getTpEvento().getDescription()).build())
                                                        .build())
                                                .build())
                                .collect(Collectors.toList())
                )
        );
    }

    /**
     * A function that sends the Epec Nfe to the Sefaz.
     *
     * @param o EpecNfe object
     * @return ReturnNfeEpec
     */
    @Override
    public ReturnNfeEpec epec(EpecNfe o) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        NfeConfig config = getConfig();
        return new NfeEpecServiceImpl(config).epec(SendNfeEpec.build(
                o.getChNFe(),
                DateUtils.format(DateUtils.localDateTime(o.getDhEmi())),
                o.getTpNF(),
                o.getIe(),
                o.getUf(),
                o.getCnpj(),
                o.getCpf(),
                o.getIdEstrangeiro(),
                o.getIeDest(),
                DecimalUtils.format(o.getVnf(), 2),
                DecimalUtils.format(o.getVicms(), 2),
                DecimalUtils.format(o.getVst(), 2),
                config
        ));
    }

    /**
     * A function that receives a list of objects and returns a list of objects.
     *
     * @param o EpecMultipleNfe
     * @return A ReturnNfeEpec object, which contains the response from the SEFAZ.
     */
    @Override
    public ReturnNfeEpec epec(EpecMultipleNfe o) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        NfeConfig config = getConfig();
        return new NfeEpecServiceImpl(config).epec(SendNfeEpec
                .build(o
                        .getData()
                        .stream().map(it -> NfeEpec
                                .builder()
                                .infEvento(SendNfeEpec.infEvento(it.getChNFe(), SendNfeEpec.detEvento(
                                        DateUtils.format(DateUtils.localDateTime(it.getDhEmi())),
                                        it.getTpNF(),
                                        it.getIe(),
                                        it.getUf(),
                                        it.getCnpj(),
                                        it.getCpf(),
                                        it.getIdEstrangeiro(),
                                        it.getIeDest(),
                                        DecimalUtils.format(it.getVnf(), 2),
                                        DecimalUtils.format(it.getVicms(), 2),
                                        DecimalUtils.format(it.getVst(), 2),
                                        config), config))
                                .build())
                        .collect(Collectors.toList()))
        );
    }

    @Override
    public ReturnNfeInterestedActor interestedActor(InterestedActorNfe o) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        NfeConfig config = getConfig();
        return new NfeInterestedActorServiceImpl(config).interestedActor(
                SendNfeInterestedActor.interestedActor(o.getChNFe(), o.getCpf(), o.getCnpj(), o.getNseq(), o.getTpAutorizacao(), config)
        );
    }

    @Override
    public ReturnNfeInterestedActor interestedActor(InterestedActorMultipleNfe o) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        NfeConfig config = getConfig();
        return new NfeInterestedActorServiceImpl(config).interestedActor(
                SendNfeInterestedActor.build(o.getData().stream().map(it -> NfeInterestedActor.build(it.getChNFe(), it.getCpf(), it.getCnpj(), it.getNseq(), it.getTpAutorizacao(), config)).collect(Collectors.toList()))
        );
    }

    @Override
    public NfeReturnDistribution distribution(Long ultNSU, Long nsu, String chNFe, Environment environment) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        NfeConfig config = getConfig();
        NfeDistributionService service = new NfeDistributionServiceImpl(config.withEnviroment(Optional.ofNullable(environment).orElseGet(config::environment)));
        if (Objects.nonNull(chNFe)) {
            return service.distributionAccessKey(chNFe);
        } else if (Objects.nonNull(nsu)) {
            return service.distributionUniqueNsu(nsu);
        } else if (Objects.nonNull(ultNSU)) {
            return service.distributionUltNsu(ultNSU);
        }

        return service.distributionUltNsu(0L);
    }

    @Override
    public ReturnQueryRegister queryRegister(String cnpj, String cpf, String ie, UF uf, Environment environment) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        NfeConfig config = getConfig();
        NfeQueryRegisterService queryRegisterService = new NfeQueryRegisterServiceImpl(config.withEnviroment(Optional.ofNullable(environment).orElseGet(config::environment)));
        if (Objects.nonNull(cnpj)) {
            return queryRegisterService.queryRegister(cnpj, uf);
        } else if (Objects.nonNull(cpf)) {
            return queryRegisterService.queryRegisterCpf(cpf, uf);
        } else if (Objects.nonNull(ie)) {
            return queryRegisterService.queryRegisterIe(ie, uf);
        }
        throw new DfeRestApiException("cnpj, cpf or ie must be provided");
    }

    @Override
    public ReturnQueryProtocolNfe queryProtocol(String accessKey, Environment environment) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        NfeConfig config = getConfig();
        return queryProtocol(config.withEnviroment(Optional.ofNullable(environment).orElseGet(config::environment)), accessKey);
    }

    private ReturnQueryProtocolNfe queryProtocol(NfeConfig config, String accessKey) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        return new NfeQueryProtocolServiceImpl(config).queryProtocol(accessKey, config.environment());
    }

    @SneakyThrows
    private String getNProt(NfeConfig config, String chNFe) {
        return RequireUtils.nonNull(queryProtocol(config, chNFe).getProtNFe(), "cannot find protocol of nfe of " + chNFe).getInfProt().getNProt();
    }

    @Override
    public ReturnQueryReceiptNfe queryReceipt(String nrec, Environment environment) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        NfeConfig config = getConfig();
        return new NfeReturnAuthorizationServiceImpl(config.withEnviroment(Optional.ofNullable(environment).orElseGet(config::environment))).queryReceipt(nrec);
    }

    @Override
    public ReturnQueryStatusServiceNf queryStatusService(UF uf, Environment environment) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        NfeConfig config = getConfig();
        uf = Optional.ofNullable(uf).orElseGet(config::uf);
        environment = Optional.ofNullable(environment).orElseGet(config::environment);
        return new NfeQueryStatusServiceImpl(config).queryStatusService(uf, environment);
    }

    @Override
    public ReturnNfeInut inutilization(Inutilization o) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        NfeConfig config = getConfig();
        return new NfeInutilizationServiceImpl(config).inutilization(o.getAno(), o.getSerie(), o.getNnfIni(), o.getNnfFin(), o.getXJust(), Optional.ofNullable(o.getTpAmb()).orElseGet(config::environment));
    }
}
