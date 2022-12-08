package com.softart.dfe.services.cte.event;

import br.inf.portalfiscal.cte.send.TEvento;
import com.softart.dfe.enums.nf.NFEvent;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.interfaces.services.CteSefazService;
import com.softart.dfe.models.cte.event.CteCancel;
import com.softart.dfe.models.cte.event.CteCorrectionLetter;
import com.softart.dfe.models.cte.event.ReturnEvent;

import java.util.Arrays;
import java.util.List;

public interface CteEventService extends CteSefazService {

    ReturnEvent event(TEvento evento) throws SoapServiceGeneralException, NoProviderFound, ProcessException, ValidationException, SecurityException;

    default ReturnEvent cancel(CteCancel cancel) throws ProcessException, SoapServiceGeneralException, ValidationException, NoProviderFound, SecurityException {
        return event(cancel.toObject());
    }

    default ReturnEvent cancel(String accessKey, String protocol, String defaultMessage) throws ProcessException, SoapServiceGeneralException, ValidationException, NoProviderFound, SecurityException {
        return event(CteCancel.build(accessKey, protocol, defaultMessage, "1", getConfig()).toObject());
    }

    default ReturnEvent cancel(String accessKey, String protocol) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return cancel(accessKey, protocol, NFEvent.CANCEL.getDefaultMessage());
    }

    default ReturnEvent correctionLetter(CteCorrectionLetter correctionLetter) throws ProcessException, SoapServiceGeneralException, ValidationException, NoProviderFound, SecurityException {
        return event(correctionLetter.toObject());
    }

    default ReturnEvent correctionLetter(String accessKey, CteCorrectionLetter.InfEvento.DetEvento.EvCCeCTe.InfCorrecao correction, String sequence) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return correctionLetter(CteCorrectionLetter.build(accessKey, correction, sequence, getConfig()));
    }

    default ReturnEvent correctionLetter(String accessKey, List<CteCorrectionLetter.InfEvento.DetEvento.EvCCeCTe.InfCorrecao> corrections, String sequence) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return correctionLetter(CteCorrectionLetter.build(accessKey, corrections, sequence, getConfig()));
    }

    default ReturnEvent correctionLetter(String accessKey, CteCorrectionLetter.InfEvento.DetEvento.EvCCeCTe.InfCorrecao correction) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return correctionLetter(accessKey, Arrays.asList(correction));
    }

    ReturnEvent correctionLetter(String accessKey, List<CteCorrectionLetter.InfEvento.DetEvento.EvCCeCTe.InfCorrecao> corrections) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException;

    ReturnEvent cancel(String accessKey) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException;

}
