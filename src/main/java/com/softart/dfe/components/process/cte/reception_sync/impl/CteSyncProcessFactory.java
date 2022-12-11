package com.softart.dfe.components.process.cte.reception_sync.impl;

import br.inf.portalfiscal.cte.send.TCTe;
import br.inf.portalfiscal.cte.send.TRetCTe;
import com.softart.dfe.components.process.cte.reception_sync.impl.file.FileSystemCteFactory;
import com.softart.dfe.components.process.cte.reception_sync.impl.nostore.NoStoreCteFactory;
import com.softart.dfe.interfaces.process.ProcessFactory;
import com.softart.dfe.interfaces.process.cte.reception_sync.AfterReceptionCteSync;
import com.softart.dfe.interfaces.process.cte.reception_sync.BeforeReceptionCteSync;

import java.util.Collection;

public abstract class CteSyncProcessFactory implements ProcessFactory<TCTe, TRetCTe> {

    public static CteSyncProcessFactory noStore() {
        return CteSyncProcessFactory.Holder.NOSTORE;
    }

    public static CteSyncProcessFactory fileStore() {
        return CteSyncProcessFactory.Holder.FILESYSTEM;
    }

    final static class Holder {
        final static CteSyncProcessFactory NOSTORE = new NoStoreCteFactory();
        final static CteSyncProcessFactory FILESYSTEM = new FileSystemCteFactory();
    }

    public abstract Collection<BeforeReceptionCteSync> before();

    public abstract Collection<AfterReceptionCteSync> after();
}
