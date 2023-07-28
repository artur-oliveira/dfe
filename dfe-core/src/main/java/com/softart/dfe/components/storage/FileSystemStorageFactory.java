package com.softart.dfe.components.storage;

import com.softart.dfe.components.storage.cte.CteFileSystemStorage;
import com.softart.dfe.components.storage.mdfe.MdfeFileSystemStorage;
import com.softart.dfe.components.storage.nf.NfceFileSystemStorage;
import com.softart.dfe.components.storage.nf.NfeFileSystemStorage;
import com.softart.dfe.interfaces.storage.cte.CteStorage;
import com.softart.dfe.interfaces.storage.mdfe.MdfeStorage;
import com.softart.dfe.interfaces.storage.nf.NfceStorage;
import com.softart.dfe.interfaces.storage.nf.NfeStorage;
import lombok.Getter;

@Getter
final class FileSystemStorageFactory extends StorageFactory {
    private final NfeStorage nfeStorage = new NfeFileSystemStorage();
    private final NfceStorage nfceStorage = new NfceFileSystemStorage();
    private final com.softart.dfe.interfaces.storage.cte4.CteStorage cte4Storage = new com.softart.dfe.components.storage.cte4.CteFileSystemStorage();
    private final CteStorage cteStorage = new CteFileSystemStorage();
    private final MdfeStorage mdfeStorage = new MdfeFileSystemStorage();

}
