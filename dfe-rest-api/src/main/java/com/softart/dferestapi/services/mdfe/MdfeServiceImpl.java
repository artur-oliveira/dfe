package com.softart.dferestapi.services.mdfe;

import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.enums.mdfe.MdfeEvent;
import com.softart.dfe.enums.mdfe.distribution.MdfeDfeCompression;
import com.softart.dfe.enums.mdfe.distribution.MdfeDfeSolicitation;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.interfaces.internal.config.MdfeConfig;
import com.softart.dfe.models.mdfe.distribution.MdfeReturnDistribution;
import com.softart.dfe.models.mdfe.event.MdfeDfeInclusion;
import com.softart.dfe.models.mdfe.event.MdfeReturnEvent;
import com.softart.dfe.models.mdfe.query_receipt.MdfeReturnQueryReceipt;
import com.softart.dfe.models.mdfe.query_situation.MdfeReturnQuerySituation;
import com.softart.dfe.models.mdfe.query_unclosed.MdfeReturnQueryUnclosed;
import com.softart.dfe.models.mdfe.reception.SendMdfe;
import com.softart.dfe.models.mdfe.reception.SendMdfeReturn;
import com.softart.dfe.models.mdfe.reception_sync.Mdfe;
import com.softart.dfe.models.mdfe.reception_sync.MdfeReturn;
import com.softart.dfe.models.mdfe.status_service.MdfeReturnStatusService;
import com.softart.dfe.services.mdfe.distribution.MdfeDistributionServiceImpl;
import com.softart.dfe.services.mdfe.event.MdfeEventServiceImpl;
import com.softart.dfe.services.mdfe.query_receipt.MdfeQueryReceiptServiceImpl;
import com.softart.dfe.services.mdfe.query_situation.MdfeQuerySituationServiceImpl;
import com.softart.dfe.services.mdfe.query_unclosed.MdfeQueryUnclosedServiceImpl;
import com.softart.dfe.services.mdfe.reception.MdfeReceptionServiceImpl;
import com.softart.dfe.services.mdfe.reception_sync.MdfeReceptionSyncServiceImpl;
import com.softart.dfe.services.mdfe.status_service.MdfeStatusServiceServiceImpl;
import com.softart.dfe.util.RequireUtils;
import com.softart.dferestapi.exceptions.DfeRestApiException;
import com.softart.dferestapi.models.mdfe.event.*;
import com.softart.dferestapi.services.config.DfeConfigurationService;
import lombok.Getter;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@Getter
public final class MdfeServiceImpl implements MdfeService {

    private final DfeConfigurationService dfeConfigurationService;

    @Autowired
    public MdfeServiceImpl(
            DfeConfigurationService dfeConfigurationService
    ) {
        this.dfeConfigurationService = dfeConfigurationService;
    }

