package org.dfe.components.process.cte4.event.impl.nostore;

import org.dfe.components.process.cte4.event.impl.EventCteProcessFactory;
import org.dfe.interfaces.process.cte4.event.AfterEvent;
import org.dfe.interfaces.process.cte4.event.BeforeEvent;

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
