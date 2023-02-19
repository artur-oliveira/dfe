package com.softart.dfe.components.storage;

import com.softart.dfe.interfaces.storage.cte.CteStorage;
import com.softart.dfe.interfaces.storage.mdfe.MdfeStorage;
import com.softart.dfe.interfaces.storage.nf.NfceStorage;
import com.softart.dfe.interfaces.storage.nf.NfeStorage;
import com.softart.dfe.util.ReflectionUtils;
import com.softart.dfe.util.RequireUtils;

public abstract class StorageFactory {
    public static final String DEFAULT_STORAGE_FACTORY = System.getProperty("com.softart.dfe.storage.default", "filesystem");

    public static StorageFactory getInstance() {
        switch (DEFAULT_STORAGE_FACTORY) {
            case "s3":
                return RequireUtils.nonNull(Holder.S3, "com.softart.dfe.components.storage.S3StorageFactory is not initialized");
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
        return Holder.S3;
    }

    public abstract NfeStorage getNfeStorage();

    public abstract NfceStorage getNfceStorage();

    public abstract CteStorage getCteStorage();

    public abstract MdfeStorage getMdfeStorage();

    private static final class Holder {
        static final StorageFactory NO_STORAGE = new NoStorageFactory();
        static final StorageFactory FILE_SYSTEM = new FileSystemStorageFactory();
        static final StorageFactory S3 = ReflectionUtils.safeNewInstance("com.softart.dfe.components.storage.S3StorageFactory");
    }

}
