package com.softart.dfe.components.process.nf.interested_actor.impl.file;

import com.softart.dfe.components.process.nf.interested_actor.impl.InterestedActorProcessFactory;
import com.softart.dfe.interfaces.process.nf.interested_actor.AfterInterestedActor;
import com.softart.dfe.interfaces.process.nf.interested_actor.BeforeInterestedActor;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public final class FileStoreInterestedActorFactory extends InterestedActorProcessFactory {

    @Override
    public Collection<BeforeInterestedActor> before() {
        return Collections.singletonList(
                new FileStoreSendInterestedActorNfe()
        );
    }

    @Override
    public Collection<AfterInterestedActor> after() {
        return Arrays.asList(
                new FileStoreRetInterestedActorNfe(),
                new FileStoreProcInterestedActorNfe()
        );
    }


}
