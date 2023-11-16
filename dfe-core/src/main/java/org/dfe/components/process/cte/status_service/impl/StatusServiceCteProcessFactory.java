package org.dfe.components.process.cte.status_service.impl;

import br.inf.portalfiscal.cte.send.TConsStatServ;
import br.inf.portalfiscal.cte.send.TRetConsStatServ;
import org.dfe.components.process.cte.status_service.impl.file.FileSystemStatusServiceCteFactory;
import org.dfe.components.process.cte.status_service.impl.nostore.NoStoreStatusServiceCteFactory;
import org.dfe.components.process.cte.status_service.impl.s3.S3StoreStatusServiceCteFactory;
import org.dfe.interfaces.process.ProcessFactory;
import org.dfe.interfaces.process.cte.status_service.AfterStatusService;
import org.dfe.interfaces.process.cte.status_service.BeforeStatusService;

import java.util.Collection;

public abstract class StatusServiceCteProcessFactory implements ProcessFactory<TConsStatServ, TRetConsStatServ> {

    public static StatusServiceCteProcessFactory noStore() {
        return Holder.NOSTORE;
    }

    public static StatusServiceCteProcessFactory fileStore() {
        return Holder.FILESYSTEM;
    }

    public static StatusServiceCteProcessFactory s3() {
        return HolderS3.INSTANCE;
    }

    public abstract Collection<BeforeStatusService> before();

    public abstract Collection<AfterStatusService> after();

    final static class HolderS3 {
        final static StatusServiceCteProcessFactory INSTANCE = new S3StoreStatusServiceCteFactory();
    }

    final static class Holder {
        final static StatusServiceCteProcessFactory NOSTORE = new NoStoreStatusServiceCteFactory();
        final static StatusServiceCteProcessFactory FILESYSTEM = new FileSystemStatusServiceCteFactory();
    }
}
