package com.softart.dfe.components.storage;

import com.softart.dfe.components.storage.cte.CteFileSystemStorage;
import com.softart.dfe.components.storage.nf.NfceFileSystemStorage;
import com.softart.dfe.components.storage.nf.NfeFileSystemStorage;
import com.softart.dfe.interfaces.storage.cte.CteStorage;
import com.softart.dfe.interfaces.storage.nf.NfceStorage;
import com.softart.dfe.interfaces.storage.nf.NfeStorage;

final class FileSystemStorageFactory extends StorageFactory {
    @Override
    public NfeStorage getNfeStorage() {
        return new NfeFileSystemStorage();
    }

    @Override
    public NfceStorage getNfceStorage() {
        return new NfceFileSystemStorage();
    }

    @Override
    public CteStorage getCteStorage() {
        return new CteFileSystemStorage();
    }
}
