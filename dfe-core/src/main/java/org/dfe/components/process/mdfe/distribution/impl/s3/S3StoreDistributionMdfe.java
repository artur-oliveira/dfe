package org.dfe.components.process.mdfe.distribution.impl.s3;

import org.dfe.components.process.mdfe.distribution.StoreDistributionMdfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.mdfe.MdfeStorage;
import lombok.Getter;

@Getter
final class S3StoreDistributionMdfe extends StoreDistributionMdfe {
    private final MdfeStorage storage = StorageFactory.s3().getMdfeStorage();

}
