package com.softart.dfe.services.mdfe.event;

import br.inf.portalfiscal.mdfe.classes.TEvento;
import com.softart.dfe.enums.mdfe.MdfeEvent;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.interfaces.services.MdfeSefazService;
import com.softart.dfe.models.mdfe.event.*;

import java.util.List;

public interface MdfeEventService extends MdfeSefazService {

    default MdfeReturnEvent event(TEvento evento) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return MdfeReturnEvent
                .builder()
                .build()
                .fromObject(getProviderFactory()
                        .getMdfeService(getConfig())
                        .event(MdfeEventRequest
                                .builder()
                                .data(evento)
                                .signer(getXmlSigner())
                                .config(getConfig())
                                .configureProvider(getConfigureProviderFactory())
                                .validators(getValidatorFactory().mdfeValidator().eventValidators())
                                .afterRequest(getProcess().afterEvent())
                                .beforeRequest(getProcess().beforeEvent())
                                .build()));
    }

    default MdfeReturnEvent transportConfirmation(MdfeTransportConfirmation confirmation) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return event(confirmation.toObject());
    }

    default MdfeReturnEvent transportConfirmation(String accessKey, String protocol) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return transportConfirmation(MdfeTransportConfirmation.build(accessKey, protocol, "1", getConfig()));
    }

    default MdfeReturnEvent driverInclusion(MdfeDriverInclusion driverInclusion) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return event(driverInclusion.toObject());
    }

    default MdfeReturnEvent driverInclusion(String accessKey, String driverName, String driverCpf, String sequence) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return driverInclusion(MdfeDriverInclusion.build(accessKey, driverName, driverCpf, sequence, getConfig()));
    }

    default MdfeReturnEvent driverInclusion(String accessKey, MdfeDriverInclusion.InfEvento.DetEvento.EvIncCondutorMDFe.Condutor condutor, String sequence) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return driverInclusion(MdfeDriverInclusion.build(accessKey, condutor, sequence, getConfig()));
    }

    default MdfeReturnEvent paymentOperation(MdfePaymentOperation paymentOperation) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return event(paymentOperation.toObject());
    }

    default MdfeReturnEvent paymentOperation(String accessKey, String protocol, MdfePaymentOperation.InfEvento.DetEvento.EvPagtoOperMDFe.InfViagens travel, List<MdfePaymentOperation.InfEvento.DetEvento.EvPagtoOperMDFe.InfPag> payments, String sequence) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return paymentOperation(MdfePaymentOperation.build(accessKey, protocol, travel, payments, sequence, getConfig()));
    }

    default MdfeReturnEvent dfeInclusion(MdfeDfeInclusion dfeInclusion) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return event(dfeInclusion.toObject());
    }

    default MdfeReturnEvent dfeInclusion(String accessKey, String protocol, String cityLoadingCode, String cityLoadingDescription, List<MdfeDfeInclusion.InfEvento.DetEvento.EvIncDFeMDFe.InfDoc> documents, String sequence) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return dfeInclusion(MdfeDfeInclusion.build(accessKey, protocol, cityLoadingCode, cityLoadingDescription, documents, sequence, getConfig()));
    }

    default MdfeReturnEvent paymentModification(MdfePaymentModification paymentModification) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return event(paymentModification.toObject());
    }

    default MdfeReturnEvent paymentModification(String accessKey, String protocol, List<MdfePaymentModification.InfEvento.DetEvento.EvAlteracaoPagtoServMDFe.InfPag> infoPayments, String sequence) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return paymentModification(MdfePaymentModification.build(accessKey, protocol, sequence, infoPayments, getConfig()));
    }

    default MdfeReturnEvent close(MdfeClose mdfeClose) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return event(mdfeClose.toObject());
    }

    default MdfeReturnEvent close(String accessKey, String protocol, String ufCode, String cityCode) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return close(MdfeClose.build(accessKey, protocol, ufCode, cityCode, "1", getConfig()));
    }

    default MdfeReturnEvent cancel(MdfeCancel mdfeCancel) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return event(mdfeCancel.toObject());
    }

    default MdfeReturnEvent cancel(String accessKey, String protocol, String motive) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return cancel(MdfeCancel.build(accessKey, protocol, motive, "1", getConfig()));
    }

    default MdfeReturnEvent cancel(String accessKey) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return cancel(accessKey, MdfeEvent.CANCEL.getDefaultMessage());
    }

    MdfeReturnEvent cancel(String accessKey, String motive) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException;

    MdfeReturnEvent close(String accessKey, String ufCode, String cityCode) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException;

    MdfeReturnEvent paymentModification(String accessKey, List<MdfePaymentModification.InfEvento.DetEvento.EvAlteracaoPagtoServMDFe.InfPag> infoPayments) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException;

    MdfeReturnEvent dfeInclusion(String accessKey, String cityLoadingCode, String cityLoadingDescription, List<MdfeDfeInclusion.InfEvento.DetEvento.EvIncDFeMDFe.InfDoc> documents) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException;

    MdfeReturnEvent paymentOperation(String accessKey, MdfePaymentOperation.InfEvento.DetEvento.EvPagtoOperMDFe.InfViagens travel, List<MdfePaymentOperation.InfEvento.DetEvento.EvPagtoOperMDFe.InfPag> payments) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException;

    MdfeReturnEvent driverInclusion(String accessKey, MdfeDriverInclusion.InfEvento.DetEvento.EvIncCondutorMDFe.Condutor condutor) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException;

    MdfeReturnEvent driverInclusion(String accessKey, String driverName, String driverCpf) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException;

    MdfeReturnEvent transportConfirmation(String accessKey) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException;

}
