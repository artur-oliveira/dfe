package org.dfe.components.process.mdfe.reception.impl.s3;

import org.dfe.components.process.mdfe.reception.StoreReturnReceptionMdfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.mdfe.MdfeStorage;
import lombok.Getter;

@Getter
final class S3StoreReturnReceptionMdfe extends StoreReturnReceptionMdfe {

    private final MdfeStorage storage = StorageFactory.s3().getMdfeStorage();

}
