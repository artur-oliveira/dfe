package org.dfe.components.process.nf.interested_actor.impl.nostore;

import org.dfe.components.process.nf.interested_actor.StoreSendInterestedActorNfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.nf.NfeInterestedActorStorage;

final class NoStoreSendInterestedActorNfe extends StoreSendInterestedActorNfe {
    @Override
    public NfeInterestedActorStorage getStorage() {
        return StorageFactory.noStorage().getNfeStorage();
    }
}
