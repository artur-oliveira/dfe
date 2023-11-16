package org.dfe.components.storage;

import org.dfe.interfaces.storage.StorageService;

public abstract class StorageServiceFactory implements StorageService {

    public static StorageServiceFactory file() {
        return Holder.FILE;
    }

    public static StorageServiceFactory s3() {
        return HolderS3.S3;
    }

    private final static class HolderS3 {
        private static final StorageServiceFactory S3 = new S3StorageService();
    }

    private final static class Holder {
        private static final StorageServiceFactory FILE = new FileSystemStorageService();
    }
}
