package org.dfe.components.process.mdfe.query_situation.impl.s3;

import lombok.Getter;
import org.dfe.components.process.mdfe.query_situation.StoreReturnQuerySituationMdfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.mdfe.MdfeStorage;

@Getter
final class S3StoreReturnQuerySituationMdfe extends StoreReturnQuerySituationMdfe {

    private final MdfeStorage storage = StorageFactory.s3().getMdfeStorage();

}
