package com.softart.dfe.components.process.mdfe.query_situation.impl;

import br.inf.portalfiscal.mdfe.classes.TConsSitMDFe;
import br.inf.portalfiscal.mdfe.classes.TRetConsSitMDFe;
import com.softart.dfe.components.process.mdfe.query_situation.impl.file.FileSystemStoreQuerySituationMdfeFactory;
import com.softart.dfe.components.process.mdfe.query_situation.impl.nostore.NoStoreQuerySituationMdfeFactory;
import com.softart.dfe.components.process.mdfe.query_situation.impl.s3.S3StoreQuerySituationMdfeFactory;
import com.softart.dfe.interfaces.process.ProcessFactory;
import com.softart.dfe.interfaces.process.mdfe.query_situation.AfterQuerySituation;
import com.softart.dfe.interfaces.process.mdfe.query_situation.BeforeQuerySituation;

import java.util.Collection;

public abstract class QuerySituationMdfeProcessFactory implements ProcessFactory<TConsSitMDFe, TRetConsSitMDFe> {

    public static QuerySituationMdfeProcessFactory noStore() {
        return Holder.NOSTORE;
    }

    public static QuerySituationMdfeProcessFactory fileStore() {
        return Holder.FILESYSTEM;
    }

    public static QuerySituationMdfeProcessFactory s3() {
        return HolderS3.INSTANCE;
    }

    public abstract Collection<BeforeQuerySituation> before();

    public abstract Collection<AfterQuerySituation> after();

    final static class HolderS3 {
        final static QuerySituationMdfeProcessFactory INSTANCE = new S3StoreQuerySituationMdfeFactory();
    }

    final static class Holder {
        final static QuerySituationMdfeProcessFactory NOSTORE = new NoStoreQuerySituationMdfeFactory();
        final static QuerySituationMdfeProcessFactory FILESYSTEM = new FileSystemStoreQuerySituationMdfeFactory();
    }
}
