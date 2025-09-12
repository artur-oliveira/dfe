package org.dfe.components.process.nf.event.impl;

import br.inf.portalfiscal.nfe.event_generic.TEnvEvento;
import br.inf.portalfiscal.nfe.event_generic.TRetEnvEvento;
import org.dfe.components.process.nf.event.impl.file.FileStoreFactory;
import org.dfe.components.process.nf.event.impl.nostore.NoStoreFactory;
import org.dfe.components.process.nf.event.impl.s3.S3StoreFactory;
import org.dfe.interfaces.process.ProcessFactory;
import org.dfe.interfaces.process.nf.event.AfterEvent;
import org.dfe.interfaces.process.nf.event.BeforeEvent;

import java.util.Collection;

public abstract class EventProcessFactory implements ProcessFactory<TEnvEvento, TRetEnvEvento> {

    public static EventProcessFactory noStore() {
        return Holder.NO_STORE;
    }

    public static EventProcessFactory fileStore() {
        return Holder.FILE_STORE;
    }

    public static EventProcessFactory s3() {
        return HolderS3.S3;
    }

    public abstract Collection<AfterEvent> after();

    public abstract Collection<BeforeEvent> before();

    private final static class HolderS3 {
        private final static EventProcessFactory S3 = new S3StoreFactory();
    }

    private final static class Holder {
        private final static EventProcessFactory NO_STORE = new NoStoreFactory();
        private final static EventProcessFactory FILE_STORE = new FileStoreFactory();
    }
}
