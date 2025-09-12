package org.dfe.components.process.mdfe.query_situation.impl.nostore;

import lombok.Getter;
import org.dfe.components.process.mdfe.query_situation.StoreQuerySituationMdfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.mdfe.MdfeStorage;

@Getter
final class NoStoreQuerySituationMdfe extends StoreQuerySituationMdfe {
    private final MdfeStorage storage = StorageFactory.noStorage().getMdfeStorage();

}
