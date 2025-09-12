package org.dfe.components.process.nf.event.impl.nostore;

import org.dfe.components.process.nf.event.impl.EventProcessFactory;
import org.dfe.interfaces.process.nf.event.AfterEvent;
import org.dfe.interfaces.process.nf.event.BeforeEvent;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public final class NoStoreFactory extends EventProcessFactory {

    @Override
    public Collection<BeforeEvent> before() {
        return Collections.singletonList(
                new NoStoreEventNfe()
        );
    }

    @Override
    public Collection<AfterEvent> after() {
        return Arrays.asList(
                new NoStoreRetEventNfe(),
                new NoStoreProcEventNfe()
        );
    }


}
