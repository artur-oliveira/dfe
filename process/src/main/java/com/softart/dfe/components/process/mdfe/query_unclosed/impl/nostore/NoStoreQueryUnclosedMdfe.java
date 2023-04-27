package com.softart.dfe.components.process.mdfe.query_unclosed.impl.nostore;

import com.softart.dfe.components.process.mdfe.query_unclosed.StoreQueryUnclosedMdfe;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.mdfe.MdfeStorage;
import lombok.Getter;

@Getter
final class NoStoreQueryUnclosedMdfe extends StoreQueryUnclosedMdfe {
    private final MdfeStorage storage = StorageFactory.noStorage().getMdfeStorage();

}
