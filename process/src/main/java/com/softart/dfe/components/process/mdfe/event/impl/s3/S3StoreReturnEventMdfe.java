package com.softart.dfe.components.process.mdfe.event.impl.s3;

import com.softart.dfe.components.process.mdfe.event.StoreReturnEventMdfe;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.mdfe.MdfeStorage;
import lombok.Getter;

@Getter
final class S3StoreReturnEventMdfe extends StoreReturnEventMdfe {

    private final MdfeStorage storage = StorageFactory.s3().getMdfeStorage();

}
