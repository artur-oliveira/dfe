package org.dfe.components.process.nf.inut.impl.nostore;

import org.dfe.components.process.nf.inut.StoreProcInutilizationNfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.nf.NfInutStorage;

final class NoStoreProcInutilizationNfe extends StoreProcInutilizationNfe {

    public NfInutStorage getStorage() {
        return StorageFactory.noStorage().getNfeStorage();
    }
}
