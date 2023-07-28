package com.softart.dfe.components.process.mdfe.event.impl;

import br.inf.portalfiscal.mdfe.classes.TEvento;
import br.inf.portalfiscal.mdfe.classes.TRetEvento;
import com.softart.dfe.components.process.mdfe.event.impl.file.FileSystemStoreEventMdfeFactory;
import com.softart.dfe.components.process.mdfe.event.impl.nostore.NoStoreEventMdfeFactory;
import com.softart.dfe.components.process.mdfe.event.impl.s3.S3StoreEventMdfeFactory;
import com.softart.dfe.interfaces.process.ProcessFactory;
import com.softart.dfe.interfaces.process.mdfe.event.AfterEvent;
import com.softart.dfe.interfaces.process.mdfe.event.BeforeEvent;

import java.util.Collection;

public abstract class EventMdfeProcessFactory implements ProcessFactory<TEvento, TRetEvento> {

    public static EventMdfeProcessFactory noStore() {
        return Holder.NOSTORE;
    }

    public static EventMdfeProcessFactory fileStore() {
        return Holder.FILESYSTEM;
    }

    public static EventMdfeProcessFactory s3() {
        return HolderS3.INSTANCE;
    }

    public abstract Collection<BeforeEvent> before();

    public abstract Collection<AfterEvent> after();

    final static class HolderS3 {
        final static EventMdfeProcessFactory INSTANCE = new S3StoreEventMdfeFactory();
    }

    final static class Holder {
        final static EventMdfeProcessFactory NOSTORE = new NoStoreEventMdfeFactory();
        final static EventMdfeProcessFactory FILESYSTEM = new FileSystemStoreEventMdfeFactory();
    }

}
