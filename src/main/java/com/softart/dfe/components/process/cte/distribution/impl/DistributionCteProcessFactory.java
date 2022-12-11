package com.softart.dfe.components.process.cte.distribution.impl;

import br.inf.portalfiscal.cte.distribution.DistDFeInt;
import br.inf.portalfiscal.cte.distribution.RetDistDFeInt;
import com.softart.dfe.components.process.cte.distribution.impl.file.FileSystemDistributionCteFactory;
import com.softart.dfe.components.process.cte.distribution.impl.nostore.NoStoreDistributionCteFactory;
import com.softart.dfe.interfaces.process.ProcessFactory;
import com.softart.dfe.interfaces.process.cte.distribution.AfterDistribution;
import com.softart.dfe.interfaces.process.cte.distribution.BeforeDistribution;

import java.util.Collection;

public abstract class DistributionCteProcessFactory implements ProcessFactory<DistDFeInt, RetDistDFeInt> {

    public static DistributionCteProcessFactory noStore() {
        return DistributionCteProcessFactory.Holder.NOSTORE;
    }

    public static DistributionCteProcessFactory fileStore() {
        return DistributionCteProcessFactory.Holder.FILESYSTEM;
    }

    public abstract Collection<BeforeDistribution> before();

    public abstract Collection<AfterDistribution> after();

    final static class Holder {
        final static DistributionCteProcessFactory NOSTORE = new NoStoreDistributionCteFactory();
        final static DistributionCteProcessFactory FILESYSTEM = new FileSystemDistributionCteFactory();
    }
}
