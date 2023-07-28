package com.softart.dfe.services.mdfe.event;

import br.inf.portalfiscal.mdfe.classes.TEvento;
import com.softart.dfe.enums.mdfe.MdfeEvent;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.interfaces.internal.config.MdfeConfig;
import com.softart.dfe.interfaces.services.MdfeSefazService;
import com.softart.dfe.models.mdfe.event.*;
import com.softart.dfe.models.mdfe.query_situation.MdfeReturnQuerySituation;
import com.softart.dfe.services.mdfe.query_situation.MdfeQuerySituationService;

import java.util.List;

public interface MdfeEventService extends MdfeSefazService {

    /**
     * A function that sends an event to the SEFAZ.
     *
     * @param evento The event object to be sent to the SEFAZ.
     * @return The return is the object MdfeReturnEvent, which contains the response of the event.
     */
    default MdfeReturnEvent event(TEvento evento) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        MdfeConfig config = getConfig().withEnviroment(evento.getInfEvento().getTpAmb());
        return MdfeReturnEvent
                .builder()
                .build()
                .fromObject(getProviderFactory()
                        .getMdfeService(config)
                        .event(MdfeEventRequest
                                .builder()
                                .data(evento)
                                .signer(getXmlSigner())
                                .config(config)
                                .configureProvider(getConfigureProviderFactory())
                                .validators(getValidatorFactory().mdfeValidator().eventValidators())
                                .afterRequest(getProcess().afterEvent())
                                .beforeRequest(getProcess().beforeEvent())
                                .build()));
    }

    /**
     * It receives a MdfeTransportConfirmation object, converts it to a MdfeTransportConfirmation object, and then calls
     * the event function, which is the one that actually sends the event to the SEFAZ
     *
     * @param confirmation MdfeTransportConfirmation object
     * @return The return is the object MdfeReturnEvent, which contains the response of the event.
     */
    default MdfeReturnEvent transportConfirmation(MdfeTransportConfirmation confirmation) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return event(confirmation.toObject());
    }

    /**
     * "This function sends a transport confirmation to the MDF-e webservice."
     *
     * @param accessKey The access key of the MDF-e.
     * @param protocol  The protocol number of the transport confirmation.
     * @return The return is the MdfeReturnEvent object, which contains the return of the event.
     */
    default MdfeReturnEvent transportConfirmation(String accessKey, String protocol) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return transportConfirmation(MdfeTransportConfirmation.build(accessKey, protocol, "1", getConfig()));
    }

    /**
     * It includes a driver in the MDF-e
     *
     * @param driverInclusion The driverInclusion object that will be sent to the webservice.
     * @return The return is the object MdfeReturnEvent, which contains the response of the event.
     */
    default MdfeReturnEvent driverInclusion(MdfeDriverInclusion driverInclusion) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return event(driverInclusion.toObject());
    }

    /**
     * It includes a driver in the MDF-e
     *
     * @param accessKey  The access key of the MDF-e.
     * @param driverName Driver's name
     * @param driverCpf  Driver's CPF
     * @param sequence   The sequence number of the driver in the MDF-e.
     * @return The return is the object MdfeReturnEvent, which contains the response of the event.
     */
    default MdfeReturnEvent driverInclusion(String accessKey, String driverName, String driverCpf, String sequence) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return driverInclusion(MdfeDriverInclusion.build(accessKey, driverName, driverCpf, sequence, getConfig()));
    }

    /**
     * It sends a driver inclusion event to the Sefaz
     *
     * @param accessKey The access key of the MDF-e.
     * @param condutor  Driver object
     * @param sequence  The sequence number of the event.
     * @return The return is the object MdfeReturnEvent, which contains the response of the event.
     */
    default MdfeReturnEvent driverInclusion(String accessKey, MdfeDriverInclusion.InfEvento.DetEvento.EvIncCondutorMDFe.Condutor condutor, String sequence) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return driverInclusion(MdfeDriverInclusion.build(accessKey, condutor, sequence, getConfig()));
    }

    /**
     * It includes a driver in the MDF-e.
     *
     * @param accessKey  The access key of the user who is making the request.
     * @param driverName Driver's name
     * @param driverCpf  Driver's CPF
     * @return The return is a MdfeReturnEvent object.
     */
    default MdfeReturnEvent driverInclusion(String accessKey, String driverName, String driverCpf) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return driverInclusion(accessKey, MdfeDriverInclusion.InfEvento.DetEvento.EvIncCondutorMDFe.Condutor.builder().cpf(driverCpf).xNome(driverName).build());
    }

    /**
     * It receives a payment operation object, converts it to a generic event object, and sends it to the event function
     *
     * @param paymentOperation The payment operation to be performed.
     * @return The return is the object MdfeReturnEvent, which contains the response of the event.
     */
    default MdfeReturnEvent paymentOperation(MdfePaymentOperation paymentOperation) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return event(paymentOperation.toObject());
    }

    /**
     * It receives the access key, the protocol, the travel information, the payments information and the sequence and
     * returns the event
     *
     * @param accessKey The access key of the MDF-e.
     * @param protocol  The protocol number of the MDF-e.
     * @param travel    The travel information.
     * @param payments  List of payments.
     * @param sequence  The sequence number of the event.
     * @return The return is the object MdfeReturnEvent, which contains the response of the event.
     */
    default MdfeReturnEvent paymentOperation(String accessKey, String protocol, MdfePaymentOperation.InfEvento.DetEvento.EvPagtoOperMDFe.InfViagens travel, List<MdfePaymentOperation.InfEvento.DetEvento.EvPagtoOperMDFe.InfPag> payments, String sequence) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return paymentOperation(MdfePaymentOperation.build(accessKey, protocol, travel, payments, sequence, getConfig()));
    }

    /**
     * It receives a DfeInclusion object, and sends it to the event function
     *
     * @param dfeInclusion The object that contains the data to be sent to the SEFAZ.
     * @return The return is the object MdfeReturnEvent, which contains the response of the event.
     */
    default MdfeReturnEvent dfeInclusion(MdfeDfeInclusion dfeInclusion) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return event(dfeInclusion.toObject());
    }

    /**
     * It includes a list of documents in the MDF-e
     *
     * @param accessKey              The access key of the MDF-e.
     * @param protocol               The protocol number of the MDF-e that will be included in the event.
     * @param cityLoadingCode        The code of the city where the MDF-e was loaded.
     * @param cityLoadingDescription City description where the MDF-e was loaded.
     * @param documents              List of documents to be included in the event.
     * @param sequence               The sequence number of the event.
     * @return The return is the object MdfeReturnEvent, which contains the response of the event.
     */
    default MdfeReturnEvent dfeInclusion(String accessKey, String protocol, String cityLoadingCode, String cityLoadingDescription, List<MdfeDfeInclusion.InfEvento.DetEvento.EvIncDFeMDFe.InfDoc> documents, String sequence) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return dfeInclusion(MdfeDfeInclusion.build(accessKey, protocol, cityLoadingCode, cityLoadingDescription, documents, sequence, getConfig()));
    }

    /**
     * This function sends a payment modification event to the MDF-e webservice.
     *
     * @param paymentModification The payment modification object.
     * @return The return is the event response.
     */
    default MdfeReturnEvent paymentModification(MdfePaymentModification paymentModification) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return event(paymentModification.toObject());
    }

    /**
     * It receives the access key, the protocol, the sequence, the list of payments and the configuration and returns the
     * payment modification
     *
     * @param accessKey    The access key of the MDF-e.
     * @param protocol     The protocol number of the MDF-e that will be modified.
     * @param infoPayments List of payments to be modified.
     * @param sequence     The sequence number of the event.
     * @return The return is the object MdfeReturnEvent, which contains the response of the event.
     */
    default MdfeReturnEvent paymentModification(String accessKey, String protocol, List<MdfePaymentModification.InfEvento.DetEvento.EvAlteracaoPagtoServMDFe.InfPag> infoPayments, String sequence) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return paymentModification(MdfePaymentModification.build(accessKey, protocol, sequence, infoPayments, getConfig()));
    }

    /**
     * Closes the MDF-e and returns the event.
     *
     * @param mdfeClose The object that contains the data to be sent to the SEFAZ.
     * @return The return is the object MdfeReturnEvent, which contains the response of the event.
     */
    default MdfeReturnEvent close(MdfeClose mdfeClose) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return event(mdfeClose.toObject());
    }

    /**
     * It closes the MDF-e, and returns the event
     *
     * @param accessKey The access key of the MDFe.
     * @param protocol  The protocol number of the MDFe that you want to close.
     * @param ufCode    The state code of the state where the MDFe was issued.
     * @param cityCode  The city code where the MDF-e was issued.
     * @return The return is the object MdfeReturnEvent, which contains the return of the event.
     */
    default MdfeReturnEvent close(String accessKey, String protocol, String ufCode, String cityCode) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return close(MdfeClose.build(accessKey, protocol, ufCode, cityCode, "1", getConfig()));
    }

    /**
     * It receives a MdfeCancel object, converts it to a MdfeCancelEvent object, and then calls the event() function
     *
     * @param mdfeCancel The object that contains the data to be sent to the SEFAZ.
     * @return The return of the event is the MdfeReturnEvent object.
     */
    default MdfeReturnEvent cancel(MdfeCancel mdfeCancel) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return event(mdfeCancel.toObject());
    }

    /**
     * Cancels a MDFe document, given its access key and protocol number.
     *
     * @param accessKey The access key of the MDF-e.
     * @param protocol  The protocol number of the MDFe that you want to cancel.
     * @param motive    The reason for the cancellation.
     * @return The return is a MdfeReturnEvent object.
     */
    default MdfeReturnEvent cancel(String accessKey, String protocol, String motive) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return cancel(MdfeCancel.build(accessKey, protocol, motive, "1", getConfig()));
    }

    /**
     * It cancels a MDFe
     *
     * @param accessKey The access key of the MDF-e.
     * @return The return is the event object.
     */
    default MdfeReturnEvent cancel(String accessKey) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return cancel(accessKey, MdfeEvent.CANCEL.getDefaultMessage());
    }

    /**
     * Cancel a MDF-e
     *
     * @param accessKey The access key of the MDFe.
     * @param motive    The reason for the cancellation.
     * @return The return is a MdfeReturnEvent object.
     */
    default MdfeReturnEvent cancel(String accessKey, String motive) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        MdfeReturnQuerySituation returnQuerySituation = getMdfeQuerySituationService().querySituation(accessKey);
        return cancel(accessKey, returnQuerySituation.protocol(), motive);
    }

    /**
     * Closes the MDF-e
     *
     * @param accessKey The access key of the user who is closing the MDF-e.
     * @param ufCode    The state code of the state where the MDF-e is being closed.
     * @param cityCode  The city code of the city where the MDFe was issued.
     * @return The return is a MdfeReturnEvent object.
     */
    default MdfeReturnEvent close(String accessKey, String ufCode, String cityCode) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        MdfeReturnQuerySituation returnQuerySituation = getMdfeQuerySituationService().querySituation(accessKey);
        return close(accessKey, returnQuerySituation.protocol(), ufCode, cityCode);
    }

    /**
     * It modifies the payment information of the MDF-e.
     *
     * @param accessKey    The access key of the MDF-e.
     * @param infoPayments List of payments to be modified.
     * @return The return is a MdfeReturnEvent object.
     */
    default MdfeReturnEvent paymentModification(String accessKey, List<MdfePaymentModification.InfEvento.DetEvento.EvAlteracaoPagtoServMDFe.InfPag> infoPayments) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        MdfeReturnQuerySituation returnQuerySituation = getMdfeQuerySituationService().querySituation(accessKey);
        return paymentModification(accessKey, returnQuerySituation.protocol(), infoPayments, returnQuerySituation.getLastSequenceNumberAsString(MdfeEvent.PAYMENT_MODIFICATION.getCode()));
    }

    /**
     * It includes a document in the MDF-e.
     *
     * @param accessKey              The access key of the MDF-e.
     * @param cityLoadingCode        The code of the city where the loading is taking place.
     * @param cityLoadingDescription City where the loading is happening.
     * @param documents              List of documents to be included in the event.
     * @return The return is a MdfeReturnEvent object.
     */
    default MdfeReturnEvent dfeInclusion(String accessKey, String cityLoadingCode, String cityLoadingDescription, List<MdfeDfeInclusion.InfEvento.DetEvento.EvIncDFeMDFe.InfDoc> documents) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        MdfeReturnQuerySituation returnQuerySituation = getMdfeQuerySituationService().querySituation(accessKey);
        return dfeInclusion(accessKey, returnQuerySituation.protocol(), cityLoadingCode, cityLoadingDescription, documents, returnQuerySituation.getLastSequenceNumberAsString(MdfeEvent.DFE_INCLUSION.getCode()));
    }

    default MdfeReturnEvent paymentOperation(String accessKey, MdfePaymentOperation.InfEvento.DetEvento.EvPagtoOperMDFe.InfViagens travel, List<MdfePaymentOperation.InfEvento.DetEvento.EvPagtoOperMDFe.InfPag> payments) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        MdfeReturnQuerySituation returnQuerySituation = getMdfeQuerySituationService().querySituation(accessKey);
        return paymentOperation(accessKey, returnQuerySituation.protocol(), travel, payments, returnQuerySituation.getLastSequenceNumberAsString(MdfeEvent.PAYMENT_OPERATION.getCode()));
    }

    /**
     * It includes a driver in the MDF-e.
     *
     * @param accessKey The access key of the MDF-e.
     * @param condutor  The driver object.
     * @return The return is a MdfeReturnEvent object.
     */
    default MdfeReturnEvent driverInclusion(String accessKey, MdfeDriverInclusion.InfEvento.DetEvento.EvIncCondutorMDFe.Condutor condutor) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return driverInclusion(accessKey, condutor, getMdfeQuerySituationService().querySituation(accessKey).getLastSequenceNumberAsString(MdfeEvent.DRIVER_INCLUSION.getCode()));
    }

    /**
     * This function returns the transport confirmation of the MDF-e
     *
     * @param accessKey The access key of the MDF-e.
     * @return The return is a MdfeReturnEvent object.
     */
    default MdfeReturnEvent transportConfirmation(String accessKey) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return transportConfirmation(accessKey, getMdfeQuerySituationService().querySituation(accessKey).protocol());
    }

    MdfeQuerySituationService getMdfeQuerySituationService();
}
