package com.softart.dfe.components.process.mdfe.query_unclosed.impl.s3;

import com.softart.dfe.components.process.mdfe.query_unclosed.StoreReturnQueryUnclosedMdfe;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.mdfe.MdfeStorage;
import lombok.Getter;

@Getter
final class S3StoreReturnQueryUnclosedMdfe extends StoreReturnQueryUnclosedMdfe {

    private final MdfeStorage storage = StorageFactory.s3().getMdfeStorage();

}
