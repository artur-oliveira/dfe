package com.softart.dfe.components.process.mdfe.event.impl.s3;

import com.softart.dfe.components.process.mdfe.event.StoreProcEventMdfe;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.mdfe.MdfeStorage;
import lombok.Getter;

@Getter
final class S3StoreProcEventMdfe extends StoreProcEventMdfe {

    private final MdfeStorage storage = StorageFactory.s3().getMdfeStorage();

}
