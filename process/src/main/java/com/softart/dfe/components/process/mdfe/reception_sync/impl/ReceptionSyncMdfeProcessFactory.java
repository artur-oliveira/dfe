package com.softart.dfe.components.process.mdfe.reception_sync.impl;

import br.inf.portalfiscal.mdfe.classes.TMDFe;
import br.inf.portalfiscal.mdfe.classes.TRetMDFe;
import com.softart.dfe.components.process.mdfe.reception_sync.impl.file.FileSystemStoreReceptionSyncMdfeFactory;
import com.softart.dfe.components.process.mdfe.reception_sync.impl.nostore.NoStoreReceptionSyncMdfeFactory;
import com.softart.dfe.components.process.mdfe.reception_sync.impl.s3.S3StoreReceptionSyncMdfeFactory;
import com.softart.dfe.interfaces.process.ProcessFactory;
import com.softart.dfe.interfaces.process.mdfe.reception_sync.AfterReceptionSync;
import com.softart.dfe.interfaces.process.mdfe.reception_sync.BeforeReceptionSync;

import java.util.Collection;

public abstract class ReceptionSyncMdfeProcessFactory implements ProcessFactory<TMDFe, TRetMDFe> {

    public static ReceptionSyncMdfeProcessFactory noStore() {
        return Holder.NOSTORE;
    }

    public static ReceptionSyncMdfeProcessFactory fileStore() {
        return Holder.FILESYSTEM;
    }

    public static ReceptionSyncMdfeProcessFactory s3() {
        return HolderS3.INSTANCE;
    }

    public abstract Collection<BeforeReceptionSync> before();

    public abstract Collection<AfterReceptionSync> after();

    final static class HolderS3 {
        final static ReceptionSyncMdfeProcessFactory INSTANCE = new S3StoreReceptionSyncMdfeFactory();
    }

    final static class Holder {
        final static ReceptionSyncMdfeProcessFactory NOSTORE = new NoStoreReceptionSyncMdfeFactory();
        final static ReceptionSyncMdfeProcessFactory FILESYSTEM = new FileSystemStoreReceptionSyncMdfeFactory();
    }

}
