package com.softart.dfe.interfaces.storage.nf;

import com.softart.dfe.interfaces.storage.nf.common.NfCommonStorage;
import com.softart.dfe.interfaces.storage.nf.common.NfeQueryRegisterStorage;

public interface NfeStorage extends NfCommonStorage, NfeQueryRegisterStorage, NfeDistributionStorage, NfeManifestationStorage, NfeCorrectionLetterStorage, NfeEpecStorage, NfeInterestedActorStorage {
}
