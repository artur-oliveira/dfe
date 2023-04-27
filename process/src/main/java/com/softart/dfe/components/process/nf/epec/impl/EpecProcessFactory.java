package com.softart.dfe.components.process.nf.epec.impl;

import br.inf.portalfiscal.nfe.event_epec.TEnvEvento;
import br.inf.portalfiscal.nfe.event_epec.TRetEnvEvento;
import com.softart.dfe.components.process.nf.epec.impl.file.FileStoreEpecFactory;
import com.softart.dfe.components.process.nf.epec.impl.nostore.NoStoreEpecFactory;
import com.softart.dfe.components.process.nf.epec.impl.s3.S3StoreFactory;
import com.softart.dfe.interfaces.process.ProcessFactory;
import com.softart.dfe.interfaces.process.nf.epec.AfterEpec;
import com.softart.dfe.interfaces.process.nf.epec.BeforeEpec;

import java.util.Collection;

public abstract class EpecProcessFactory implements ProcessFactory<TEnvEvento, TRetEnvEvento> {

    public static EpecProcessFactory noStore() {
        return Holder.NO_STORE;
    }

    public static EpecProcessFactory fileStore() {
        return Holder.FILE_STORE;
    }

    public static EpecProcessFactory s3() {
        return HolderS3.S3;
    }

    public abstract Collection<AfterEpec> after();

    public abstract Collection<BeforeEpec> before();

    private final static class HolderS3 {
        private final static EpecProcessFactory S3 = new S3StoreFactory();
    }

    private final static class Holder {
        private final static EpecProcessFactory NO_STORE = new NoStoreEpecFactory();
        private final static EpecProcessFactory FILE_STORE = new FileStoreEpecFactory();
    }
}
