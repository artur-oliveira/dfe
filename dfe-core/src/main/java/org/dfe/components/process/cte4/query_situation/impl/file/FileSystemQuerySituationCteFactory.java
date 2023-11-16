package org.dfe.components.process.cte4.query_situation.impl.file;

import org.dfe.components.process.cte4.query_situation.impl.QuerySituationCteProcessFactory;
import org.dfe.interfaces.process.cte4.query_situation.AfterQuerySituation;
import org.dfe.interfaces.process.cte4.query_situation.BeforeQuerySituation;

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
