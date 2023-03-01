package com.softart.dfe.components.process.mdfe.query_unclosed.impl;

import br.inf.portalfiscal.mdfe.classes.TConsMDFeNaoEnc;
import br.inf.portalfiscal.mdfe.classes.TRetConsMDFeNaoEnc;
import com.softart.dfe.components.process.mdfe.query_unclosed.impl.file.FileSystemStoreQueryUnclosedMdfeFactory;
import com.softart.dfe.components.process.mdfe.query_unclosed.impl.nostore.NoStoreQueryUnclosedMdfeFactory;
import com.softart.dfe.interfaces.process.ProcessFactory;
import com.softart.dfe.interfaces.process.mdfe.query_unclosed.AfterQueryUnclosed;
import com.softart.dfe.interfaces.process.mdfe.query_unclosed.BeforeQueryUnclosed;

import java.util.Collection;

public abstract class QueryUnclosedMdfeProcessFactory implements ProcessFactory<TConsMDFeNaoEnc, TRetConsMDFeNaoEnc> {

    public static QueryUnclosedMdfeProcessFactory noStore() {
        return Holder.NOSTORE;
    }

    public static QueryUnclosedMdfeProcessFactory fileStore() {
        return Holder.FILESYSTEM;
    }

    public abstract Collection<BeforeQueryUnclosed> before();

    public abstract Collection<AfterQueryUnclosed> after();

    final static class Holder {
        final static QueryUnclosedMdfeProcessFactory NOSTORE = new NoStoreQueryUnclosedMdfeFactory();
        final static QueryUnclosedMdfeProcessFactory FILESYSTEM = new FileSystemStoreQueryUnclosedMdfeFactory();
    }
}
