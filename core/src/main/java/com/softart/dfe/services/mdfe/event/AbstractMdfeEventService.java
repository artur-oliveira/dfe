package com.softart.dfe.services.mdfe.event;

import com.softart.dfe.enums.mdfe.MdfeEvent;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.models.mdfe.event.*;
import com.softart.dfe.models.mdfe.query_situation.MdfeReturnQuerySituation;
import com.softart.dfe.services.mdfe.query_situation.MdfeQuerySituationService;

import java.util.List;

public abstract class AbstractMdfeEventService implements MdfeEventService {

    @Override
    public MdfeReturnEvent transportConfirmation(String accessKey) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return transportConfirmation(accessKey, getMdfeQuerySituationService().querySituation(accessKey).protocol());
    }

    @Override
    public MdfeReturnEvent driverInclusion(String accessKey, MdfeDriverInclusion.InfEvento.DetEvento.EvIncCondutorMDFe.Condutor condutor) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return driverInclusion(accessKey, condutor, getMdfeQuerySituationService().querySituation(accessKey).getLastSequenceNumberAsString(MdfeEvent.DRIVER_INCLUSION.getCode()));
    }

    @Override
    public MdfeReturnEvent paymentOperation(String accessKey, MdfePaymentOperation.InfEvento.DetEvento.EvPagtoOperMDFe.InfViagens travel, List<MdfePaymentOperation.InfEvento.DetEvento.EvPagtoOperMDFe.InfPag> payments) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        MdfeReturnQuerySituation returnQuerySituation = getMdfeQuerySituationService().querySituation(accessKey);
        return paymentOperation(accessKey, returnQuerySituation.protocol(), travel, payments, returnQuerySituation.getLastSequenceNumberAsString(MdfeEvent.PAYMENT_OPERATION.getCode()));
    }

    @Override
    public MdfeReturnEvent dfeInclusion(String accessKey, String cityLoadingCode, String cityLoadingDescription, List<MdfeDfeInclusion.InfEvento.DetEvento.EvIncDFeMDFe.InfDoc> documents) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        MdfeReturnQuerySituation returnQuerySituation = getMdfeQuerySituationService().querySituation(accessKey);
        return dfeInclusion(accessKey, returnQuerySituation.protocol(), cityLoadingCode, cityLoadingDescription, documents, returnQuerySituation.getLastSequenceNumberAsString(MdfeEvent.DFE_INCLUSION.getCode()));
    }

    @Override
    public MdfeReturnEvent paymentModification(String accessKey, List<MdfePaymentModification.InfEvento.DetEvento.EvAlteracaoPagtoServMDFe.InfPag> infoPayments) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        MdfeReturnQuerySituation returnQuerySituation = getMdfeQuerySituationService().querySituation(accessKey);
        return paymentModification(accessKey, returnQuerySituation.protocol(), infoPayments, returnQuerySituation.getLastSequenceNumberAsString(MdfeEvent.PAYMENT_MODIFICATION.getCode()));
    }

    @Override
    public MdfeReturnEvent close(String accessKey, String ufCode, String cityCode) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        MdfeReturnQuerySituation returnQuerySituation = getMdfeQuerySituationService().querySituation(accessKey);
        return close(accessKey, returnQuerySituation.protocol(), ufCode, cityCode);
    }

    @Override
    public MdfeReturnEvent cancel(String accessKey, String motive) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        MdfeReturnQuerySituation returnQuerySituation = getMdfeQuerySituationService().querySituation(accessKey);
        return cancel(accessKey, returnQuerySituation.protocol(), motive);
    }

    public abstract MdfeQuerySituationService getMdfeQuerySituationService();
}
