package org.dfe.components.process.nf.interested_actor.impl.file;

import org.dfe.components.process.nf.interested_actor.StoreSendInterestedActorNfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.nf.NfeInterestedActorStorage;

final class FileStoreSendInterestedActorNfe extends StoreSendInterestedActorNfe {
    @Override
    public NfeInterestedActorStorage getStorage() {
        return StorageFactory.fileSystem().getNfeStorage();
    }
}
