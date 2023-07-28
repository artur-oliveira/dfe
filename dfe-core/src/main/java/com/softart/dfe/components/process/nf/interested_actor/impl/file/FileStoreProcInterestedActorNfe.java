package com.softart.dfe.components.process.nf.interested_actor.impl.file;

import com.softart.dfe.components.process.nf.interested_actor.StoreProcInterestedActorNfe;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.nf.NfeInterestedActorStorage;

final class FileStoreProcInterestedActorNfe extends StoreProcInterestedActorNfe {
    @Override
    public NfeInterestedActorStorage getStorage() {
        return StorageFactory.fileSystem().getNfeStorage();
    }
}
