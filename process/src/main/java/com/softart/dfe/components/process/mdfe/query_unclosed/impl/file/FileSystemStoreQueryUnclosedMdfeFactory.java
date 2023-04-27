package com.softart.dfe.components.process.mdfe.query_unclosed.impl.file;

import com.softart.dfe.components.process.mdfe.query_unclosed.impl.QueryUnclosedMdfeProcessFactory;
import com.softart.dfe.interfaces.process.mdfe.query_unclosed.AfterQueryUnclosed;
import com.softart.dfe.interfaces.process.mdfe.query_unclosed.BeforeQueryUnclosed;

import java.util.Collection;
import java.util.Collections;

public final class FileSystemStoreQueryUnclosedMdfeFactory extends QueryUnclosedMdfeProcessFactory {

    private final Collection<AfterQueryUnclosed> after = Collections.singletonList(new FileSystemStoreReturnQueryUnclosedMdfe());
    private final Collection<BeforeQueryUnclosed> before = Collections.singletonList(new FileSystemStoreQueryUnclosedMdfe());


    @Override
    public Collection<BeforeQueryUnclosed> before() {
        return before;
    }

    @Override
    public Collection<AfterQueryUnclosed> after() {
        return after;
    }
}
