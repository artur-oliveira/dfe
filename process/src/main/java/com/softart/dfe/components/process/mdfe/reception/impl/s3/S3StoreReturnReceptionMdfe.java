package com.softart.dfe.components.process.mdfe.reception.impl.s3;

import com.softart.dfe.components.process.mdfe.reception.StoreReturnReceptionMdfe;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.mdfe.MdfeStorage;
import lombok.Getter;

@Getter
final class S3StoreReturnReceptionMdfe extends StoreReturnReceptionMdfe {

    private final MdfeStorage storage = StorageFactory.s3().getMdfeStorage();

}
