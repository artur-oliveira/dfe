package com.softart.dferestapi.services.cte;

import com.softart.dfe.enums.cte.CteEvent;
import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.interfaces.internal.config.CteConfig;
import com.softart.dfe.models.cte.distribution.CteReturnDistribution;
import com.softart.dfe.models.cte.event.CteCorrectionLetter;
import com.softart.dfe.models.cte.event.CteEpec;
import com.softart.dfe.models.cte.event.CteReturnEvent;
import com.softart.dfe.models.cte.inutilization.CteReturnInutilization;
import com.softart.dfe.models.cte.query_receipt.ReturnQueryReceipt;
import com.softart.dfe.models.cte.query_situation.CteReturnQuerySituation;
import com.softart.dfe.models.cte.reception.Cte;
import com.softart.dfe.models.cte.reception.CteReturnSend;
import com.softart.dfe.models.cte.reception.CteSend;
import com.softart.dfe.models.cte.reception_gtve.Gtve;
import com.softart.dfe.models.cte.reception_gtve.GtveReturn;
import com.softart.dfe.models.cte.reception_os.CteOs;
import com.softart.dfe.models.cte.reception_os.CteOsReturn;
import com.softart.dfe.models.cte.reception_sync.CteReturn;
import com.softart.dfe.models.cte.status_service.CteReturnStatusService;
import com.softart.dfe.services.cte.distribution.CteDistributionService;
import com.softart.dfe.services.cte.distribution.CteDistributionServiceImpl;
import com.softart.dfe.services.cte.event.CteEventServiceImpl;
import com.softart.dfe.services.cte.inutilization.CteInutilizationServiceImpl;
import com.softart.dfe.services.cte.query_receipt.CteQueryReceiptServiceImpl;
import com.softart.dfe.services.cte.query_situation.CteQuerySituationServiceImpl;
import com.softart.dfe.services.cte.reception.CteReceptionServiceImpl;
import com.softart.dfe.services.cte.reception_gtve.GtveReceptionServiceImpl;
import com.softart.dfe.services.cte.reception_os.CteOsReceptionServiceImpl;
import com.softart.dfe.services.cte.reception_sync.CteReceptionSyncServiceImpl;
import com.softart.dfe.services.cte.status_service.CteStatusServiceServiceImpl;
import com.softart.dfe.util.RequireUtils;
import com.softart.dferestapi.exceptions.DfeRestApiException;
import com.softart.dferestapi.models.cte.event.*;
import com.softart.dferestapi.models.cte.inutilization.Inutilization;
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
public final class CteServiceImpl implements CteService {

    private final DfeConfigurationService dfeConfigurationService;

    @Autowired
    public CteServiceImpl(
            DfeConfigurationService dfeConfigurationService
    ) {
        this.dfeConfigurationService = dfeConfigurationService;
    }

