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
import com.softart.dfe.models.cte.event.ReturnEvent;
import com.softart.dfe.services.cte.query_situation.CteQuerySituationService;

import java.util.List;

public abstract class AbstractCteEventService implements CteEventService {
    @Override
    public ReturnEvent event(TEvento evento) throws SoapServiceGeneralException, NoProviderFound, ProcessException, ValidationException, SecurityException {
        return ReturnEvent.builder().build().fromObject(getProviderFactory().getCteService(getConfig())
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
    public ReturnEvent cancel(String accessKey) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return cancel(accessKey, getCteQuerySituationService().querySituation(accessKey).getProtCTe().protocol());
    }

    @Override
    public ReturnEvent correctionLetter(String accessKey, List<CteCorrectionLetter.InfEvento.DetEvento.EvCCeCTe.InfCorrecao> corrections) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return correctionLetter(accessKey, corrections, String.valueOf(getCteQuerySituationService().getLastSequenceNumber(accessKey, CteEvent.CORRECTION_LETTER)));
    }

    public abstract CteQuerySituationService getCteQuerySituationService();
}
