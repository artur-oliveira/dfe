package com.softart.dfe.components.process.cte4.query_situation.impl.s3;

import com.softart.dfe.components.process.cte4.query_situation.impl.QuerySituationCteProcessFactory;
import com.softart.dfe.interfaces.process.cte4.query_situation.AfterQuerySituation;
import com.softart.dfe.interfaces.process.cte4.query_situation.BeforeQuerySituation;

import java.util.Collection;
import java.util.Collections;

public final class S3StoreQuerySituationCteFactory extends QuerySituationCteProcessFactory {

    @Override
    public Collection<BeforeQuerySituation> before() {
        return Collections.singletonList(new S3StoreQuerySituationCte());
    }

    @Override
    public Collection<AfterQuerySituation> after() {
        return Collections.singletonList(new S3StoreReturnQuerySituationCte());
    }
}
