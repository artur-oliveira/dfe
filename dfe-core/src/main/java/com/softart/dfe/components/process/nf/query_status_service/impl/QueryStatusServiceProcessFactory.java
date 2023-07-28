package com.softart.dfe.components.process.nf.query_status_service.impl;

import br.inf.portalfiscal.nfe.send.TConsStatServ;
import br.inf.portalfiscal.nfe.send.TRetConsStatServ;
import com.softart.dfe.components.process.nf.query_status_service.impl.file.FileStoreFactory;
import com.softart.dfe.components.process.nf.query_status_service.impl.nostore.NoStoreFactory;
import com.softart.dfe.components.process.nf.query_status_service.impl.s3.S3StoreFactory;
import com.softart.dfe.interfaces.process.ProcessFactory;
import com.softart.dfe.interfaces.process.nf.query_status_service.AfterQueryStatusService;
import com.softart.dfe.interfaces.process.nf.query_status_service.BeforeQueryStatusService;

import java.util.Collection;

public abstract class QueryStatusServiceProcessFactory implements ProcessFactory<TConsStatServ, TRetConsStatServ> {

    public static QueryStatusServiceProcessFactory noStore() {
        return Holder.NO_STORE;
    }

    public static QueryStatusServiceProcessFactory fileStore() {
        return Holder.FILE_STORE;
    }

    public static QueryStatusServiceProcessFactory s3() {
        return HolderS3.S3;
    }

    public abstract Collection<AfterQueryStatusService> after();

    public abstract Collection<BeforeQueryStatusService> before();


    private final static class HolderS3 {
        private final static QueryStatusServiceProcessFactory S3 = new S3StoreFactory();
    }


    private final static class Holder {
        private final static QueryStatusServiceProcessFactory NO_STORE = new NoStoreFactory();
        private final static QueryStatusServiceProcessFactory FILE_STORE = new FileStoreFactory();
    }
}
