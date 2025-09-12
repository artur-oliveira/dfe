package org.dfe.components.process.mdfe.query_unclosed.impl.nostore;

import lombok.Getter;
import org.dfe.components.process.mdfe.query_unclosed.StoreReturnQueryUnclosedMdfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.mdfe.MdfeStorage;

@Getter
final class NoStoreReturnQueryUnclosedMdfe extends StoreReturnQueryUnclosedMdfe {

    private final MdfeStorage storage = StorageFactory.noStorage().getMdfeStorage();

}
