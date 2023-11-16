package org.dfe.components.process.mdfe.event.impl.file;

import org.dfe.components.process.mdfe.event.impl.EventMdfeProcessFactory;
import org.dfe.interfaces.process.mdfe.event.AfterEvent;
import org.dfe.interfaces.process.mdfe.event.BeforeEvent;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public final class FileSystemStoreEventMdfeFactory extends EventMdfeProcessFactory {

    private final Collection<AfterEvent> after = Arrays.asList(new FileSystemStoreReturnEventMdfe(), new FileSystemStoreProcEventMdfe());
    private final Collection<BeforeEvent> before = Collections.singletonList(new FileSystemStoreEventMdfe());


    @Override
    public Collection<BeforeEvent> before() {
        return before;
    }

    @Override
    public Collection<AfterEvent> after() {
        return after;
    }
}
