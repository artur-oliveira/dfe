package org.dfe.components.process.mdfe.query_unclosed.impl.nostore;

import org.dfe.components.process.mdfe.query_unclosed.StoreReturnQueryUnclosedMdfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.mdfe.MdfeStorage;
import lombok.Getter;

@Getter
final class NoStoreReturnQueryUnclosedMdfe extends StoreReturnQueryUnclosedMdfe {

    private final MdfeStorage storage = StorageFactory.noStorage().getMdfeStorage();

}
