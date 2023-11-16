package org.dfe.components.process.nf.inut.impl.nostore;

import org.dfe.components.process.nf.inut.StoreRetInutilizationNfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.nf.NfInutStorage;

final class NoStoreRetInutilizationNfe extends StoreRetInutilizationNfe {

    public NfInutStorage getStorage() {
        return StorageFactory.noStorage().getNfeStorage();
    }
}
