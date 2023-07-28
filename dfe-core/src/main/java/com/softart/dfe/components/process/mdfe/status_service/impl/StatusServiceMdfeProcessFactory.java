package com.softart.dfe.components.process.mdfe.status_service.impl;

import br.inf.portalfiscal.mdfe.classes.TConsStatServ;
import br.inf.portalfiscal.mdfe.classes.TRetConsStatServ;
import com.softart.dfe.components.process.mdfe.status_service.impl.file.FileSystemStoreStatusServiceMdfeFactory;
import com.softart.dfe.components.process.mdfe.status_service.impl.nostore.NoStoreStatusServiceMdfeFactory;
import com.softart.dfe.components.process.mdfe.status_service.impl.s3.S3StoreStatusServiceMdfeFactory;
import com.softart.dfe.interfaces.process.ProcessFactory;
import com.softart.dfe.interfaces.process.mdfe.status_service.AfterStatusService;
import com.softart.dfe.interfaces.process.mdfe.status_service.BeforeStatusService;

import java.util.Collection;

public abstract class StatusServiceMdfeProcessFactory implements ProcessFactory<TConsStatServ, TRetConsStatServ> {

    public static StatusServiceMdfeProcessFactory noStore() {
        return Holder.NOSTORE;
    }

    public static StatusServiceMdfeProcessFactory fileStore() {
        return Holder.FILESYSTEM;
    }

    public static StatusServiceMdfeProcessFactory s3() {
        return HolderS3.INSTANCE;
    }

    public abstract Collection<BeforeStatusService> before();

    public abstract Collection<AfterStatusService> after();

    final static class HolderS3 {
        final static StatusServiceMdfeProcessFactory INSTANCE = new S3StoreStatusServiceMdfeFactory();
    }

    final static class Holder {
        final static StatusServiceMdfeProcessFactory NOSTORE = new NoStoreStatusServiceMdfeFactory();
        final static StatusServiceMdfeProcessFactory FILESYSTEM = new FileSystemStoreStatusServiceMdfeFactory();
    }
}
