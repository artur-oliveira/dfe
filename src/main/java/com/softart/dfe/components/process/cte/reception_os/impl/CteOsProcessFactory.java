package com.softart.dfe.components.process.cte.reception_os.impl;

import br.inf.portalfiscal.cte.send.TCTeOS;
import br.inf.portalfiscal.cte.send.TRetCTeOS;
import com.softart.dfe.components.process.cte.reception_os.impl.CteOsProcessFactory;
import com.softart.dfe.components.process.cte.reception_os.impl.file.FileSystemCteOsFactory;
import com.softart.dfe.components.process.cte.reception_os.impl.nostore.NoStoreCteOsFactory;
import com.softart.dfe.components.process.cte.reception_sync.impl.file.FileSystemCteFactory;
import com.softart.dfe.components.process.cte.reception_sync.impl.nostore.NoStoreCteFactory;
import com.softart.dfe.interfaces.process.ProcessFactory;
import com.softart.dfe.interfaces.process.cte.reception_os.AfterReceptionCteOs;
import com.softart.dfe.interfaces.process.cte.reception_os.BeforeReceptionCteOs;

import java.util.Collection;

public abstract class CteOsProcessFactory implements ProcessFactory<TCTeOS, TRetCTeOS> {

    public static CteOsProcessFactory noStore() {
        return CteOsProcessFactory.Holder.NOSTORE;
    }

    public static CteOsProcessFactory fileStore() {
        return CteOsProcessFactory.Holder.FILESYSTEM;
    }

    final static class Holder {
        final static CteOsProcessFactory NOSTORE = new NoStoreCteOsFactory();
        final static CteOsProcessFactory FILESYSTEM = new FileSystemCteOsFactory();
    }

    public abstract Collection<BeforeReceptionCteOs> before();

    public abstract Collection<AfterReceptionCteOs> after();
}
