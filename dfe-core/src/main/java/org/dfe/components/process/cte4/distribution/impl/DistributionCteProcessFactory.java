package org.dfe.components.process.cte4.distribution.impl;

import br.inf.portalfiscal.cte.distribution.DistDFeInt;
import br.inf.portalfiscal.cte.distribution.RetDistDFeInt;
import org.dfe.components.process.cte4.distribution.impl.file.FileSystemDistributionCteFactory;
import org.dfe.components.process.cte4.distribution.impl.nostore.NoStoreDistributionCteFactory;
import org.dfe.components.process.cte4.distribution.impl.s3.S3DistributionCteFactory;
import org.dfe.interfaces.process.ProcessFactory;
import org.dfe.interfaces.process.cte4.distribution.AfterDistribution;
import org.dfe.interfaces.process.cte4.distribution.BeforeDistribution;

import java.util.Collection;

public abstract class DistributionCteProcessFactory implements ProcessFactory<DistDFeInt, RetDistDFeInt> {

    public static DistributionCteProcessFactory noStore() {
        return Holder.NOSTORE;
    }

    public static DistributionCteProcessFactory fileStore() {
        return Holder.FILESYSTEM;
    }

    public static DistributionCteProcessFactory s3() {
        return HolderS3.S3;
    }

    public abstract Collection<BeforeDistribution> before();

    public abstract Collection<AfterDistribution> after();

    final static class HolderS3 {
        final static DistributionCteProcessFactory S3 = new S3DistributionCteFactory();
    }

    final static class Holder {
        final static DistributionCteProcessFactory NOSTORE = new NoStoreDistributionCteFactory();
        final static DistributionCteProcessFactory FILESYSTEM = new FileSystemDistributionCteFactory();
    }
}
