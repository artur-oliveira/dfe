package org.dfe.components.process.cte4.event.impl.s3;

import org.dfe.components.process.cte4.event.impl.EventCteProcessFactory;
import org.dfe.interfaces.process.cte4.event.AfterEvent;
import org.dfe.interfaces.process.cte4.event.BeforeEvent;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public final class S3StoreEventCteFactory extends EventCteProcessFactory {

    @Override
    public Collection<BeforeEvent> before() {
        return Collections.singletonList(new S3StoreEventCte());
    }

    @Override
    public Collection<AfterEvent> after() {
        return Arrays.asList(new S3StoreReturnEventCte(), new S3StoreProcEventCte());
    }
}
