package com.softart.dfe.components.process.mdfe.query_situation.impl.nostore;

import com.softart.dfe.components.process.mdfe.query_situation.StoreReturnQuerySituationMdfe;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.mdfe.MdfeStorage;
import lombok.Getter;

@Getter
final class NoStoreReturnQuerySituationMdfe extends StoreReturnQuerySituationMdfe {

    private final MdfeStorage storage = StorageFactory.noStorage().getMdfeStorage();

}
