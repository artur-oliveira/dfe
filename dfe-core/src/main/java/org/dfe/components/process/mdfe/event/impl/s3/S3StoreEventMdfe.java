package org.dfe.components.process.mdfe.event.impl.s3;

import lombok.Getter;
import org.dfe.components.process.mdfe.event.StoreEventMdfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.mdfe.MdfeStorage;

@Getter
final class S3StoreEventMdfe extends StoreEventMdfe {
    private final MdfeStorage storage = StorageFactory.s3().getMdfeStorage();

}
