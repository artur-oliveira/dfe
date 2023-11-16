package org.dfe.components.process.nf.epec.impl;

import br.inf.portalfiscal.nfe.event_epec.TEnvEvento;
import br.inf.portalfiscal.nfe.event_epec.TRetEnvEvento;
import org.dfe.components.process.nf.epec.impl.file.FileStoreEpecFactory;
import org.dfe.components.process.nf.epec.impl.nostore.NoStoreEpecFactory;
import org.dfe.components.process.nf.epec.impl.s3.S3StoreFactory;
import org.dfe.interfaces.process.ProcessFactory;
import org.dfe.interfaces.process.nf.epec.AfterEpec;
import org.dfe.interfaces.process.nf.epec.BeforeEpec;

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
