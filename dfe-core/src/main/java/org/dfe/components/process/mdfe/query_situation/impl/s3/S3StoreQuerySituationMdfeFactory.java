package org.dfe.components.process.mdfe.query_situation.impl.s3;

import org.dfe.components.process.mdfe.query_situation.impl.QuerySituationMdfeProcessFactory;
import org.dfe.interfaces.process.mdfe.query_situation.AfterQuerySituation;
import org.dfe.interfaces.process.mdfe.query_situation.BeforeQuerySituation;

import java.util.Collection;
import java.util.Collections;

public final class S3StoreQuerySituationMdfeFactory extends QuerySituationMdfeProcessFactory {

    private final Collection<AfterQuerySituation> after = Collections.singletonList(new S3StoreReturnQuerySituationMdfe());
    private final Collection<BeforeQuerySituation> before = Collections.singletonList(new S3StoreQuerySituationMdfe());


    @Override
    public Collection<BeforeQuerySituation> before() {
        return before;
    }

    @Override
    public Collection<AfterQuerySituation> after() {
        return after;
    }
}
