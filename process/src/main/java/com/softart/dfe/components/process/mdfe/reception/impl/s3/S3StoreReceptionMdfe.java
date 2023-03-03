package com.softart.dfe.components.process.mdfe.reception.impl.s3;

import com.softart.dfe.components.process.mdfe.reception.StoreReceptionMdfe;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.mdfe.MdfeStorage;
import lombok.Getter;

@Getter
final class S3StoreReceptionMdfe extends StoreReceptionMdfe {

    private final MdfeStorage storage = StorageFactory.s3().getMdfeStorage();
}
