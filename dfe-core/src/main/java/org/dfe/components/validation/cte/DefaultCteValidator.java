package org.dfe.components.validation.cte;

import org.dfe.interfaces.validation.cte.*;

import java.util.Collection;
import java.util.Collections;

public final class DefaultCteValidator implements CteValidator {

    private final Collection<CteDistributionValidator> distributionValidators = Collections.singletonList(new XSDDistributionValidator());
    private final Collection<CteEventValidator> eventValidators = Collections.singletonList(new XSDEventValidator());
    private final Collection<CteInutilizationValidator> inutilizationValidators = Collections.singletonList(new XSDInutilizationValidator());
    private final Collection<CteQueryReceiptValidator> queryReceiptValidators = Collections.singletonList(new XSDQueryReceiptValidator());
    private final Collection<CteQuerySituationValidator> querySituationValidators = Collections.singletonList(new XSDQuerySituationValidator());
    private final Collection<CteReceptionCteOsValidator> receptionCteOsValidators = Collections.singletonList(new XSDReceptionCteOsValidator());
    private final Collection<CteReceptionCteSyncValidator> receptionCteSyncValidators = Collections.singletonList(new XSDReceptionCteSyncValidator());
    private final Collection<CteReceptionCteValidator> receptionCteValidators = Collections.singletonList(new XSDReceptionCteValidator());
    private final Collection<CteReceptionGtveValidator> receptionGtveValidators = Collections.singletonList(new XSDReceptionGtveValidator());
    private final Collection<CteStatusServiceValidator> statusServiceValidators = Collections.singletonList(new XSDStatusServiceValidator());


    @Override
    public Collection<CteDistributionValidator> distributionValidators() {
        return distributionValidators;
    }

    @Override
    public Collection<CteEventValidator> eventValidators() {
        return eventValidators;
    }

    @Override
    public Collection<CteInutilizationValidator> inutilizationValidators() {
        return inutilizationValidators;
    }

    @Override
    public Collection<CteQueryReceiptValidator> queryReceiptValidators() {
        return queryReceiptValidators;
    }

    @Override
    public Collection<CteQuerySituationValidator> querySituationValidators() {
        return querySituationValidators;
    }

    @Override
    public Collection<CteReceptionGtveValidator> receptionGtveValidators() {
        return receptionGtveValidators;
    }

    @Override
    public Collection<CteReceptionCteOsValidator> receptionCteOsValidators() {
        return receptionCteOsValidators;
    }

    @Override
    public Collection<CteReceptionCteSyncValidator> receptionCteSyncValidators() {
        return receptionCteSyncValidators;
    }

    @Override
    public Collection<CteReceptionCteValidator> receptionCteValidators() {
        return receptionCteValidators;
    }

    @Override
    public Collection<CteStatusServiceValidator> statusServiceValidators() {
        return statusServiceValidators;
    }
}
