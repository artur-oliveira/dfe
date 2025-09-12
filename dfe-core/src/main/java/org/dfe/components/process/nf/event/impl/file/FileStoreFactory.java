package org.dfe.components.process.nf.event.impl.file;

import org.dfe.components.process.nf.event.impl.EventProcessFactory;
import org.dfe.interfaces.process.nf.event.AfterEvent;
import org.dfe.interfaces.process.nf.event.BeforeEvent;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public final class FileStoreFactory extends EventProcessFactory {

    @Override
    public Collection<BeforeEvent> before() {
        return Collections.singletonList(
                new FileStoreEventNfe()
        );
    }

    @Override
    public Collection<AfterEvent> after() {
        return Arrays.asList(
                new FileStoreRetEventNfe(),
                new FileStoreProcEventNfe()
        );
    }


}
