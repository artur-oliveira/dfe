package com.softart.dfe.components.process.nf.cancel.impl;

import br.inf.portalfiscal.nfe.event_cancel.TEnvEvento;
import br.inf.portalfiscal.nfe.event_cancel.TRetEnvEvento;
import com.softart.dfe.components.process.nf.cancel.impl.file.FileStoreFactory;
import com.softart.dfe.components.process.nf.cancel.impl.nostore.NoStoreFactory;
import com.softart.dfe.components.process.nf.cancel.impl.s3.S3StoreFactory;
import com.softart.dfe.interfaces.process.ProcessFactory;
import com.softart.dfe.interfaces.process.nf.cancel.AfterCancel;
import com.softart.dfe.interfaces.process.nf.cancel.BeforeCancel;

import java.util.Collection;

public abstract class CancelProcessFactory implements ProcessFactory<TEnvEvento, TRetEnvEvento> {

    public static CancelProcessFactory noStore() {
        return Holder.NO_STORE;
    }

    public static CancelProcessFactory fileStore() {
        return Holder.FILE_STORE;
    }

    public static CancelProcessFactory s3() {
        return HolderS3.S3;
    }

    public abstract Collection<AfterCancel> after();

    public abstract Collection<BeforeCancel> before();

    private final static class HolderS3 {
        private final static CancelProcessFactory S3 = new S3StoreFactory();
    }

    private final static class Holder {
        private final static CancelProcessFactory NO_STORE = new NoStoreFactory();
        private final static CancelProcessFactory FILE_STORE = new FileStoreFactory();
    }
}
