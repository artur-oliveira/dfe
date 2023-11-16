package org.dfe.components.process.cte.reception_sync.impl;

import br.inf.portalfiscal.cte.send.TCTe;
import br.inf.portalfiscal.cte.send.TRetCTe;
import org.dfe.components.process.cte.reception_sync.impl.file.FileSystemCteFactory;
import org.dfe.components.process.cte.reception_sync.impl.nostore.NoStoreCteFactory;
import org.dfe.components.process.cte.reception_sync.impl.s3.S3StoreCteFactory;
import org.dfe.interfaces.process.ProcessFactory;
import org.dfe.interfaces.process.cte.reception_sync.AfterReceptionCteSync;
import org.dfe.interfaces.process.cte.reception_sync.BeforeReceptionCteSync;

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
