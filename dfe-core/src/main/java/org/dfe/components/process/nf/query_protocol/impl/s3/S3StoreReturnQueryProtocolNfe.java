package org.dfe.components.process.nf.query_protocol.impl.s3;

import org.dfe.components.process.nf.query_protocol.StoreReturnQueryProtocolNfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.nf.common.NfQueryProtocolStorage;

final class S3StoreReturnQueryProtocolNfe extends StoreReturnQueryProtocolNfe {

    public NfQueryProtocolStorage getStorage() {
        return StorageFactory.s3().getNfeStorage();
    }
}
