package com.softart.dfe.services.cte.query_situation;

import com.softart.dfe.enums.cte.CteEvent;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.models.cte.query_situation.CteQuerySituation;
import com.softart.dfe.models.cte.query_situation.CteQuerySituationRequest;
import com.softart.dfe.models.cte.query_situation.CteReturnQuerySituation;

import java.util.Comparator;
import java.util.Objects;

public abstract class AbstractCteQuerySituationService implements CteQuerySituationService {

    public CteReturnQuerySituation querySituation(String accessKey) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return CteReturnQuerySituation.builder().build().fromObject(getProviderFactory()
                .getCteService(getConfig())
                .querySituation(CteQuerySituationRequest
                        .builder()
                        .data(CteQuerySituation.build(accessKey, getConfig()).toObject())
                        .config(getConfig())
                        .beforeRequest(getProcess().beforeQuerySituation())
                        .afterRequest(getProcess().afterQuerySituation())
                        .validators(getValidatorFactory().cteValidator().querySituationValidators())
                        .configureProvider(getConfigureProviderFactory())
                        .build()));
    }

    @Override
    public Long getLastSequenceNumber(String accessKey, String eventType) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        CteReturnQuerySituation returnQuerySituation = CteReturnQuerySituation.builder().build().fromObject(getProviderFactory()
                .getCteService(getConfig())
                .querySituation(CteQuerySituationRequest
                        .builder()
                        .data(CteQuerySituation.build(accessKey, getConfig()).toObject())
                        .config(getConfig())
                        .beforeRequest(getProcess().beforeQuerySituation())
                        .afterRequest(getProcess().afterQuerySituation())
                        .validators(getValidatorFactory().cteValidator().querySituationValidators())
                        .configureProvider(getConfigureProviderFactory())
                        .build()));

        return returnQuerySituation
                .getProcEventoCTe()
                .stream()
                .filter(it -> Objects.equals(eventType, it.getRetEvento().getInfEvento().getTpEvento()))
                .map(it -> Long.valueOf(it.getRetEvento().getInfEvento().getNSeqEvento()))
                .max(Comparator.naturalOrder())
                .orElse(0L) + 1L;
    }
}
