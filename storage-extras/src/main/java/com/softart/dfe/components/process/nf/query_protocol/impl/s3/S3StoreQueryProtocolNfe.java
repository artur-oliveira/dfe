package com.softart.dfe.components.process.nf.query_protocol.impl.s3;

import com.softart.dfe.components.process.nf.query_protocol.StoreQueryProtocolNfe;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.nf.common.NfQueryProtocolStorage;

final class S3StoreQueryProtocolNfe extends StoreQueryProtocolNfe {

    public NfQueryProtocolStorage getStorage() {
        return StorageFactory.s3().getNfeStorage();
    }
}
