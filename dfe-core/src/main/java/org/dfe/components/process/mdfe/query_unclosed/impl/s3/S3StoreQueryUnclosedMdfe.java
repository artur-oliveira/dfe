package org.dfe.components.process.mdfe.query_unclosed.impl.s3;

import lombok.Getter;
import org.dfe.components.process.mdfe.query_unclosed.StoreQueryUnclosedMdfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.mdfe.MdfeStorage;

@Getter
final class S3StoreQueryUnclosedMdfe extends StoreQueryUnclosedMdfe {
    private final MdfeStorage storage = StorageFactory.s3().getMdfeStorage();

}
