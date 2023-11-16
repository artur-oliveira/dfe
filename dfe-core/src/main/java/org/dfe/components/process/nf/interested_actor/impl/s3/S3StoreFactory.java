package org.dfe.components.process.nf.interested_actor.impl.s3;

import org.dfe.components.process.nf.interested_actor.impl.InterestedActorProcessFactory;
import org.dfe.interfaces.process.nf.interested_actor.AfterInterestedActor;
import org.dfe.interfaces.process.nf.interested_actor.BeforeInterestedActor;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public final class S3StoreFactory extends InterestedActorProcessFactory {

    @Override
    public Collection<BeforeInterestedActor> before() {
        return Collections.singletonList(
                new S3StoreSendInterestedActorNfe()
        );
    }

    @Override
    public Collection<AfterInterestedActor> after() {
        return Arrays.asList(
                new S3StoreRetInterestedActorNfe(),
                new S3StoreProcInterestedActorNfe()
        );
    }


}
