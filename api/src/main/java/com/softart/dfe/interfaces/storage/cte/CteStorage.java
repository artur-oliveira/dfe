package com.softart.dfe.interfaces.storage.cte;

/**
 * This code is defining a Java interface named `CteStorage` that extends ten other interfaces: `CteDistributionStorage`,
 * `CteEventStorage`, `CteInutilizationStorage`, `CteQuerySituationStorage`, `CteReceptionStorage`,
 * `CteReceptionGtveStorage`, `CteReceptionOsStorage`, `CteReceptionSyncStorage`, `CteQueryReceiptStorage`, and
 * `CteStatusServiceStorage`. By extending these interfaces, `CteStorage` inherits all of their methods and can be used to
 * represent a storage system for various types of electronic documents related to Brazilian taxes and fiscal operations.
 */
public interface CteStorage extends CteDistributionStorage, CteEventStorage, CteInutilizationStorage, CteQuerySituationStorage, CteReceptionStorage, CteReceptionGtveStorage, CteReceptionOsStorage, CteReceptionSyncStorage, CteQueryReceiptStorage, CteStatusServiceStorage {
}
