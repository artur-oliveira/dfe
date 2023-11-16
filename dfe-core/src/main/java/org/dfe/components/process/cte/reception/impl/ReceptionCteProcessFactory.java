package org.dfe.components.process.cte.reception.impl;

import br.inf.portalfiscal.cte.send.TEnviCTe;
import br.inf.portalfiscal.cte.send.TRetEnviCTe;
import org.dfe.components.process.cte.reception.impl.file.FileSystemReceptionCteFactory;
import org.dfe.components.process.cte.reception.impl.nostore.NoStoreReceptionCteFactory;
import org.dfe.components.process.cte.reception.impl.s3.S3StoreReceptionCteFactory;
import org.dfe.interfaces.process.ProcessFactory;
import org.dfe.interfaces.process.cte.reception.AfterReception;
import org.dfe.interfaces.process.cte.reception.BeforeReception;

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
