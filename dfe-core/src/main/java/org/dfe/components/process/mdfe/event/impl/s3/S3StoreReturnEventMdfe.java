package org.dfe.components.process.mdfe.event.impl.s3;

import org.dfe.components.process.mdfe.event.StoreReturnEventMdfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.mdfe.MdfeStorage;
import lombok.Getter;

@Getter
final class S3StoreReturnEventMdfe extends StoreReturnEventMdfe {

    private final MdfeStorage storage = StorageFactory.s3().getMdfeStorage();

}
