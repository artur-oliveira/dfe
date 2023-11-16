package org.dfe.components.process.mdfe.event.impl.s3;

import org.dfe.components.process.mdfe.event.impl.EventMdfeProcessFactory;
import org.dfe.interfaces.process.mdfe.event.AfterEvent;
import org.dfe.interfaces.process.mdfe.event.BeforeEvent;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public final class S3StoreEventMdfeFactory extends EventMdfeProcessFactory {

    private final Collection<AfterEvent> after = Arrays.asList(new S3StoreReturnEventMdfe(), new S3StoreProcEventMdfe());
    private final Collection<BeforeEvent> before = Collections.singletonList(new S3StoreEventMdfe());


    @Override
    public Collection<BeforeEvent> before() {
        return before;
    }

    @Override
    public Collection<AfterEvent> after() {
        return after;
    }
}
