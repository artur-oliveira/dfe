package org.dfe.components.process.nf.event.impl.s3;

import org.dfe.components.process.nf.event.impl.EventProcessFactory;
import org.dfe.interfaces.process.nf.event.AfterEvent;
import org.dfe.interfaces.process.nf.event.BeforeEvent;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

@SuppressWarnings("unused")
public final class S3StoreFactory extends EventProcessFactory {

    @Override
    public Collection<BeforeEvent> before() {
        return Collections.singletonList(
                new S3StoreEventNfe()
        );
    }

    @Override
    public Collection<AfterEvent> after() {
        return Arrays.asList(
                new S3RetEventNfe(),
                new S3ProcEventNfe()
        );
    }


}
