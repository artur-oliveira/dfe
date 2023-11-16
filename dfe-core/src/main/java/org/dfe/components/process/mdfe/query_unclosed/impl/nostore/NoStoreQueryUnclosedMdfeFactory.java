package org.dfe.components.process.mdfe.query_unclosed.impl.nostore;

import org.dfe.components.process.mdfe.query_unclosed.impl.QueryUnclosedMdfeProcessFactory;
import org.dfe.interfaces.process.mdfe.query_unclosed.AfterQueryUnclosed;
import org.dfe.interfaces.process.mdfe.query_unclosed.BeforeQueryUnclosed;

import java.util.Collection;
import java.util.Collections;

public final class NoStoreQueryUnclosedMdfeFactory extends QueryUnclosedMdfeProcessFactory {

    private final Collection<AfterQueryUnclosed> after = Collections.singletonList(new NoStoreReturnQueryUnclosedMdfe());
    private final Collection<BeforeQueryUnclosed> before = Collections.singletonList(new NoStoreQueryUnclosedMdfe());


    @Override
    public Collection<BeforeQueryUnclosed> before() {
        return before;
    }

    @Override
    public Collection<AfterQueryUnclosed> after() {
        return after;
    }
}
