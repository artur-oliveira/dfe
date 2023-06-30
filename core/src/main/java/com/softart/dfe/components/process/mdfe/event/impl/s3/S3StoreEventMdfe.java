package com.softart.dfe.components.process.mdfe.event.impl.s3;

import com.softart.dfe.components.process.mdfe.event.StoreEventMdfe;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.mdfe.MdfeStorage;
import lombok.Getter;

@Getter
final class S3StoreEventMdfe extends StoreEventMdfe {
    private final MdfeStorage storage = StorageFactory.s3().getMdfeStorage();

}
