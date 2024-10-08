package org.dfe.components.process.mdfe.event.impl.s3;

import org.dfe.components.process.mdfe.event.StoreProcEventMdfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.mdfe.MdfeStorage;
import lombok.Getter;

@Getter
final class S3StoreProcEventMdfe extends StoreProcEventMdfe {

    private final MdfeStorage storage = StorageFactory.s3().getMdfeStorage();

}
