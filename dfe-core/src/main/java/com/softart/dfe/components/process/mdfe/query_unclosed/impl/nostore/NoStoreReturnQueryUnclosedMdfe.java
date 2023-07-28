package com.softart.dfe.components.process.mdfe.query_unclosed.impl.nostore;

import com.softart.dfe.components.process.mdfe.query_unclosed.StoreReturnQueryUnclosedMdfe;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.mdfe.MdfeStorage;
import lombok.Getter;

@Getter
final class NoStoreReturnQueryUnclosedMdfe extends StoreReturnQueryUnclosedMdfe {

    private final MdfeStorage storage = StorageFactory.noStorage().getMdfeStorage();

}
