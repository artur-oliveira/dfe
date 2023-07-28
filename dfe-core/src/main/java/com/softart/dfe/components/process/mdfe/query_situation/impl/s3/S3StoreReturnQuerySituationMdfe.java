package com.softart.dfe.components.process.mdfe.query_situation.impl.s3;

import com.softart.dfe.components.process.mdfe.query_situation.StoreReturnQuerySituationMdfe;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.mdfe.MdfeStorage;
import lombok.Getter;

@Getter
final class S3StoreReturnQuerySituationMdfe extends StoreReturnQuerySituationMdfe {

    private final MdfeStorage storage = StorageFactory.s3().getMdfeStorage();

}
