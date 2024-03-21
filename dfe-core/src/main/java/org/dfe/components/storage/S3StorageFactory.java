package org.dfe.components.storage;

import lombok.Getter;
import org.dfe.components.storage.mdfe.MdfeS3Storage;
import org.dfe.components.storage.nf.NfceS3Storage;
import org.dfe.components.storage.nf.NfeS3Storage;
import org.dfe.interfaces.storage.mdfe.MdfeStorage;
import org.dfe.interfaces.storage.nf.NfceStorage;
import org.dfe.interfaces.storage.nf.NfeStorage;

@Getter
public final class S3StorageFactory extends StorageFactory {
    private final NfeStorage nfeStorage = new NfeS3Storage();
    private final NfceStorage nfceStorage = new NfceS3Storage();
    private final org.dfe.interfaces.storage.cte4.CteStorage cte4Storage = new org.dfe.components.storage.cte4.CteS3Storage();
    private final MdfeStorage mdfeStorage = new MdfeS3Storage();
}
