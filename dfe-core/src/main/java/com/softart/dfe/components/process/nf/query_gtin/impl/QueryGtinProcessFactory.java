package com.softart.dfe.components.process.nf.query_gtin.impl;

import br.inf.portalfiscal.nfe.gtin.TConsGTIN;
import br.inf.portalfiscal.nfe.gtin.TRetConsGTIN;
import com.softart.dfe.components.process.nf.query_gtin.impl.file.FileStoreFactory;
import com.softart.dfe.components.process.nf.query_gtin.impl.nostore.NoStoreFactory;
import com.softart.dfe.components.process.nf.query_gtin.impl.s3.S3StoreFactory;
import com.softart.dfe.interfaces.process.ProcessFactory;
import com.softart.dfe.interfaces.process.nf.query_gtin.AfterQueryGtin;
import com.softart.dfe.interfaces.process.nf.query_gtin.BeforeQueryGtin;

import java.util.Collection;

public abstract class QueryGtinProcessFactory implements ProcessFactory<TConsGTIN, TRetConsGTIN> {

    public static QueryGtinProcessFactory noStore() {
        return Holder.NO_STORE;
    }

    public static QueryGtinProcessFactory fileStore() {
        return Holder.FILE_STORE;
    }

    public static QueryGtinProcessFactory s3() {
        return HolderS3.S3;
    }

    public abstract Collection<AfterQueryGtin> after();

    public abstract Collection<BeforeQueryGtin> before();

    private final static class HolderS3 {
        private final static QueryGtinProcessFactory S3 = new S3StoreFactory();
    }

    private final static class Holder {
        private final static QueryGtinProcessFactory NO_STORE = new NoStoreFactory();
        private final static QueryGtinProcessFactory FILE_STORE = new FileStoreFactory();
    }
}
