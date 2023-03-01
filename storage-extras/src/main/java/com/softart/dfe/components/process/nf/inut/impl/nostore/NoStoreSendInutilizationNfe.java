package com.softart.dfe.components.process.nf.inut.impl.nostore;

import com.softart.dfe.components.process.nf.inut.StoreSendInutilizationNfe;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.nf.NfInutStorage;

final class NoStoreSendInutilizationNfe extends StoreSendInutilizationNfe {

    public NfInutStorage getStorage() {
        return StorageFactory.noStorage().getNfeStorage();
    }

}
