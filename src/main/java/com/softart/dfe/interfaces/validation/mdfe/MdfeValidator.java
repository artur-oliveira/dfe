package com.softart.dfe.interfaces.validation.mdfe;

import java.util.Collection;

public interface MdfeValidator {
    Collection<MdfeDistributionValidator> distributionValidators();

    Collection<MdfeEventValidator> eventValidators();

    Collection<MdfeQueryReceiptValidator> queryReceiptValidators();

    Collection<MdfeQuerySituationValidator> querySituationValidators();

    Collection<MdfeQueryUnclosedValidator> queryUnclosedValidators();

    Collection<MdfeReceptionSyncValidator> receptionSyncValidators();

    Collection<MdfeReceptionValidator> receptionValidators();

    Collection<MdfeStatusServiceValidator> statusServiceValidators();
}
