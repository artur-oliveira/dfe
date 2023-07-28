package com.softart.dfe.components.validation.mdfe;

import com.softart.dfe.interfaces.validation.mdfe.*;
import lombok.AccessLevel;
import lombok.Getter;

import java.util.Collection;
import java.util.Collections;

@Getter(AccessLevel.PRIVATE)
public final class DefaultMdfeValidator implements MdfeValidator {

    private final Collection<MdfeDistributionValidator> distributionValidators = Collections.singletonList(new XSDDistributionValidator());
    private final Collection<MdfeEventValidator> eventValidators = Collections.singletonList(new XSDEventValidator());
    private final Collection<MdfeQueryReceiptValidator> queryReceiptValidators = Collections.singletonList(new XSDQueryReceiptValidator());
    private final Collection<MdfeQuerySituationValidator> querySituationValidators = Collections.singletonList(new XSDQuerySituationValidator());
    private final Collection<MdfeQueryUnclosedValidator> queryUnclosedValidators = Collections.singletonList(new XSDQueryUnclosedValidator());
    private final Collection<MdfeReceptionSyncValidator> receptionSyncValidators = Collections.singletonList(new XSDReceptionSyncValidator());
    private final Collection<MdfeReceptionValidator> receptionValidators = Collections.singletonList(new XSDReceptionValidator());
    private final Collection<MdfeStatusServiceValidator> statusServiceValidators = Collections.singletonList(new XSDStatusServiceValidator());

    @Override
    public Collection<MdfeDistributionValidator> distributionValidators() {
        return getDistributionValidators();
    }

    @Override
    public Collection<MdfeEventValidator> eventValidators() {
        return getEventValidators();
    }

    @Override
    public Collection<MdfeQueryReceiptValidator> queryReceiptValidators() {
        return getQueryReceiptValidators();
    }

    @Override
    public Collection<MdfeQuerySituationValidator> querySituationValidators() {
        return getQuerySituationValidators();
    }

    @Override
    public Collection<MdfeQueryUnclosedValidator> queryUnclosedValidators() {
        return getQueryUnclosedValidators();
    }

    @Override
    public Collection<MdfeReceptionSyncValidator> receptionSyncValidators() {
        return getReceptionSyncValidators();
    }

    @Override
    public Collection<MdfeReceptionValidator> receptionValidators() {
        return getReceptionValidators();
    }

    @Override
    public Collection<MdfeStatusServiceValidator> statusServiceValidators() {
        return getStatusServiceValidators();
    }
}
