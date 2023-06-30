package com.softart.dfe.components.storage;

import com.softart.dfe.components.storage.cte.CteS3Storage;
import com.softart.dfe.components.storage.mdfe.MdfeS3Storage;
import com.softart.dfe.components.storage.nf.NfceS3Storage;
import com.softart.dfe.components.storage.nf.NfeS3Storage;
import com.softart.dfe.interfaces.storage.cte.CteStorage;
import com.softart.dfe.interfaces.storage.mdfe.MdfeStorage;
import com.softart.dfe.interfaces.storage.nf.NfceStorage;
import com.softart.dfe.interfaces.storage.nf.NfeStorage;
import lombok.Getter;

@Getter
public final class S3StorageFactory extends StorageFactory {
    private final NfeStorage nfeStorage = new NfeS3Storage();
    private final NfceStorage nfceStorage = new NfceS3Storage();
    private final CteStorage cteStorage = new CteS3Storage();
    private final MdfeStorage mdfeStorage = new MdfeS3Storage();
}
