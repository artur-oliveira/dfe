package org.dfe.components.process.mdfe.reception_sync.impl.s3;

import lombok.Getter;
import org.dfe.components.process.mdfe.reception_sync.StoreProcMdfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.mdfe.MdfeStorage;

@Getter
final class S3StoreProcMdfe extends StoreProcMdfe {

    private final MdfeStorage storage = StorageFactory.s3().getMdfeStorage();

}
