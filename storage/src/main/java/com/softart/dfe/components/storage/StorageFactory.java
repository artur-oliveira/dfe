package com.softart.dfe.components.storage;

import com.softart.dfe.interfaces.storage.cte.CteStorage;
import com.softart.dfe.interfaces.storage.mdfe.MdfeStorage;
import com.softart.dfe.interfaces.storage.nf.NfceStorage;
import com.softart.dfe.interfaces.storage.nf.NfeStorage;

public abstract class StorageFactory {
    public static StorageFactory getInstance() {
        switch (System.getProperty("com.softart.dfe.storage.default", "filesystem")) {
            case "s3":
                return HolderS3.S3;
            case "nostorage":
                return Holder.NO_STORAGE;
            case "filesystem":
            default:
                return Holder.FILE_SYSTEM;
        }
    }

    public static StorageFactory noStorage() {
        return Holder.NO_STORAGE;
    }

    public static StorageFactory fileSystem() {
        return Holder.FILE_SYSTEM;
    }

    public static StorageFactory s3() {
        return HolderS3.S3;
    }

    public abstract NfeStorage getNfeStorage();

    public abstract NfceStorage getNfceStorage();

    public abstract CteStorage getCteStorage();

    public abstract MdfeStorage getMdfeStorage();

    private static final class HolderS3 {
        static final StorageFactory S3 = new S3StorageFactory();
    }

    private static final class Holder {
        static final StorageFactory NO_STORAGE = new NoStorageFactory();
        static final StorageFactory FILE_SYSTEM = new FileSystemStorageFactory();
    }

}
