package com.softart.dfe.components.process.cte.status_service.impl;

import br.inf.portalfiscal.cte.send.TConsStatServ;
import br.inf.portalfiscal.cte.send.TRetConsStatServ;
import com.softart.dfe.components.process.cte.status_service.impl.file.FileSystemStatusServiceCteFactory;
import com.softart.dfe.components.process.cte.status_service.impl.nostore.NoStoreStatusServiceCteFactory;
import com.softart.dfe.interfaces.process.ProcessFactory;
import com.softart.dfe.interfaces.process.cte.status_service.AfterStatusService;
import com.softart.dfe.interfaces.process.cte.status_service.BeforeStatusService;

import java.util.Collection;

public abstract class StatusServiceCteProcessFactory implements ProcessFactory<TConsStatServ, TRetConsStatServ> {

    public static StatusServiceCteProcessFactory noStore() {
        return Holder.NOSTORE;
    }

    public static StatusServiceCteProcessFactory fileStore() {
        return Holder.FILESYSTEM;
    }

    public abstract Collection<BeforeStatusService> before();

    public abstract Collection<AfterStatusService> after();

    final static class Holder {
        final static StatusServiceCteProcessFactory NOSTORE = new NoStoreStatusServiceCteFactory();
        final static StatusServiceCteProcessFactory FILESYSTEM = new FileSystemStatusServiceCteFactory();
    }
}
