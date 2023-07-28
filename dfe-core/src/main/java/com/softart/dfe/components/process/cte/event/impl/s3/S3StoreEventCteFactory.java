package com.softart.dfe.components.process.cte.event.impl.s3;

import com.softart.dfe.components.process.cte.event.impl.EventCteProcessFactory;
import com.softart.dfe.interfaces.process.cte.event.AfterEvent;
import com.softart.dfe.interfaces.process.cte.event.BeforeEvent;

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
