package org.dfe.components.storage;

import lombok.Getter;
import org.dfe.components.storage.mdfe.MdfeFileSystemStorage;
import org.dfe.components.storage.nf.NfceFileSystemStorage;
import org.dfe.components.storage.nf.NfeFileSystemStorage;
import org.dfe.interfaces.storage.mdfe.MdfeStorage;
import org.dfe.interfaces.storage.nf.NfceStorage;
import org.dfe.interfaces.storage.nf.NfeStorage;

@Getter
final class FileSystemStorageFactory extends StorageFactory {
    private final NfeStorage nfeStorage = new NfeFileSystemStorage();
    private final NfceStorage nfceStorage = new NfceFileSystemStorage();
    private final org.dfe.interfaces.storage.cte4.CteStorage cte4Storage = new org.dfe.components.storage.cte4.CteFileSystemStorage();
    private final MdfeStorage mdfeStorage = new MdfeFileSystemStorage();

}
