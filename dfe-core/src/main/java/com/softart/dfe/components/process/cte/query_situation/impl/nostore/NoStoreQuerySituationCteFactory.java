package com.softart.dfe.components.process.cte.query_situation.impl.nostore;

import com.softart.dfe.components.process.cte.query_situation.impl.QuerySituationCteProcessFactory;
import com.softart.dfe.interfaces.process.cte.query_situation.AfterQuerySituation;
import com.softart.dfe.interfaces.process.cte.query_situation.BeforeQuerySituation;

import java.util.Collection;
import java.util.Collections;

public final class NoStoreQuerySituationCteFactory extends QuerySituationCteProcessFactory {

    @Override
    public Collection<BeforeQuerySituation> before() {
        return Collections.singletonList(new NoStoreQuerySituationCte());
    }

    @Override
    public Collection<AfterQuerySituation> after() {
        return Collections.singletonList(new NoStoreReturnQuerySituationCte());
    }
}
