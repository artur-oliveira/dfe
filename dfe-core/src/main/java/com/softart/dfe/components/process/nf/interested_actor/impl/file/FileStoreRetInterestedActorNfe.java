package com.softart.dfe.components.process.nf.interested_actor.impl.file;

import com.softart.dfe.components.process.nf.interested_actor.StoreRetInterestedActorNfe;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.nf.NfeInterestedActorStorage;

final class FileStoreRetInterestedActorNfe extends StoreRetInterestedActorNfe {
    @Override
    public NfeInterestedActorStorage getStorage() {
        return StorageFactory.fileSystem().getNfeStorage();
    }
}
