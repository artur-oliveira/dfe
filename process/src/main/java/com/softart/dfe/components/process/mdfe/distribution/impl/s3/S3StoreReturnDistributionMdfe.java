package com.softart.dfe.components.process.mdfe.distribution.impl.s3;

import com.softart.dfe.components.process.mdfe.distribution.StoreReturnDistributionMdfe;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.mdfe.MdfeStorage;
import lombok.Getter;

@Getter
final class S3StoreReturnDistributionMdfe extends StoreReturnDistributionMdfe {

    private final MdfeStorage storage = StorageFactory.s3().getMdfeStorage();

}
