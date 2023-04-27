package com.softart.dfe.interfaces.validation.mdfe;

import java.util.Collection;

public interface MdfeValidator {
    /**
     * It returns a collection of validators that will be used to validate the distribution of the MDF-e
     *
     * @return A collection of MdfeDistributionValidator objects.
     */
    Collection<MdfeDistributionValidator> distributionValidators();

    /**
     * It returns a collection of MdfeEventValidator objects
     *
     * @return A collection of MdfeEventValidator objects.
     */
    Collection<MdfeEventValidator> eventValidators();

    /**
     * It returns a collection of validators that will be used to validate the query receipt response
     *
     * @return A collection of MdfeQueryReceiptValidator objects.
     */
    Collection<MdfeQueryReceiptValidator> queryReceiptValidators();

    /**
     * It returns a collection of validators that will be used to validate the query situation
     *
     * @return A collection of MdfeQuerySituationValidator objects.
     */
    Collection<MdfeQuerySituationValidator> querySituationValidators();

    /**
     * It returns a collection of validators that will be used to validate the query
     *
     * @return A collection of MdfeQueryUnclosedValidator objects.
     */
    Collection<MdfeQueryUnclosedValidator> queryUnclosedValidators();

    /**
     * It returns a collection of validators that will be used to validate the reception of a MDF-e
     *
     * @return A collection of MdfeReceptionSyncValidator objects.
     */
    Collection<MdfeReceptionSyncValidator> receptionSyncValidators();

    /**
     * It returns a collection of validators that will be used to validate the reception of the MDF-e
     *
     * @return A collection of MdfeReceptionValidator objects.
     */
    Collection<MdfeReceptionValidator> receptionValidators();

    /**
     * It returns a collection of validators that will be used to validate the status service response
     *
     * @return A collection of MdfeStatusServiceValidator objects.
     */
    Collection<MdfeStatusServiceValidator> statusServiceValidators();
}
