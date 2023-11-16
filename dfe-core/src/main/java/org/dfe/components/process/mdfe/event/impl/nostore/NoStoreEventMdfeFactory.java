package org.dfe.components.process.mdfe.event.impl.nostore;

import org.dfe.components.process.mdfe.event.impl.EventMdfeProcessFactory;
import org.dfe.interfaces.process.mdfe.event.AfterEvent;
import org.dfe.interfaces.process.mdfe.event.BeforeEvent;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public final class NoStoreEventMdfeFactory extends EventMdfeProcessFactory {

    private final Collection<AfterEvent> after = Arrays.asList(new NoStoreReturnEventMdfe(), new NoStoreProcEventMdfe());
    private final Collection<BeforeEvent> before = Collections.singletonList(new NoStoreEventMdfe());


    @Override
    public Collection<BeforeEvent> before() {
        return before;
    }

    @Override
    public Collection<AfterEvent> after() {
        return after;
    }
}
