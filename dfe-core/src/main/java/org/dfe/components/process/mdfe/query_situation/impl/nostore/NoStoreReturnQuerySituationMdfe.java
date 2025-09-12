package org.dfe.components.process.mdfe.query_situation.impl.nostore;

import lombok.Getter;
import org.dfe.components.process.mdfe.query_situation.StoreReturnQuerySituationMdfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.mdfe.MdfeStorage;

@Getter
final class NoStoreReturnQuerySituationMdfe extends StoreReturnQuerySituationMdfe {

    private final MdfeStorage storage = StorageFactory.noStorage().getMdfeStorage();

}
