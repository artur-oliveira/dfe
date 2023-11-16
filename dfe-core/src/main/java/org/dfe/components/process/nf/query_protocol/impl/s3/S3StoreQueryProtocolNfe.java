package org.dfe.components.process.nf.query_protocol.impl.s3;

import org.dfe.components.process.nf.query_protocol.StoreQueryProtocolNfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.nf.common.NfQueryProtocolStorage;

final class S3StoreQueryProtocolNfe extends StoreQueryProtocolNfe {

    public NfQueryProtocolStorage getStorage() {
        return StorageFactory.s3().getNfeStorage();
    }
}
