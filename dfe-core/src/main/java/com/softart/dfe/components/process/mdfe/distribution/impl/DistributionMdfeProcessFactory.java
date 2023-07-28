package com.softart.dfe.components.process.mdfe.distribution.impl;

import br.inf.portalfiscal.mdfe.classes.TDistDFe;
import br.inf.portalfiscal.mdfe.classes.TRetDistDFe;
import com.softart.dfe.components.process.mdfe.distribution.impl.file.FileSystemStoreDistributionMdfeFactory;
import com.softart.dfe.components.process.mdfe.distribution.impl.nostore.NoStoreDistributionMdfeFactory;
import com.softart.dfe.components.process.mdfe.distribution.impl.s3.S3StoreDistributionMdfeFactory;
import com.softart.dfe.interfaces.process.ProcessFactory;
import com.softart.dfe.interfaces.process.mdfe.distribution.AfterDistribution;
import com.softart.dfe.interfaces.process.mdfe.distribution.BeforeDistribution;

import java.util.Collection;

public abstract class DistributionMdfeProcessFactory implements ProcessFactory<TDistDFe, TRetDistDFe> {

    public static DistributionMdfeProcessFactory noStore() {
        return Holder.NOSTORE;
    }

    public static DistributionMdfeProcessFactory fileStore() {
        return Holder.FILESYSTEM;
    }

    public static DistributionMdfeProcessFactory s3() {
        return HolderS3.INSTANCE;
    }

    public abstract Collection<BeforeDistribution> before();

    public abstract Collection<AfterDistribution> after();

    final static class HolderS3 {
        final static DistributionMdfeProcessFactory INSTANCE = new S3StoreDistributionMdfeFactory();
    }

    final static class Holder {
        final static DistributionMdfeProcessFactory NOSTORE = new NoStoreDistributionMdfeFactory();
        final static DistributionMdfeProcessFactory FILESYSTEM = new FileSystemStoreDistributionMdfeFactory();
    }
}
