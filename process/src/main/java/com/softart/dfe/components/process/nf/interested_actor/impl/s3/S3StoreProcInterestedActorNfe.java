package com.softart.dfe.components.process.nf.interested_actor.impl.s3;

import com.softart.dfe.components.process.nf.interested_actor.StoreProcInterestedActorNfe;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.nf.NfeInterestedActorStorage;

final class S3StoreProcInterestedActorNfe extends StoreProcInterestedActorNfe {
    @Override
    public NfeInterestedActorStorage getStorage() {
        return StorageFactory.s3().getNfeStorage();
    }
}
