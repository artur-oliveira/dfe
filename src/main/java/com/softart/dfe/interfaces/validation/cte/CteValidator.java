package com.softart.dfe.interfaces.validation.cte;

import java.util.Collection;

public interface CteValidator {

    Collection<CteDistributionValidator> distributionValidators();

    Collection<CteEventValidator> eventValidators();

    Collection<CteInutilizationValidator> inutilizationValidators();

    Collection<CteQueryReceiptValidator> queryReceiptValidators();

    Collection<CteQuerySituationValidator> querySituationValidators();

    Collection<CteReceptionGtveValidator> receptionGtveValidators();

    Collection<CteStatusServiceValidator> statusServiceValidators();

    Collection<CteReceptionCteOsValidator> receptionCteOsValidators();

    Collection<CteReceptionCteSyncValidator> receptionCteSyncValidators();

    Collection<CteReceptionCteValidator> receptionCteValidators();


}