    @Override
    public MdfeReturnStatusService statusService(UF uf, Environment environment) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        MdfeConfig config = getConfig();
        uf = Optional.ofNullable(uf).orElseGet(config::uf);
        environment = Optional.ofNullable(environment).orElseGet(config::environment);
        return new MdfeStatusServiceServiceImpl(config).statusService(uf, environment);
    }

    @Override
    public MdfeReturnQueryUnclosed unclosed(Environment environment) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        MdfeConfig config = getConfig();
        environment = Optional.ofNullable(environment).orElseGet(config::environment);
        return new MdfeQueryUnclosedServiceImpl(config).queryUnclosed(environment);
    }

    @Override
    public MdfeReturnQuerySituation querySituation(String chMDFe, Environment environment) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        MdfeConfig config = getConfig();
        return querySituation(config.withEnviroment(Optional.ofNullable(environment).orElseGet(config::environment)), chMDFe);
    }

    @Override
    public MdfeReturnQueryReceipt queryReceipt(String nRec, Environment environment) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        MdfeConfig config = getConfig();
        environment = Optional.ofNullable(environment).orElseGet(config::environment);
        return new MdfeQueryReceiptServiceImpl(config).queryReceipt(nRec, environment);
    }

    @Override
    public SendMdfeReturn reception(SendMdfe sendMdfe) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        return new MdfeReceptionServiceImpl(getConfig()).reception(sendMdfe);
    }

    @Override
    public MdfeReturn receptionSync(Mdfe o) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        return new MdfeReceptionSyncServiceImpl(getConfig()).receptionSync(o);
    }

    @Override
    public MdfeReturnDistribution distribution(Long ultNSU, MdfeDfeSolicitation solicitation, MdfeDfeCompression compression, Environment environment) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        MdfeConfig config = getConfig();
        config = config.withEnviroment(Optional.ofNullable(environment).orElseGet(config::environment));
        return new MdfeDistributionServiceImpl(config).distribution(
                Optional.ofNullable(ultNSU).orElse(0L),
                Optional.ofNullable(solicitation).orElse(MdfeDfeSolicitation.CODE_9),
                Optional.ofNullable(compression).orElse(MdfeDfeCompression.NO),
                Optional.ofNullable(environment).orElseGet(config::environment)
        );
    }

    @Override
    public MdfeReturnEvent cancel(CancelMdfe o) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        MdfeConfig config = getConfig();
        return new MdfeEventServiceImpl(config).cancel(
                o.getChMDFe(),
                Optional.ofNullable(o.getNProt()).orElseGet(() -> getNProt(config, o.getChMDFe())),
                o.getXJust()
        );
    }

    @Override
    public MdfeReturnEvent close(CloseMdfe o) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        MdfeConfig config = getConfig();
        return new MdfeEventServiceImpl(config).close(
                o.getChMDFe(),
                Optional.ofNullable(o.getNProt()).orElseGet(() -> getNProt(config, o.getChMDFe())),
                o.getCUf().getCode(),
                o.getCMun()
        );
    }

    @Override
    public MdfeReturnEvent dfeInclusion(DfeInclusionMdfe o) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        MdfeConfig config = getConfig();
        return new MdfeEventServiceImpl(config).dfeInclusion(
                MdfeDfeInclusion.build(
                        o.getChMDFe(),
                        Optional.ofNullable(o.getNProt()).orElseGet(() -> getNProt(config, o.getChMDFe())),
                        o.getCMunCarrega(),
                        o.getXMunCarrega(),
                        o.getInfDoc(),
                        Optional.ofNullable(o.getNSeqEvento()).orElseGet(() -> getLastSequenceNumber(config, o.getChMDFe(), MdfeEvent.DFE_INCLUSION)),
                        config
                )
        );
    }

    @Override
    public MdfeReturnEvent driverInclusion(DriverInclusionMdfe o) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        MdfeConfig config = getConfig();
        return new MdfeEventServiceImpl(config).driverInclusion(
                o.getChMDFe(),
                o.getXNome(),
                o.getCpf(),
                Optional.ofNullable(o.getNSeqEvento()).orElseGet(() -> getLastSequenceNumber(config, o.getChMDFe(), MdfeEvent.DRIVER_INCLUSION))
        );
    }

    @Override
    public MdfeReturnEvent paymentModification(PaymentModificationMdfe o) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        MdfeConfig config = getConfig();
        return new MdfeEventServiceImpl(config).paymentModification(
                o.getChMDFe(),
                Optional.ofNullable(o.getNProt()).orElseGet(() -> getNProt(config, o.getChMDFe())),
                o.getInfPag(),
                Optional.ofNullable(o.getNSeqEvento()).orElseGet(() -> getLastSequenceNumber(config, o.getChMDFe(), MdfeEvent.PAYMENT_MODIFICATION))
        );
    }

    @Override
    public MdfeReturnEvent paymentOperation(PaymentOperationMdfe o) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        MdfeConfig config = getConfig();
        return new MdfeEventServiceImpl(config).paymentOperation(
                o.getChMDFe(),
                Optional.ofNullable(o.getNProt()).orElseGet(() -> getNProt(config, o.getChMDFe())),
                o.getInfViagens(),
                o.getInfPag(),
                Optional.ofNullable(o.getNSeqEvento()).orElseGet(() -> getLastSequenceNumber(config, o.getChMDFe(), MdfeEvent.PAYMENT_OPERATION))
        );
    }

    @Override
    public MdfeReturnEvent transportConfirmation(TransportConfirmationMdfe o) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        MdfeConfig config = getConfig();
        return new MdfeEventServiceImpl(config).transportConfirmation(
                o.getChMDFe(),
                Optional.ofNullable(o.getNProt()).orElseGet(() -> getNProt(config, o.getChMDFe()))
        );
    }

    @SneakyThrows
    private String getNProt(MdfeConfig config, String chMDFe) {
        return RequireUtils.nonNull(querySituation(config, chMDFe).getProtMDFe(), "cannot find protocol of mdfe of " + chMDFe).getProt().getInfProt().getNProt();
    }


    @SneakyThrows
    private String getNProtEvent(MdfeConfig config, String chMDFe, MdfeEvent event) {
        return RequireUtils.nonNull(querySituation(config, chMDFe), "cannot find protocol of mdfe of " + chMDFe).getProcEventoMDFe().stream().filter(it -> it.getRetEvento().getInfEvento().getTpEvento().equals(event.getCode())).findFirst().orElseThrow(() -> new DfeRestApiException("no event protocol found for mdfe of accessKey " + chMDFe + " of event " + event.getCode())).getRetEvento().getInfEvento().getNProt();
    }


    @SneakyThrows
    private String getLastSequenceNumber(MdfeConfig config, String chMDFe, MdfeEvent event) {
        return RequireUtils.nonNull(querySituation(config, chMDFe).getLastSequenceNumberAsString(event.getCode()), "cannot find last sequence number of mdfe of " + chMDFe);
    }

    private MdfeReturnQuerySituation querySituation(MdfeConfig config, String chMDFe) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        return new MdfeQuerySituationServiceImpl(config).querySituation(chMDFe, config.environment());
    }

}