    @Override
    public CteReturnStatusService statusService(UF uf, Environment environment) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        CteConfig config = getConfig();
        uf = Optional.ofNullable(uf).orElseGet(config::uf);
        environment = Optional.ofNullable(environment).orElseGet(config::environment);
        return new CteStatusServiceServiceImpl(config).statusService(uf, environment);
    }

    @Override
    public CteReturnQuerySituation querySituation(String chCTe, Environment environment) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        CteConfig config = getConfig();
        environment = Optional.ofNullable(environment).orElseGet(config::environment);
        return querySituation(getConfig().withEnviroment(environment), chCTe);
    }

    @Override
    public ReturnQueryReceipt queryReceipt(String nRec, Environment environment) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        CteConfig config = getConfig();
        environment = Optional.ofNullable(environment).orElseGet(config::environment);
        return new CteQueryReceiptServiceImpl(config).queryReceipt(nRec, environment);
    }

    @Override
    public CteReturnSend reception(CteSend cteSend) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        return new CteReceptionServiceImpl(getConfig()).reception(cteSend);
    }

    @Override
    public CteReturn receptionSync(Cte o) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        return new CteReceptionSyncServiceImpl(getConfig()).receptionSync(o);
    }

    @Override
    public CteOsReturn receptionOs(CteOs o) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        return new CteOsReceptionServiceImpl(getConfig()).receptionOs(o);
    }

    @Override
    public GtveReturn receptionGtve(Gtve o) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        return new GtveReceptionServiceImpl(getConfig()).receptionGtve(o);
    }

    @Override
    public CteReturnEvent cancel(CancelCte o) throws ProcessException, SoapServiceGeneralException, ValidationException, NoProviderFound, SecurityException {
        CteConfig config = getConfig();
        return new CteEventServiceImpl(config).cancel(o.getChCTe(), Optional.ofNullable(o.getNProt()).orElseGet(() -> getNProt(config, o.getChCTe())), o.getXJust());
    }

    @Override
    public CteReturnInutilization inutilization(Inutilization o) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        CteConfig config = getConfig();
        return new CteInutilizationServiceImpl(config).inutilizar(o.getModel(), o.getAno(), o.getSerie(), o.getNctIni(), o.getNctFin(), o.getXJust(), Optional.ofNullable(o.getTpAmb()).orElseGet(config::environment));
    }

    @Override
    public CteReturnEvent correctionLetter(CorrectionLetterCte o) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        CteConfig config = getConfig();
        return new CteEventServiceImpl(config).correctionLetter(o.getChCTe(), o.getInfCorrecao().stream().map(it -> CteCorrectionLetter.InfEvento.DetEvento.EvCCeCTe.InfCorrecao.builder().grupoAlterado(it.getGrupoAlterado()).campoAlterado(it.getCampoAlterado()).valorAlterado(it.getValorAlterado()).nroItemAlterado(it.getNroItemAlterado()).build()).collect(Collectors.toList()), Optional.ofNullable(o.getNSeqEvento()).orElseGet(() -> getLastSequenceNumber(config, o.getChCTe(), CteEvent.CORRECTION_LETTER)));
    }

    @Override
    public CteReturnEvent deliveryReceipt(DeliveryReceiptCte o) throws ProcessException, SoapServiceGeneralException, ValidationException, NoProviderFound, SecurityException {
        CteConfig config = getConfig();
        return new CteEventServiceImpl(config).deliveryReceipt(
                o.getChCTe(),
                Optional.ofNullable(o.getNProt()).orElseGet(() -> getNProt(config, o.getChCTe())),
                Optional.ofNullable(o.getNSeqEvento()).orElseGet(() -> getLastSequenceNumber(config, o.getChCTe(), CteEvent.DELIVERY_RECEIPT)),
                o.getImage(),
                o.getNDoc(),
                o.getXNome(),
                o.getLatitude(),
                o.getLongitude(),
                o.getNfes()
        );
    }

    @Override
    public CteReturnEvent cancelDeliveryReceipt(CancelDeliveryReceiptCte o) throws ProcessException, SoapServiceGeneralException, ValidationException, NoProviderFound, SecurityException {
        CteConfig config = getConfig();
        return new CteEventServiceImpl(config).cancelDeliveryReceipt(
                o.getChCTe(),
                Optional.ofNullable(o.getNProt()).orElseGet(() -> getNProt(config, o.getChCTe())),
                Optional.ofNullable(o.getNSeqEvento()).orElseGet(() -> getLastSequenceNumber(config, o.getChCTe(), CteEvent.CANCEL_DELIVERY_RECEIPT)),
                Optional.ofNullable(o.getNProtCE()).orElseGet(() -> getNProtEvent(config, o.getChCTe(), CteEvent.DELIVERY_RECEIPT))
        );
    }

    @Override
    public CteReturnDistribution distribution(Long ultNSU, Long nsu, Environment environment) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        CteConfig config = getConfig();
        environment = Optional.ofNullable(environment).orElseGet(config::environment);
        CteDistributionService service = new CteDistributionServiceImpl(config.withEnviroment(Optional.ofNullable(environment).orElseGet(config::environment)));
        if (Objects.nonNull(nsu)) {
            return service.distributionUniqueNsu(nsu);
        } else if (Objects.nonNull(ultNSU)) {
            return service.distributionUltNsu(ultNSU);
        }
        return service.distributionUltNsu(0L);
    }

    @Override
    public CteReturnEvent epec(EpecCte o) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        CteConfig config = getConfig();
        return new CteEventServiceImpl(config).epec(
                o.getChCTe(),
                CteEpec.InfEvento.DetEvento
                        .EvEPECCTe
                        .builder()
                        .xJust(o.getXJust())
                        .vCarga(o.getVCarga())
                        .vtPrest(o.getVtPrest())
                        .modal(o.getModal())
                        .ufIni(o.getUfIni())
                        .vicms(o.getVicms())
                        .vicmsst(o.getVicmsst())
                        .toma4(Optional.ofNullable(o.getToma4())
                                .map(it -> CteEpec.InfEvento.DetEvento.EvEPECCTe.Toma4.builder()
                                        .toma(it.getToma())
                                        .uf(it.getUf())
                                        .cnpj(it.getCnpj())
                                        .cpf(it.getCpf())
                                        .ie(it.getIe())
                                        .build())
                                .orElse(null))
                        .ufFim(o.getUfFim())
                        .tpCTe(o.getTpCTe())
                        .dhEmi(o.getDhEmi())
                        .build()
        );
    }

    @Override
    public CteReturnEvent gtv(GtvCte o) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        CteConfig config = getConfig();
        return new CteEventServiceImpl(config).gtv(
                o.getChCTe(),
                Optional.ofNullable(o.getNSeqEvento()).orElseGet(() -> getLastSequenceNumber(config, o.getChCTe(), CteEvent.INFO_GTV)),
                o.getInfGTV()
        );
    }

    @Override
    public CteReturnEvent multimodal(MultimodalCte o) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        CteConfig config = getConfig();
        return new CteEventServiceImpl(config).multimodal(
                o.getChCTe(),
                Optional.ofNullable(o.getNSeqEvento()).orElseGet(() -> getLastSequenceNumber(config, o.getChCTe(), CteEvent.MULTIMODAL)),
                o.getXRegistro(),
                o.getNDoc()
        );
    }

    @Override
    public CteReturnEvent provisionDisagreement(ProvisionDisagreementCte o) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        return new CteEventServiceImpl(getConfig()).provisionDisagreement(o.getChCTe(), o.getXObs());
    }

    @SneakyThrows
    private String getNProt(CteConfig config, String chCTe) {
        return RequireUtils.nonNull(querySituation(config, chCTe).getProtCTe(), "cannot find protocol of cte of " + chCTe).getInfProt().getNProt();
    }


    @SneakyThrows
    private String getNProtEvent(CteConfig config, String chCTe, CteEvent event) {
        return RequireUtils.nonNull(querySituation(config, chCTe), "cannot find protocol of cte of " + chCTe).getProcEventoCTe().stream().filter(it -> it.getRetEvento().getInfEvento().getTpEvento().equals(event.getCode())).findFirst().orElseThrow(() -> new DfeRestApiException("no event protocol found for cte of accessKey " + chCTe + " of event " + event.getCode())).getRetEvento().getInfEvento().getNProt();
    }


    @SneakyThrows
    private String getLastSequenceNumber(CteConfig config, String chCTe, CteEvent event) {
        return RequireUtils.nonNull(querySituation(config, chCTe).getLastSequenceNumberAsString(event.getCode()), "cannot find last sequence number of cte of " + chCTe);
    }

    private CteReturnQuerySituation querySituation(CteConfig config, String chCTe) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        return new CteQuerySituationServiceImpl(config).querySituation(chCTe, config.environment());
    }
}