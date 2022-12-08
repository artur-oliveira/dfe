package com.softart.dfe.components.process.cte.query_situation.impl.file;

import com.softart.dfe.components.process.cte.query_situation.impl.QuerySituationCteProcessFactory;
import com.softart.dfe.interfaces.process.cte.query_situation.AfterQuerySituation;
import com.softart.dfe.interfaces.process.cte.query_situation.BeforeQuerySituation;

import java.util.Collection;
import java.util.Collections;

public final class FileSystemQuerySituationCteFactory extends QuerySituationCteProcessFactory {

    @Override
    public Collection<BeforeQuerySituation> before() {
        return Collections.singletonList(new FileSystemQuerySituationCte());
    }

    @Override
    public Collection<AfterQuerySituation> after() {
        return Collections.singletonList(new FileSystemReturnQuerySituationCte());
    }
}
