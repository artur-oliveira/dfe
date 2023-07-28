package com.softart.dfe.components.process.cte4.status_service.impl;

import br.inf.portalfiscal.cte.send400.TConsStatServ;
import br.inf.portalfiscal.cte.send400.TRetConsStatServ;
import com.softart.dfe.components.process.cte4.status_service.impl.file.FileSystemStatusServiceCteFactory;
import com.softart.dfe.components.process.cte4.status_service.impl.nostore.NoStoreStatusServiceCteFactory;
import com.softart.dfe.components.process.cte4.status_service.impl.s3.S3StoreStatusServiceCteFactory;
import com.softart.dfe.interfaces.process.ProcessFactory;
import com.softart.dfe.interfaces.process.cte4.status_service.AfterStatusService;
import com.softart.dfe.interfaces.process.cte4.status_service.BeforeStatusService;

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
