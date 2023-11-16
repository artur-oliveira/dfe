package org.dfe.components.process.cte.inutilization.impl;

import br.inf.portalfiscal.cte.send.TInutCTe;
import br.inf.portalfiscal.cte.send.TRetInutCTe;
import org.dfe.components.process.cte.inutilization.impl.file.FileSystemInutilizationCteFactory;
import org.dfe.components.process.cte.inutilization.impl.nostore.NoStoreInutilizationCteFactory;
import org.dfe.components.process.cte.inutilization.impl.s3.S3StoreInutilizationCteFactory;
import org.dfe.interfaces.process.ProcessFactory;
import org.dfe.interfaces.process.cte.inutilization.AfterInutilization;
import org.dfe.interfaces.process.cte.inutilization.BeforeInutilization;

import java.util.Collection;

public abstract class InutilizationCteProcessFactory implements ProcessFactory<TInutCTe, TRetInutCTe> {

    public static InutilizationCteProcessFactory noStore() {
        return Holder.NOSTORE;
    }

    public static InutilizationCteProcessFactory fileStore() {
        return Holder.FILESYSTEM;
    }

    public static InutilizationCteProcessFactory s3() {
        return HolderS3.INSTANCE;
    }

    public abstract Collection<BeforeInutilization> before();

    public abstract Collection<AfterInutilization> after();

    final static class HolderS3 {
        final static InutilizationCteProcessFactory INSTANCE = new S3StoreInutilizationCteFactory();
    }

    final static class Holder {
        final static InutilizationCteProcessFactory NOSTORE = new NoStoreInutilizationCteFactory();
        final static InutilizationCteProcessFactory FILESYSTEM = new FileSystemInutilizationCteFactory();
    }
}
