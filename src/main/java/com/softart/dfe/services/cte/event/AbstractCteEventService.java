package com.softart.dfe.services.cte.event;

import br.inf.portalfiscal.cte.send.TEvento;
import com.softart.dfe.enums.cte.CteEvent;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.models.cte.event.CteCorrectionLetter;
import com.softart.dfe.models.cte.event.CteEventRequest;
import com.softart.dfe.models.cte.event.CteGtv;
import com.softart.dfe.models.cte.event.CteReturnEvent;
import com.softart.dfe.models.cte.query_situation.CteReturnQuerySituation;
import com.softart.dfe.services.cte.query_situation.CteQuerySituationService;
import com.softart.dfe.util.RequireUtils;

import java.util.Collection;
import java.util.List;

public abstract class AbstractCteEventService implements CteEventService {
    @Override
    public CteReturnEvent event(TEvento evento) throws SoapServiceGeneralException, NoProviderFound, ProcessException, ValidationException, SecurityException {
        return CteReturnEvent.builder().build().fromObject(getProviderFactory().getCteService(getConfig())
                .event(CteEventRequest.builder()
                        .data(evento)
                        .validators(getValidatorFactory().cteValidator().eventValidators())
                        .signer(getXmlSigner())
                        .config(getConfig())
                        .configureProvider(getConfigureProviderFactory())
                        .beforeRequest(getProcess().beforeEvent())
                        .afterRequest(getProcess().afterEvent())
                        .build()));
    }

    @Override
    public CteReturnEvent cancel(String accessKey) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return cancel(accessKey, RequireUtils.nonNull(getCteQuerySituationService().querySituation(accessKey).getProtCTe(), "protocol must be not null to cancel cfe " + accessKey).protocol());
    }

    @Override
    public CteReturnEvent correctionLetter(String accessKey, List<CteCorrectionLetter.InfEvento.DetEvento.EvCCeCTe.InfCorrecao> corrections) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return correctionLetter(accessKey, corrections, String.valueOf(getCteQuerySituationService().getLastSequenceNumber(accessKey, CteEvent.CORRECTION_LETTER)));
    }

    @Override
    public CteReturnEvent deliveryReceipt(String accessKey, String base64Image, String document, String name, String lat, String lon, Collection<String> deliveryAcessKey) throws ProcessException, SoapServiceGeneralException, ValidationException, NoProviderFound, SecurityException {
        CteReturnQuerySituation querySituation = getCteQuerySituationService().querySituation(accessKey);
        return deliveryReceipt(accessKey, querySituation.getProtCTe().protocol(), base64Image, querySituation.getLastSequenceNumberAsString(CteEvent.DELIVERY_RECEIPT.getCode()), document, name, lat, lon, deliveryAcessKey);
    }

    @Override
    public CteReturnEvent cancelDeliveryReceipt(String accessKey, String protocolDelivery) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        CteReturnQuerySituation querySituation = getCteQuerySituationService().querySituation(accessKey);
        return cancelDeliveryReceipt(accessKey, querySituation.getProtCTe().protocol(), querySituation.getLastSequenceNumberAsString(CteEvent.CANCEL_DELIVERY_RECEIPT.getCode()), protocolDelivery);
    }

    @Override
    public CteReturnEvent gtv(String accessKey, List<CteGtv.InfEvento.DetEvento.EvGTV.InfGTV> infGTV) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        CteReturnQuerySituation querySituation = getCteQuerySituationService().querySituation(accessKey);
        return gtv(accessKey, querySituation.getLastSequenceNumberAsString(CteEvent.INFO_GTV.getCode()), infGTV);
    }

    @Override
    public CteReturnEvent provisionDisagreement(String accessKey, String observation) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        CteReturnQuerySituation querySituation = getCteQuerySituationService().querySituation(accessKey);
        return provisionDisagreement(accessKey, querySituation.getLastSequenceNumberAsString(CteEvent.PROVISION_IN_DISAGREEMENT.getCode()), observation);
    }

    @Override
    public CteReturnEvent multimodal(String accessKey, String register, String document) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        CteReturnQuerySituation querySituation = getCteQuerySituationService().querySituation(accessKey);
        return multimodal(accessKey, querySituation.getLastSequenceNumberAsString(CteEvent.MULTIMODAL.getCode()), register, document);
    }

    public abstract CteQuerySituationService getCteQuerySituationService();
}
