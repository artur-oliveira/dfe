package com.softart.dfe.components.validation.cte4;

import com.softart.dfe.interfaces.validation.cte4.*;

import java.util.Collection;
import java.util.Collections;

public final class DefaultCte4Validator implements Cte4Validator {

    private final Collection<CteDistributionValidator> distributionValidators = Collections.singletonList(new XSDDistributionValidator());
    private final Collection<Cte4EventValidator> eventValidators = Collections.singletonList(new XSDEventValidator());
    private final Collection<Cte4QuerySituationValidator> querySituationValidators = Collections.singletonList(new XSDQuerySituationValidator());
    private final Collection<Cte4ReceptionCteOsValidator> receptionCteOsValidators = Collections.singletonList(new XSDReceptionCteOsValidator());
    private final Collection<Cte4ReceptionCteSyncValidator> receptionCteSyncValidators = Collections.singletonList(new XSDReceptionCteSyncValidator());
    private final Collection<Cte4ReceptionGtveValidator> receptionGtveValidators = Collections.singletonList(new XSDReceptionGtveValidator());
    private final Collection<Cte4StatusServiceValidator> statusServiceValidators = Collections.singletonList(new XSDStatusServiceValidator());


    @Override
    public Collection<CteDistributionValidator> distributionValidators() {
        return distributionValidators;
    }

    @Override
    public Collection<Cte4EventValidator> eventValidators() {
        return eventValidators;
    }

    @Override
    public Collection<Cte4QuerySituationValidator> querySituationValidators() {
        return querySituationValidators;
    }

    @Override
    public Collection<Cte4ReceptionGtveValidator> receptionGtveValidators() {
        return receptionGtveValidators;
    }

    @Override
    public Collection<Cte4ReceptionCteOsValidator> receptionCteOsValidators() {
        return receptionCteOsValidators;
    }

    @Override
    public Collection<Cte4ReceptionCteSyncValidator> receptionCteSyncValidators() {
        return receptionCteSyncValidators;
    }

    @Override
    public Collection<Cte4StatusServiceValidator> statusServiceValidators() {
        return statusServiceValidators;
    }
}
