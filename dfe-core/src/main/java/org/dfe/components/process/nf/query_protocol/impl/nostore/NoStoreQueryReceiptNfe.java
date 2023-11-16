package org.dfe.components.process.nf.query_protocol.impl.nostore;

import org.dfe.components.process.nf.query_protocol.StoreQueryProtocolNfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.nf.common.NfQueryProtocolStorage;

final class NoStoreQueryReceiptNfe extends StoreQueryProtocolNfe {

    public NfQueryProtocolStorage getStorage() {
        return StorageFactory.noStorage().getNfeStorage();
    }

}
