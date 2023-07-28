package com.softart.dfe.components.process.cte.reception_gtve.impl;

import br.inf.portalfiscal.cte.send.TGTVe;
import br.inf.portalfiscal.cte.send.TRetGTVe;
import com.softart.dfe.components.process.cte.reception_gtve.impl.file.FileSystemGtveFactory;
import com.softart.dfe.components.process.cte.reception_gtve.impl.nostore.NoStoreGtveFactory;
import com.softart.dfe.components.process.cte.reception_gtve.impl.s3.S3StoreGtveFactory;
import com.softart.dfe.interfaces.process.ProcessFactory;
import com.softart.dfe.interfaces.process.cte.reception_gtve.AfterReceptionGtve;
import com.softart.dfe.interfaces.process.cte.reception_gtve.BeforeReceptionGtve;

import java.util.Collection;

public abstract class GtveProcessFactory implements ProcessFactory<TGTVe, TRetGTVe> {

    public static GtveProcessFactory noStore() {
        return Holder.NOSTORE;
    }

    public static GtveProcessFactory fileStore() {
        return Holder.FILESYSTEM;
    }

    public static GtveProcessFactory s3() {
        return HolderS3.INSTANCE;
    }

    public abstract Collection<BeforeReceptionGtve> before();

    public abstract Collection<AfterReceptionGtve> after();

    final static class HolderS3 {
        final static GtveProcessFactory INSTANCE = new S3StoreGtveFactory();
    }

    final static class Holder {
        final static GtveProcessFactory NOSTORE = new NoStoreGtveFactory();
        final static GtveProcessFactory FILESYSTEM = new FileSystemGtveFactory();
    }
}
