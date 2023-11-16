package org.dfe.components.process.cte.query_situation.impl;

import br.inf.portalfiscal.cte.send.TConsSitCTe;
import br.inf.portalfiscal.cte.send.TRetConsSitCTe;
import org.dfe.components.process.cte.query_situation.impl.file.FileSystemQuerySituationCteFactory;
import org.dfe.components.process.cte.query_situation.impl.nostore.NoStoreQuerySituationCteFactory;
import org.dfe.components.process.cte.query_situation.impl.s3.S3StoreQuerySituationCteFactory;
import org.dfe.interfaces.process.ProcessFactory;
import org.dfe.interfaces.process.cte.query_situation.AfterQuerySituation;
import org.dfe.interfaces.process.cte.query_situation.BeforeQuerySituation;

import java.util.Collection;

public abstract class QuerySituationCteProcessFactory implements ProcessFactory<TConsSitCTe, TRetConsSitCTe> {

    public static QuerySituationCteProcessFactory noStore() {
        return Holder.NOSTORE;
    }

    public static QuerySituationCteProcessFactory fileStore() {
        return Holder.FILESYSTEM;
    }

    public static QuerySituationCteProcessFactory s3() {
        return HolderS3.INSTANCE;
    }

    public abstract Collection<BeforeQuerySituation> before();

    public abstract Collection<AfterQuerySituation> after();

    final static class HolderS3 {
        final static QuerySituationCteProcessFactory INSTANCE = new S3StoreQuerySituationCteFactory();
    }

    final static class Holder {
        final static QuerySituationCteProcessFactory NOSTORE = new NoStoreQuerySituationCteFactory();
        final static QuerySituationCteProcessFactory FILESYSTEM = new FileSystemQuerySituationCteFactory();
    }
}
