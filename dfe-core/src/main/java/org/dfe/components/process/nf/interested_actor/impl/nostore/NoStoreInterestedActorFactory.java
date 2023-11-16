package org.dfe.components.process.nf.interested_actor.impl.nostore;

import org.dfe.components.process.nf.interested_actor.impl.InterestedActorProcessFactory;
import org.dfe.interfaces.process.nf.interested_actor.AfterInterestedActor;
import org.dfe.interfaces.process.nf.interested_actor.BeforeInterestedActor;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public final class NoStoreInterestedActorFactory extends InterestedActorProcessFactory {

    @Override
    public Collection<BeforeInterestedActor> before() {
        return Collections.singletonList(
                new NoStoreSendInterestedActorNfe()
        );
    }

    @Override
    public Collection<AfterInterestedActor> after() {
        return Arrays.asList(
                new NoStoreRetInterestedActorNfe(),
                new NoStoreProcInterestedActorNfe()
        );
    }


}
