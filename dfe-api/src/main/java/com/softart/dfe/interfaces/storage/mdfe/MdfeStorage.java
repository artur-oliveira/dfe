package com.softart.dfe.interfaces.storage.mdfe;

/**
 * This code is defining a Java interface named `MdfeStorage` that extends several other interfaces:
 * `MdfeDistributionStorage`, `MdfeEventStorage`, `MdfeQueryReceiptStorage`, `MdfeQuerySituationStorage`,
 * `MdfeQueryUnclosedStorage`, `MdfeReceptionStorage`, `MdfeReceptionSyncStorage`, and `MdfeStatusServiceStorage`. By
 * extending these interfaces, `MdfeStorage` inherits their methods and defines a new interface that combines all of their
 * functionality.
 */
public interface MdfeStorage extends MdfeDistributionStorage, MdfeEventStorage, MdfeQueryReceiptStorage, MdfeQuerySituationStorage, MdfeQueryUnclosedStorage, MdfeReceptionStorage, MdfeReceptionSyncStorage, MdfeStatusServiceStorage {
}
