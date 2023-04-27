package com.softart.dfe.components.process.cte.event.impl.nostore;

import com.softart.dfe.components.process.cte.event.impl.EventCteProcessFactory;
import com.softart.dfe.interfaces.process.cte.event.AfterEvent;
import com.softart.dfe.interfaces.process.cte.event.BeforeEvent;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public final class NoStoreEventCteFactory extends EventCteProcessFactory {

    @Override
    public Collection<BeforeEvent> before() {
        return Collections.singletonList(new NoStoreEventCte());
    }

    @Override
    public Collection<AfterEvent> after() {
        return Arrays.asList(new NoStoreReturnEventCte(), new NoStoreProcEventCte());
    }
}
