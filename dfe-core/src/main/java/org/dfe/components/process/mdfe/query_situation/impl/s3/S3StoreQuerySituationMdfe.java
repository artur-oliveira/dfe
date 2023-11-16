package org.dfe.components.process.mdfe.query_situation.impl.s3;

import org.dfe.components.process.mdfe.query_situation.StoreQuerySituationMdfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.mdfe.MdfeStorage;
import lombok.Getter;

@Getter
final class S3StoreQuerySituationMdfe extends StoreQuerySituationMdfe {
    private final MdfeStorage storage = StorageFactory.s3().getMdfeStorage();

}
