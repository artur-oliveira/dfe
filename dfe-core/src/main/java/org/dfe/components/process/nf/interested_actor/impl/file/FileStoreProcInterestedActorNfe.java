package org.dfe.components.process.nf.interested_actor.impl.file;

import org.dfe.components.process.nf.interested_actor.StoreProcInterestedActorNfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.nf.NfeInterestedActorStorage;

final class FileStoreProcInterestedActorNfe extends StoreProcInterestedActorNfe {
    @Override
    public NfeInterestedActorStorage getStorage() {
        return StorageFactory.fileSystem().getNfeStorage();
    }
}
