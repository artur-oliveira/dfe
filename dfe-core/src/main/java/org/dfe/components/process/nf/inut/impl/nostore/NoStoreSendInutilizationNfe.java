package org.dfe.components.process.nf.inut.impl.nostore;

import org.dfe.components.process.nf.inut.StoreSendInutilizationNfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.nf.NfInutStorage;

final class NoStoreSendInutilizationNfe extends StoreSendInutilizationNfe {

    public NfInutStorage getStorage() {
        return StorageFactory.noStorage().getNfeStorage();
    }

}
