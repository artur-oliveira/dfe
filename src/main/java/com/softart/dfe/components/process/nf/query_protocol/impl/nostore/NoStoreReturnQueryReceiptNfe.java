package com.softart.dfe.components.process.nf.query_protocol.impl.nostore;

import com.softart.dfe.components.process.nf.query_protocol.StoreReturnQueryProtocolNfe;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.nf.common.NfQueryProtocolStorage;

final class NoStoreReturnQueryReceiptNfe extends StoreReturnQueryProtocolNfe {

    public NfQueryProtocolStorage getStorage() {
        return StorageFactory.noStorage().getNfeStorage();
    }
}
