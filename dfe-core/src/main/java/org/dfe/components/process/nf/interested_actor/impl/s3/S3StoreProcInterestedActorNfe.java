package org.dfe.components.process.nf.interested_actor.impl.s3;

import org.dfe.components.process.nf.interested_actor.StoreProcInterestedActorNfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.nf.NfeInterestedActorStorage;

final class S3StoreProcInterestedActorNfe extends StoreProcInterestedActorNfe {
    @Override
    public NfeInterestedActorStorage getStorage() {
        return StorageFactory.s3().getNfeStorage();
    }
}
