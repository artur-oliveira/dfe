package com.softart.dfe.components.process.cte4.event.impl;

import br.inf.portalfiscal.cte.send400.TEvento;
import br.inf.portalfiscal.cte.send400.TRetEvento;
import com.softart.dfe.components.process.cte4.event.impl.file.FileSystemEventCteFactory;
import com.softart.dfe.components.process.cte4.event.impl.nostore.NoStoreEventCteFactory;
import com.softart.dfe.components.process.cte4.event.impl.s3.S3StoreEventCteFactory;
import com.softart.dfe.interfaces.process.ProcessFactory;
import com.softart.dfe.interfaces.process.cte4.event.AfterEvent;
import com.softart.dfe.interfaces.process.cte4.event.BeforeEvent;

import java.util.Collection;

public abstract class EventCteProcessFactory implements ProcessFactory<TEvento, TRetEvento> {

    public static EventCteProcessFactory noStore() {
        return Holder.NOSTORE;
    }

    public static EventCteProcessFactory fileStore() {
        return Holder.FILESYSTEM;
    }

    public static EventCteProcessFactory s3() {
        return HolderS3.INSTANCE;
    }

    public abstract Collection<BeforeEvent> before();

    public abstract Collection<AfterEvent> after();

    final static class HolderS3 {
        final static EventCteProcessFactory INSTANCE = new S3StoreEventCteFactory();
    }

    final static class Holder {
        final static EventCteProcessFactory NOSTORE = new NoStoreEventCteFactory();
        final static EventCteProcessFactory FILESYSTEM = new FileSystemEventCteFactory();
    }
}
