package org.dfe.components.process.nf.interested_actor.impl.nostore;

import org.dfe.components.process.nf.interested_actor.StoreProcInterestedActorNfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.nf.NfeInterestedActorStorage;

final class NoStoreProcInterestedActorNfe extends StoreProcInterestedActorNfe {
    @Override
    public NfeInterestedActorStorage getStorage() {
        return StorageFactory.noStorage().getNfeStorage();
    }
}
