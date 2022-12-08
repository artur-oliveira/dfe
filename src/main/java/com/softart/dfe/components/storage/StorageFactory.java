package com.softart.dfe.components.storage;

import com.softart.dfe.interfaces.storage.cte.CteStorage;
import com.softart.dfe.interfaces.storage.nf.NfceStorage;
import com.softart.dfe.interfaces.storage.nf.NfeStorage;

public abstract class StorageFactory {

    public static StorageFactory noStorage() {
        return new NoStorageFactory();
    }

    public static StorageFactory fileSystem() {
        return new FileSystemStorageFactory();
    }

    public abstract NfeStorage getNfeStorage();

    public abstract NfceStorage getNfceStorage();

    public abstract CteStorage getCteStorage();

}
