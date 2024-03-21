package org.dfe.components.process.mdfe.reception.impl.s3;

import lombok.Getter;
import org.dfe.components.process.mdfe.reception.StoreReturnReceptionMdfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.mdfe.MdfeStorage;

@Getter
final class S3StoreReturnReceptionMdfe extends StoreReturnReceptionMdfe {

    private final MdfeStorage storage = StorageFactory.s3().getMdfeStorage();

}
