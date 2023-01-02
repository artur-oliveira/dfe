package com.softart.dfe.components.process.nf.distribution.impl;

import br.inf.portalfiscal.nfe.distribution.TDistDFeInt;
import br.inf.portalfiscal.nfe.distribution.TRetDistDFeInt;
import com.softart.dfe.components.process.nf.distribution.impl.file.FileStoreFactory;
import com.softart.dfe.components.process.nf.distribution.impl.nostore.NoStoreFactory;
import com.softart.dfe.interfaces.process.ProcessFactory;
import com.softart.dfe.interfaces.process.nf.distribution.AfterDistribution;
import com.softart.dfe.interfaces.process.nf.distribution.BeforeDistribution;

import java.util.Collection;

public abstract class DistributionProcessFactory implements ProcessFactory<TDistDFeInt, TRetDistDFeInt> {

    public static DistributionProcessFactory noStore() {
        return new NoStoreFactory();
    }

    public static DistributionProcessFactory fileStore() {
        return new FileStoreFactory();
    }

    public abstract Collection<AfterDistribution> after();

    public abstract Collection<BeforeDistribution> before();
}
