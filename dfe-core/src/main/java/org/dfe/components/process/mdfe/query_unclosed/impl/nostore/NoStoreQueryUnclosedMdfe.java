package org.dfe.components.process.mdfe.query_unclosed.impl.nostore;

import lombok.Getter;
import org.dfe.components.process.mdfe.query_unclosed.StoreQueryUnclosedMdfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.mdfe.MdfeStorage;

@Getter
final class NoStoreQueryUnclosedMdfe extends StoreQueryUnclosedMdfe {
    private final MdfeStorage storage = StorageFactory.noStorage().getMdfeStorage();

}
