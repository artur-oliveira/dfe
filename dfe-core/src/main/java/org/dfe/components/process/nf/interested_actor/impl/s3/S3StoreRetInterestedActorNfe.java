package org.dfe.components.process.nf.interested_actor.impl.s3;

import org.dfe.components.process.nf.interested_actor.StoreRetInterestedActorNfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.nf.NfeInterestedActorStorage;

final class S3StoreRetInterestedActorNfe extends StoreRetInterestedActorNfe {
    @Override
    public NfeInterestedActorStorage getStorage() {
        return StorageFactory.s3().getNfeStorage();
    }
}
