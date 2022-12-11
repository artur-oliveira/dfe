package com.softart.dfe.services.cte.event;

import br.inf.portalfiscal.cte.send.TEvento;
import com.softart.dfe.components.internal.parser.AccessKeyParserFactory;
import com.softart.dfe.enums.cte.CteEvent;
import com.softart.dfe.enums.nf.NFEvent;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.interfaces.services.CteSefazService;
import com.softart.dfe.models.cte.event.*;
import com.softart.dfe.models.cte.reception.Cte;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public interface CteEventService extends CteSefazService {

    CteReturnEvent event(TEvento evento) throws SoapServiceGeneralException, NoProviderFound, ProcessException, ValidationException, SecurityException;

    default CteReturnEvent cancel(CteCancel cancel) throws ProcessException, SoapServiceGeneralException, ValidationException, NoProviderFound, SecurityException {
        return event(cancel.toObject());
    }

    default CteReturnEvent cancel(String accessKey, String protocol, String defaultMessage) throws ProcessException, SoapServiceGeneralException, ValidationException, NoProviderFound, SecurityException {
        return event(CteCancel.build(accessKey, protocol, defaultMessage, "1", getConfig()).toObject());
    }

    default CteReturnEvent cancel(String accessKey, String protocol) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return cancel(accessKey, protocol, NFEvent.CANCEL.getDefaultMessage());
    }

    default CteReturnEvent correctionLetter(CteCorrectionLetter correctionLetter) throws ProcessException, SoapServiceGeneralException, ValidationException, NoProviderFound, SecurityException {
        return event(correctionLetter.toObject());
    }

    default CteReturnEvent correctionLetter(String accessKey, CteCorrectionLetter.InfEvento.DetEvento.EvCCeCTe.InfCorrecao correction, String sequence) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return correctionLetter(CteCorrectionLetter.build(accessKey, correction, sequence, getConfig()));
    }

    default CteReturnEvent correctionLetter(String accessKey, List<CteCorrectionLetter.InfEvento.DetEvento.EvCCeCTe.InfCorrecao> corrections, String sequence) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return correctionLetter(CteCorrectionLetter.build(accessKey, corrections, sequence, getConfig()));
    }

    default CteReturnEvent correctionLetter(String accessKey, CteCorrectionLetter.InfEvento.DetEvento.EvCCeCTe.InfCorrecao correction) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return correctionLetter(accessKey, Arrays.asList(correction));
    }

    default CteReturnEvent deliveryReceipt(CteDeliveryReceipt deliveryReceipt) throws ProcessException, SoapServiceGeneralException, ValidationException, NoProviderFound, SecurityException {
        return event(deliveryReceipt.toObject());
    }

    default CteReturnEvent deliveryReceipt(String accessKey, String protocol, String base64Image, String sequence, String document, String name, String lat, String lon, Collection<String> deliveryAcessKey) throws ProcessException, SoapServiceGeneralException, ValidationException, NoProviderFound, SecurityException {
        return deliveryReceipt(CteDeliveryReceipt.build(accessKey, protocol, base64Image, sequence, document, name, lat, lon, deliveryAcessKey, getConfig()));
    }

    default CteReturnEvent cancelDeliveryReceipt(CteCancelDeliveryReceipt cancelDeliveryReceipt) throws ProcessException, SoapServiceGeneralException, ValidationException, NoProviderFound, SecurityException {
        return event(cancelDeliveryReceipt.toObject());
    }

    default CteReturnEvent cancelDeliveryReceipt(String accessKey, String protocol, String sequence, String protocolDelivery) throws ProcessException, SoapServiceGeneralException, ValidationException, NoProviderFound, SecurityException {
        return cancelDeliveryReceipt(CteCancelDeliveryReceipt.build(accessKey, protocol, sequence, protocolDelivery, getConfig()));
    }

    default CteReturnEvent epec(CteEpec epec) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return event(epec.toObject());
    }

    default CteReturnEvent epec(String accessKey, CteEpec.InfEvento.DetEvento.EvEPECCTe epec) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return epec(CteEpec.build(accessKey, "1", epec, getConfig()));
    }


    default CteReturnEvent epec(Cte cte) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        cte = Cte.builder().build().fromObject(cte.toObject());
        return epec(CteEpec.build(
                AccessKeyParserFactory.cte().fromId(cte.getInfCte().getId()),
                "1",
                CteEpec.InfEvento
                        .DetEvento
                        .EvEPECCTe
                        .builder()
                        .xJust(CteEvent.EPEC.getDefaultMessage())
                        .vCarga(cte.getInfCte().getInfCTeNorm().getInfCarga().getVCarga())
                        .vtPrest(cte.getInfCte().getVPrest().getVtPrest())
                        .modal(cte.modal().getCode())
                        .ufIni(cte.ide().getUfIni())
                        .vicms(cte.vIcms())
                        .vicmsst(cte.vIcmsst())
                        .toma4(CteEpec.InfEvento.DetEvento.EvEPECCTe.Toma4.builder()
                                .toma(cte.toma().getCode())
                                .uf(cte.tomaUf())
                                .cnpj(cte.tomaCnpj())
                                .cpf(cte.tomaCpf())
                                .ie(cte.tomaIe())
                                .build())
                        .ufFim(cte.ide().getUfFim())
                        .tpCTe(cte.tpCTe().getCode())
                        .dhEmi(cte.ide().getDhEmi())
                        .build(),
                getConfig()
        ));
    }

    default CteReturnEvent gtv(CteGtv gtv) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return event(gtv.toObject());
    }

    default CteReturnEvent gtv(String accessKey, String sequence, List<CteGtv.InfEvento.DetEvento.EvGTV.InfGTV> infGTV) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return gtv(CteGtv.build(accessKey, sequence, infGTV, getConfig()));
    }

    default CteReturnEvent gtv(String accessKey, String sequence, CteGtv.InfEvento.DetEvento.EvGTV.InfGTV infGTV) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return gtv(CteGtv.build(accessKey, sequence, Collections.singletonList(infGTV), getConfig()));
    }

    default CteReturnEvent gtv(String accessKey, CteGtv.InfEvento.DetEvento.EvGTV.InfGTV infGTV) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return gtv(accessKey, Collections.singletonList(infGTV));
    }

    default CteReturnEvent provisionDisagreement(CteProvisionDisagreement provisionDisagreement) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return event(provisionDisagreement.toObject());
    }

    default CteReturnEvent provisionDisagreement(String accessKey, String sequence, String observation) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return provisionDisagreement(CteProvisionDisagreement.build(accessKey, sequence, observation, getConfig()));
    }

    default CteReturnEvent multimodal(CteMultiModal multiModal) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return event(multiModal.toObject());
    }

    default CteReturnEvent multimodal(String accessKey, String sequence, String register, String document) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return multimodal(CteMultiModal.build(accessKey, sequence, register, document, getConfig()));
    }

    CteReturnEvent multimodal(String accessKey, String register, String document) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException;

    CteReturnEvent provisionDisagreement(String accessKey, String observation) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException;

    CteReturnEvent gtv(String accessKey, List<CteGtv.InfEvento.DetEvento.EvGTV.InfGTV> infGTV) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException;

    CteReturnEvent cancelDeliveryReceipt(String accessKey, String protocolDelivery) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException;

    CteReturnEvent correctionLetter(String accessKey, List<CteCorrectionLetter.InfEvento.DetEvento.EvCCeCTe.InfCorrecao> corrections) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException;

    CteReturnEvent cancel(String accessKey) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException;

    CteReturnEvent deliveryReceipt(String accessKey, String base64Image, String document, String name, String lat, String lon, Collection<String> deliveryAcessKey) throws ProcessException, SoapServiceGeneralException, ValidationException, NoProviderFound, SecurityException;
}
