package org.dfe.components.process.mdfe.query_unclosed.impl.s3;

import org.dfe.components.process.mdfe.query_unclosed.StoreReturnQueryUnclosedMdfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.mdfe.MdfeStorage;
import lombok.Getter;

@Getter
final class S3StoreReturnQueryUnclosedMdfe extends StoreReturnQueryUnclosedMdfe {

    private final MdfeStorage storage = StorageFactory.s3().getMdfeStorage();

}
