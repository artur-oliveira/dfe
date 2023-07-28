package com.softart.dfe.components.process.nf.interested_actor.impl.nostore;

import com.softart.dfe.components.process.nf.interested_actor.StoreProcInterestedActorNfe;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.nf.NfeInterestedActorStorage;

final class NoStoreProcInterestedActorNfe extends StoreProcInterestedActorNfe {
    @Override
    public NfeInterestedActorStorage getStorage() {
        return StorageFactory.noStorage().getNfeStorage();
    }
}
