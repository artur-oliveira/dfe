package org.dfe.components.process.nf.inut.impl;

import br.inf.portalfiscal.nfe.send.TInutNFe;
import br.inf.portalfiscal.nfe.send.TRetInutNFe;
import org.dfe.components.process.nf.inut.impl.file.FileStoreFactory;
import org.dfe.components.process.nf.inut.impl.nostore.NoStoreFactory;
import org.dfe.components.process.nf.inut.impl.s3.S3StoreFactory;
import org.dfe.interfaces.process.ProcessFactory;
import org.dfe.interfaces.process.nf.inut.AfterInut;
import org.dfe.interfaces.process.nf.inut.BeforeInut;

import java.util.Collection;

public abstract class InutilizationProcessFactory implements ProcessFactory<TInutNFe, TRetInutNFe> {

    public static InutilizationProcessFactory noStore() {
        return Holder.NO_STORE;
    }

    public static InutilizationProcessFactory fileStore() {
        return Holder.FILE_STORE;
    }

    public static InutilizationProcessFactory s3() {
        return HolderS3.S3;
    }

    public abstract Collection<AfterInut> after();

    public abstract Collection<BeforeInut> before();

    private final static class HolderS3 {
        private final static InutilizationProcessFactory S3 = new S3StoreFactory();
    }

    private final static class Holder {
        private final static InutilizationProcessFactory NO_STORE = new NoStoreFactory();
        private final static InutilizationProcessFactory FILE_STORE = new FileStoreFactory();
    }
}
