package org.dfe.components.process.mdfe.query_situation.impl.nostore;

import org.dfe.components.process.mdfe.query_situation.impl.QuerySituationMdfeProcessFactory;
import org.dfe.interfaces.process.mdfe.query_situation.AfterQuerySituation;
import org.dfe.interfaces.process.mdfe.query_situation.BeforeQuerySituation;

import java.util.Collection;
import java.util.Collections;

public final class NoStoreQuerySituationMdfeFactory extends QuerySituationMdfeProcessFactory {

    private final Collection<AfterQuerySituation> after = Collections.singletonList(new NoStoreReturnQuerySituationMdfe());
    private final Collection<BeforeQuerySituation> before = Collections.singletonList(new NoStoreQuerySituationMdfe());


    @Override
    public Collection<BeforeQuerySituation> before() {
        return before;
    }

    @Override
    public Collection<AfterQuerySituation> after() {
        return after;
    }
}
