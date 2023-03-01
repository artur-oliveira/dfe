package com.softart.dfe.components.process.mdfe.query_situation.impl.nostore;

import com.softart.dfe.components.process.mdfe.query_situation.StoreQuerySituationMdfe;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.mdfe.MdfeStorage;
import lombok.Getter;

@Getter
final class NoStoreQuerySituationMdfe extends StoreQuerySituationMdfe {
    private final MdfeStorage storage = StorageFactory.noStorage().getMdfeStorage();

}
