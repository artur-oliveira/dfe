package com.softart.dfe.components.process.nf.interested_actor.impl.s3;

import com.softart.dfe.components.process.nf.interested_actor.StoreSendInterestedActorNfe;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.nf.NfeInterestedActorStorage;

final class S3StoreSendInterestedActorNfe extends StoreSendInterestedActorNfe {
    @Override
    public NfeInterestedActorStorage getStorage() {
        return StorageFactory.s3().getNfeStorage();
    }
}
