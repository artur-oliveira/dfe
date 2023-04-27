package com.softart.dfe.components.process.nf.query_protocol.impl.nostore;

import com.softart.dfe.components.process.nf.query_protocol.StoreQueryProtocolNfe;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.nf.common.NfQueryProtocolStorage;

final class NoStoreQueryReceiptNfe extends StoreQueryProtocolNfe {

    public NfQueryProtocolStorage getStorage() {
        return StorageFactory.noStorage().getNfeStorage();
    }

}
