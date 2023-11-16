package org.dfe.components.process.mdfe.query_unclosed.impl.nostore;

import org.dfe.components.process.mdfe.query_unclosed.StoreQueryUnclosedMdfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.mdfe.MdfeStorage;
import lombok.Getter;

@Getter
final class NoStoreQueryUnclosedMdfe extends StoreQueryUnclosedMdfe {
    private final MdfeStorage storage = StorageFactory.noStorage().getMdfeStorage();

}
