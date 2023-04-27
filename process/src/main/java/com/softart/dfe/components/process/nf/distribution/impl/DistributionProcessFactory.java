package com.softart.dfe.components.process.nf.distribution.impl;

import br.inf.portalfiscal.nfe.distribution.TDistDFeInt;
import br.inf.portalfiscal.nfe.distribution.TRetDistDFeInt;
import com.softart.dfe.components.process.nf.distribution.impl.file.FileStoreFactory;
import com.softart.dfe.components.process.nf.distribution.impl.nostore.NoStoreFactory;
import com.softart.dfe.components.process.nf.distribution.impl.s3.S3StoreFactory;
import com.softart.dfe.interfaces.process.ProcessFactory;
import com.softart.dfe.interfaces.process.nf.distribution.AfterDistribution;
import com.softart.dfe.interfaces.process.nf.distribution.BeforeDistribution;

import java.util.Collection;

public abstract class DistributionProcessFactory implements ProcessFactory<TDistDFeInt, TRetDistDFeInt> {

    public static DistributionProcessFactory noStore() {
        return Holder.NO_STORE;
    }

    public static DistributionProcessFactory fileStore() {
        return Holder.FILE_STORE;
    }

    public static DistributionProcessFactory s3() {
        return HolderS3.S3;
    }

    public abstract Collection<AfterDistribution> after();

    public abstract Collection<BeforeDistribution> before();

    private final static class HolderS3 {
        private final static DistributionProcessFactory S3 = new S3StoreFactory();
    }

    private final static class Holder {
        private final static DistributionProcessFactory NO_STORE = new NoStoreFactory();
        private final static DistributionProcessFactory FILE_STORE = new FileStoreFactory();
    }
}
