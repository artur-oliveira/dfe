package org.dfe.services.cte4.event;

import br.inf.portalfiscal.cte.send400.TEvento;
import org.dfe.components.internal.parser.AccessKeyParserFactory;
import org.dfe.enums.cte.CteEvent;
import org.dfe.exceptions.ProcessException;
import org.dfe.exceptions.ValidationException;
import org.dfe.exceptions.port.SoapServiceGeneralException;
import org.dfe.exceptions.security.SecurityException;
import org.dfe.exceptions.services.NoProviderFound;
import org.dfe.interfaces.internal.config.CteConfig;
import org.dfe.interfaces.services.Cte4SefazService;
import org.dfe.models.cte4.event.*;
import org.dfe.models.cte4.query_situation.CteReturnQuerySituation;
import org.dfe.models.cte4.reception_sync.Cte;
import org.dfe.services.cte4.query_situation.CteQuerySituationService;
import org.dfe.util.RequireUtils;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public interface CteEventService extends Cte4SefazService {

    /**
     * A function that receives an object of type TEvento and returns an object of type CteReturnEvent.
     *
     * @param evento The event object to be sent to the SEFAZ.
     * @return A CteReturnEvent object.
     */
    default CteReturnEvent event(TEvento evento) throws SoapServiceGeneralException, NoProviderFound, ProcessException, ValidationException, SecurityException {
        CteConfig config = getConfig().withEnviroment(evento.getInfEvento().getTpAmb());
        return CteReturnEvent.builder().build().fromObject(getProviderFactory().getCte4Service(config)
                .event(CteEventRequest.builder()
                        .data(evento)
                        .signer(getXmlSigner())
                        .config(config)
                        .configureProvider(getConfigureProviderFactory())
                        .beforeRequest(getProcess().beforeEvent())
                        .afterRequest(getProcess().afterEvent())
                        .validators(getValidatorFactory().cte4Validator().eventValidators())
                        .build()));
    }

    /**
     * It cancels a Cte.
     *
     * @param cancel The CteCancel object that contains the information about the cancellation.
     * @return The CteReturnEvent object.
     */
    default CteReturnEvent cancel(CteCancel cancel) throws ProcessException, SoapServiceGeneralException, ValidationException, NoProviderFound, SecurityException {
        return event(cancel.toObject());
    }

    /**
     * Cancel a CTe using the access key and protocol number.
     *
     * @param accessKey      The access key of the CTe.
     * @param protocol       The protocol number of the CTe to be canceled.
     * @param defaultMessage The message that will be sent to the SEFAZ.
     * @return The CteReturnEvent object.
     */
    default CteReturnEvent cancel(String accessKey, String protocol, String defaultMessage) throws ProcessException, SoapServiceGeneralException, ValidationException, NoProviderFound, SecurityException {
        return event(CteCancel.build(accessKey, protocol, defaultMessage, "1", getConfig()).toObject());
    }

    /**
     * Cancels a CTe, given its access key and protocol number.
     *
     * @param accessKey The access key of the CTe.
     * @param protocol  The protocol number of the CTe to be canceled.
     * @return A CteReturnEvent object.
     */
    default CteReturnEvent cancel(String accessKey, String protocol) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return cancel(accessKey, protocol, CteEvent.CANCEL.getDefaultMessage());
    }

    /**
     * "Send a correction letter to the CteReturnEvent service."
     *
     * @param correctionLetter The correction letter object.
     * @return A CteReturnEvent object.
     */
    default CteReturnEvent correctionLetter(CteCorrectionLetter correctionLetter) throws ProcessException, SoapServiceGeneralException, ValidationException, NoProviderFound, SecurityException {
        return event(correctionLetter.toObject());
    }

    /**
     * A function that receives a correction letter and returns a CteReturnEvent.
     *
     * @param accessKey  The access key of the CTe.
     * @param correction The correction to be made.
     * @param sequence   The sequence number of the event.
     * @return The return is a CteReturnEvent object, which contains the following attributes:
     */
    default CteReturnEvent correctionLetter(String accessKey, CteCorrectionLetter.InfEvento.DetEvento.EvCCeCTe.InfCorrecao correction, String sequence) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return correctionLetter(CteCorrectionLetter.build(accessKey, correction, sequence, getConfig()));
    }

    /**
     * A function that receives a list of corrections and a sequence number and returns a CteReturnEvent.
     *
     * @param accessKey   The access key of the CTe that will be corrected.
     * @param corrections A list of corrections to be made.
     * @param sequence    The sequence number of the event.
     * @return The CteReturnEvent object.
     */
    default CteReturnEvent correctionLetter(String accessKey, List<CteCorrectionLetter.InfEvento.DetEvento.EvCCeCTe.InfCorrecao> corrections, String sequence) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return correctionLetter(CteCorrectionLetter.build(accessKey, corrections, sequence, getConfig()));
    }

    /**
     * A function that receives a string and a correction and returns a CteReturnEvent.
     *
     * @param accessKey  The access key of the CTe.
     * @param correction The correction to be made.
     * @return A CteReturnEvent object.
     */
    default CteReturnEvent correctionLetter(String accessKey, CteCorrectionLetter.InfEvento.DetEvento.EvCCeCTe.InfCorrecao correction) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return correctionLetter(accessKey, Collections.singletonList(correction));
    }

    /**
     * It converts the CteDeliveryReceipt object to a CteReturnEvent object.
     *
     * @param deliveryReceipt The CteDeliveryReceipt object that you want to send to the CteReturnEvent service.
     * @return A CteReturnEvent object.
     */
    default CteReturnEvent deliveryReceipt(CteDeliveryReceipt deliveryReceipt) throws ProcessException, SoapServiceGeneralException, ValidationException, NoProviderFound, SecurityException {
        return event(deliveryReceipt.toObject());
    }

    /**
     * A function that receives a delivery receipt.
     *
     * @param accessKey        The access key of the CTe.
     * @param protocol         The protocol number of the CTe.
     * @param base64Image      The base64 image of the delivery receipt.
     * @param sequence         The sequence number of the CTe.
     * @param document         The document number of the person who is delivering the receipt.
     * @param name             The name of the person who signed the delivery receipt.
     * @param lat              latitude
     * @param lon              Longitude
     * @param deliveryAcessKey The access key of the delivery.
     * @return The CteReturnEvent object.
     */
    default CteReturnEvent deliveryReceipt(String accessKey, String protocol, String sequence, String base64Image, String document, String name, String lat, String lon, Collection<String> deliveryAcessKey) throws ProcessException, SoapServiceGeneralException, ValidationException, NoProviderFound, SecurityException {
        return deliveryReceipt(CteDeliveryReceipt.build(accessKey, protocol, sequence, base64Image, document, name, lat, lon, deliveryAcessKey, getConfig()));
    }

    /**
     * Cancel a delivery receipt.
     *
     * @param cancelDeliveryReceipt The object that contains the data to be sent to the SEFAZ.
     * @return The CteReturnEvent object.
     */
    default CteReturnEvent cancelDeliveryReceipt(CteCancelDeliveryReceipt cancelDeliveryReceipt) throws ProcessException, SoapServiceGeneralException, ValidationException, NoProviderFound, SecurityException {
        return event(cancelDeliveryReceipt.toObject());
    }

    /**
     * Cancel a delivery receipt
     *
     * @param accessKey        The access key of the CTe.
     * @param protocol         The protocol number of the CTe that you want to cancel.
     * @param sequence         The sequence number of the CTe.
     * @param protocolDelivery The protocol number of the delivery receipt.
     * @return The CteReturnEvent object.
     */
    default CteReturnEvent cancelDeliveryReceipt(String accessKey, String protocol, String sequence, String protocolDelivery) throws ProcessException, SoapServiceGeneralException, ValidationException, NoProviderFound, SecurityException {
        return cancelDeliveryReceipt(CteCancelDeliveryReceipt.build(accessKey, protocol, sequence, protocolDelivery, getConfig()));
    }

    /**
     * This function returns a CteReturnEvent object, which is the result of calling the event function with the CteEpec
     * object converted to a CteEvent object.
     *
     * @param epec The epec object that you want to return.
     * @return A CteReturnEvent object.
     */
    default CteReturnEvent epec(CteEpec epec) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return event(epec.toObject());
    }

    /**
     * Send an EPEC event to the Sefaz.
     *
     * @param accessKey The access key of the CTe.
     * @param epec      The CteEpec object.
     * @return The return is the same as the return of the method "sendEvent"
     */
    default CteReturnEvent epec(String accessKey, CteEpec.InfEvento.DetEvento.EvEPECCTe epec) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return epec(CteEpec.build(accessKey, "1", epec, getConfig()));
    }


    /**
     * Send an EPEC event to the CTe.
     *
     * @param cte The Cte object that will be used to generate the event.
     * @return A CteReturnEvent object.
     */
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

    /**
     * This function takes a CteGtv object and returns a CteReturnEvent object
     *
     * @param gtv The GTV object that contains the data to be sent to the CTE.
     * @return A CteReturnEvent object.
     */
    default CteReturnEvent gtv(CteGtv gtv) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return event(gtv.toObject());
    }

    /**
     * Send a GTV event to the Sefaz.
     *
     * @param accessKey The access key of the CT-e.
     * @param sequence  The sequence number of the event.
     * @param infGTV    List of GTV objects
     * @return The return is a CteReturnEvent object, which contains the following attributes:
     */
    default CteReturnEvent gtv(String accessKey, String sequence, List<CteGtv.InfEvento.DetEvento.EvGTV.InfGTV> infGTV) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return gtv(CteGtv.build(accessKey, sequence, infGTV, getConfig()));
    }

    /**
     * It receives a CteGtv object, validates it, sends it to the Sefaz, and returns a CteReturnEvent object
     *
     * @param accessKey The access key of the CTe.
     * @param sequence  The sequence number of the event.
     * @param infGTV    The object that contains the information about the event.
     * @return The return is a CteReturnEvent object, which contains the following attributes:
     */
    default CteReturnEvent gtv(String accessKey, String sequence, CteGtv.InfEvento.DetEvento.EvGTV.InfGTV infGTV) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return gtv(CteGtv.build(accessKey, sequence, Collections.singletonList(infGTV), getConfig()));
    }

    /**
     * A function that receives a string and a list of objects and returns a CteReturnEvent object.
     *
     * @param accessKey The access key of the CTe.
     * @param infGTV    The object that contains the information about the event.
     * @return The return is a CteReturnEvent object, which contains the following attributes:
     */
    default CteReturnEvent gtv(String accessKey, CteGtv.InfEvento.DetEvento.EvGTV.InfGTV infGTV) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return gtv(accessKey, Collections.singletonList(infGTV));
    }

    /**
     * It converts the CteProvisionDisagreement object to a CteReturnEvent object.
     *
     * @param provisionDisagreement The provisionDisagreement object that you want to send to the CTE.
     * @return A CteReturnEvent object.
     */
    default CteReturnEvent provisionDisagreement(CteProvisionDisagreement provisionDisagreement) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return event(provisionDisagreement.toObject());
    }

    /**
     * A function that is used to provision a disagreement.
     *
     * @param accessKey   The access key of the CTe.
     * @param sequence    The sequence number of the CTe.
     * @param observation The reason for the disagreement.
     * @return The CteReturnEvent object.
     */
    default CteReturnEvent provisionDisagreement(String accessKey, String sequence, String observation) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return provisionDisagreement(CteProvisionDisagreement.build(accessKey, sequence, observation, getConfig()));
    }

    /**
     * It receives a CteMultiModal object and returns a CteReturnEvent object
     *
     * @param multiModal The event multiModal
     * @return The return is a CteReturnEvent object, which contains the following attributes:
     */
    default CteReturnEvent multimodal(CteMultiModal multiModal) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return event(multiModal.toObject());
    }

    /**
     * It receives a CteMultiModal object and returns a CteReturnEvent object
     *
     * @param accessKey The access key of the CTe.
     * @param sequence  The sequence number of the CTe.
     * @param register  The register number of the CTe.
     * @param document  The document number of the CTe.
     * @return The return is a CteReturnEvent object, which contains the following attributes:
     */
    default CteReturnEvent multimodal(String accessKey, String sequence, String register, String document) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return multimodal(CteMultiModal.build(accessKey, sequence, register, document, getConfig()));
    }

    /**
     * It returns the CteReturnEvent object.
     *
     * @param accessKey The access key provided by the provider.
     * @param register  The register number of the company that will be sending the document.
     * @param document  XML document to be sent to the Sefaz.
     * @return The return is a CteReturnEvent object.
     */
    default CteReturnEvent multimodal(String accessKey, String register, String document) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        CteReturnQuerySituation querySituation = getCteQuerySituationService().querySituation(accessKey);
        return multimodal(accessKey, querySituation.getLastSequenceNumberAsString(CteEvent.MULTIMODAL.getCode()), register, document);
    }

    /**
     * It provisions a disagreement for the CTE.
     *
     * @param accessKey   The access key of the user who is making the request.
     * @param observation The observation of the provisioning.
     * @return The response is a CteReturnEvent object.
     */
    default CteReturnEvent provisionDisagreement(String accessKey, String observation) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        CteReturnQuerySituation querySituation = getCteQuerySituationService().querySituation(accessKey);
        return provisionDisagreement(accessKey, querySituation.getLastSequenceNumberAsString(CteEvent.PROVISION_IN_DISAGREEMENT.getCode()), observation);
    }

    /**
     * It sends a GTV event to the Sefaz.
     *
     * @param accessKey The access key of the CTe.
     * @param infGTV    List of GTV objects
     * @return The return is a CteReturnEvent object.
     */
    default CteReturnEvent gtv(String accessKey, List<CteGtv.InfEvento.DetEvento.EvGTV.InfGTV> infGTV) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        CteReturnQuerySituation querySituation = getCteQuerySituationService().querySituation(accessKey);
        return gtv(accessKey, querySituation.getLastSequenceNumberAsString(CteEvent.INFO_GTV.getCode()), infGTV);
    }

    /**
     * Cancels a delivery receipt
     *
     * @param accessKey        The access key provided by the provider.
     * @param protocolDelivery The protocol number of the delivery receipt.
     * @return The response is a CteReturnEvent object.
     */
    default CteReturnEvent cancelDeliveryReceipt(String accessKey, String protocolDelivery) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        CteReturnQuerySituation querySituation = getCteQuerySituationService().querySituation(accessKey);
        return cancelDeliveryReceipt(accessKey, querySituation.getProtCTe().protocol(), querySituation.getLastSequenceNumberAsString(CteEvent.CANCEL_DELIVERY_RECEIPT.getCode()), protocolDelivery);
    }

    /**
     * It creates a correction letter for a CTe.
     *
     * @param accessKey   The access key of the CTe.
     * @param corrections A list of corrections to be made.
     * @return The CteReturnEvent object contains the XML of the event.
     */
    default CteReturnEvent correctionLetter(String accessKey, List<CteCorrectionLetter.InfEvento.DetEvento.EvCCeCTe.InfCorrecao> corrections) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return correctionLetter(accessKey, corrections, String.valueOf(getCteQuerySituationService().getLastSequenceNumber(accessKey, CteEvent.CORRECTION_LETTER)));
    }

    /**
     * Cancels a Cte
     *
     * @param accessKey The access key of the user who is cancelling the Cte.
     * @return The cancel method returns a CteReturnEvent object.
     */
    default CteReturnEvent cancel(String accessKey) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return cancel(accessKey, RequireUtils.nonNull(getCteQuerySituationService().querySituation(accessKey).getProtCTe(), "protocol must be not null to cancel cfe " + accessKey).protocol());
    }

    /**
     * It returns a delivery receipt.
     *
     * @param accessKey        The access key of the user who is sending the delivery receipt.
     * @param base64Image      The base64 image of the delivery receipt.
     * @param document         The document number of the person who is delivering the goods.
     * @param name             The name of the person who signed the document.
     * @param lat              latitude
     * @param lon              Longitude
     * @param deliveryAcessKey The access key of the delivery.
     * @return CteReturnEvent
     */
    default CteReturnEvent deliveryReceipt(String accessKey, String base64Image, String document, String name, String lat, String lon, Collection<String> deliveryAcessKey) throws ProcessException, SoapServiceGeneralException, ValidationException, NoProviderFound, SecurityException {
        CteReturnQuerySituation querySituation = getCteQuerySituationService().querySituation(accessKey);
        return deliveryReceipt(accessKey, querySituation.getProtCTe().protocol(), querySituation.getLastSequenceNumberAsString(CteEvent.DELIVERY_RECEIPT.getCode()), base64Image, document, name, lat, lon, deliveryAcessKey);
    }

    CteQuerySituationService getCteQuerySituationService();

}
