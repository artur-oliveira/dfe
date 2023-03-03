package com.softart.dfe.components.process.mdfe.distribution.impl.s3;

import com.softart.dfe.components.process.mdfe.distribution.StoreDistributionMdfe;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.mdfe.MdfeStorage;
import lombok.Getter;

@Getter
final class S3StoreDistributionMdfe extends StoreDistributionMdfe {
    private final MdfeStorage storage = StorageFactory.s3().getMdfeStorage();

}
