package com.softart.dfe.components.process.cte.reception.impl;

import br.inf.portalfiscal.cte.send.TEnviCTe;
import br.inf.portalfiscal.cte.send.TRetEnviCTe;
import com.softart.dfe.components.process.cte.reception.impl.file.FileSystemReceptionCteFactory;
import com.softart.dfe.components.process.cte.reception.impl.nostore.NoStoreReceptionCteFactory;
import com.softart.dfe.components.process.cte.reception.impl.s3.S3StoreReceptionCteFactory;
import com.softart.dfe.interfaces.process.ProcessFactory;
import com.softart.dfe.interfaces.process.cte.reception.AfterReception;
import com.softart.dfe.interfaces.process.cte.reception.BeforeReception;

import java.util.Collection;

public abstract class ReceptionCteProcessFactory implements ProcessFactory<TEnviCTe, TRetEnviCTe> {

    public static ReceptionCteProcessFactory noStore() {
        return Holder.NOSTORE;
    }

    public static ReceptionCteProcessFactory fileStore() {
        return Holder.FILESYSTEM;
    }

    public static ReceptionCteProcessFactory s3() {
        return HolderS3.INSTANCE;
    }

    public abstract Collection<BeforeReception> before();

    public abstract Collection<AfterReception> after();

    final static class HolderS3 {
        final static ReceptionCteProcessFactory INSTANCE = new S3StoreReceptionCteFactory();
    }

    final static class Holder {
        final static ReceptionCteProcessFactory NOSTORE = new NoStoreReceptionCteFactory();
        final static ReceptionCteProcessFactory FILESYSTEM = new FileSystemReceptionCteFactory();
    }
}
