package org.dfe.components.process.cte4.reception_os.impl;

import br.inf.portalfiscal.cte.send400.TCTeOS;
import br.inf.portalfiscal.cte.send400.TRetCTeOS;
import org.dfe.components.process.cte4.reception_os.impl.file.FileSystemCteOsFactory;
import org.dfe.components.process.cte4.reception_os.impl.nostore.NoStoreCteOsFactory;
import org.dfe.components.process.cte4.reception_os.impl.s3.S3StoreCteOsFactory;
import org.dfe.interfaces.process.ProcessFactory;
import org.dfe.interfaces.process.cte4.reception_os.AfterReceptionCteOs;
import org.dfe.interfaces.process.cte4.reception_os.BeforeReceptionCteOs;

import java.util.Collection;

public abstract class CteOsProcessFactory implements ProcessFactory<TCTeOS, TRetCTeOS> {

    public static CteOsProcessFactory noStore() {
        return Holder.NOSTORE;
    }

    public static CteOsProcessFactory fileStore() {
        return Holder.FILESYSTEM;
    }

    public static CteOsProcessFactory s3() {
        return HolderS3.INSTANCE;
    }

    public abstract Collection<BeforeReceptionCteOs> before();

    public abstract Collection<AfterReceptionCteOs> after();

    final static class HolderS3 {
        final static CteOsProcessFactory INSTANCE = new S3StoreCteOsFactory();
    }

    final static class Holder {
        final static CteOsProcessFactory NOSTORE = new NoStoreCteOsFactory();
        final static CteOsProcessFactory FILESYSTEM = new FileSystemCteOsFactory();
    }
}
