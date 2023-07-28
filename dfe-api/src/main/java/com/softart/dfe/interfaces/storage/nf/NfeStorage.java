package com.softart.dfe.interfaces.storage.nf;

import com.softart.dfe.interfaces.storage.nf.common.NfCommonStorage;
import com.softart.dfe.interfaces.storage.nf.common.NfeQueryRegisterStorage;

/**
 * This code is defining a Java interface named `NfeStorage` that extends several other interfaces: `NfCommonStorage`,
 * `NfeQueryRegisterStorage`, `NfeDistributionStorage`, `NfeManifestationStorage`, `NfeCorrectionLetterStorage`,
 * `NfeEpecStorage`, and `NfeInterestedActorStorage`. By extending these interfaces, `NfeStorage` inherits all of their
 * methods and can be used to represent a storage system for electronic invoices in a larger software system.
 */
public interface NfeStorage extends NfCommonStorage, NfeQueryRegisterStorage, NfeDistributionStorage, NfeManifestationStorage, NfeCorrectionLetterStorage, NfeEpecStorage, NfeInterestedActorStorage {
}
