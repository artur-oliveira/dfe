package com.softart.dfe.components.process.cte4.reception_sync.impl;

import br.inf.portalfiscal.cte.send400.TCTe;
import br.inf.portalfiscal.cte.send400.TRetCTe;
import com.softart.dfe.components.process.cte4.reception_sync.impl.file.FileSystemCteFactory;
import com.softart.dfe.components.process.cte4.reception_sync.impl.nostore.NoStoreCteFactory;
import com.softart.dfe.components.process.cte4.reception_sync.impl.s3.S3StoreCteFactory;
import com.softart.dfe.interfaces.process.ProcessFactory;
import com.softart.dfe.interfaces.process.cte4.reception_sync.AfterReceptionCteSync;
import com.softart.dfe.interfaces.process.cte4.reception_sync.BeforeReceptionCteSync;

import java.util.Collection;

public abstract class CteSyncProcessFactory implements ProcessFactory<TCTe, TRetCTe> {

    public static CteSyncProcessFactory noStore() {
        return Holder.NOSTORE;
    }

    public static CteSyncProcessFactory fileStore() {
        return Holder.FILESYSTEM;
    }

    public static CteSyncProcessFactory s3() {
        return HolderS3.INSTANCE;
    }

    public abstract Collection<BeforeReceptionCteSync> before();

    public abstract Collection<AfterReceptionCteSync> after();

    final static class HolderS3 {
        final static CteSyncProcessFactory INSTANCE = new S3StoreCteFactory();
    }

    final static class Holder {
        final static CteSyncProcessFactory NOSTORE = new NoStoreCteFactory();
        final static CteSyncProcessFactory FILESYSTEM = new FileSystemCteFactory();
    }
}
