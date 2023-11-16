package org.dfe.components.process.mdfe.query_situation.impl.file;

import org.dfe.components.process.mdfe.query_situation.impl.QuerySituationMdfeProcessFactory;
import org.dfe.interfaces.process.mdfe.query_situation.AfterQuerySituation;
import org.dfe.interfaces.process.mdfe.query_situation.BeforeQuerySituation;

import java.util.Collection;
import java.util.Collections;

public final class FileSystemStoreQuerySituationMdfeFactory extends QuerySituationMdfeProcessFactory {

    private final Collection<AfterQuerySituation> after = Collections.singletonList(new FileSystemStoreReturnQuerySituationMdfe());
    private final Collection<BeforeQuerySituation> before = Collections.singletonList(new FileSystemStoreQuerySituationMdfe());


    @Override
    public Collection<BeforeQuerySituation> before() {
        return before;
    }

    @Override
    public Collection<AfterQuerySituation> after() {
        return after;
    }
}
