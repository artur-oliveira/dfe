package org.dfe.components.process.mdfe.query_unclosed.impl;

import br.inf.portalfiscal.mdfe.classes.TConsMDFeNaoEnc;
import br.inf.portalfiscal.mdfe.classes.TRetConsMDFeNaoEnc;
import org.dfe.components.process.mdfe.query_unclosed.impl.file.FileSystemStoreQueryUnclosedMdfeFactory;
import org.dfe.components.process.mdfe.query_unclosed.impl.nostore.NoStoreQueryUnclosedMdfeFactory;
import org.dfe.components.process.mdfe.query_unclosed.impl.s3.S3StoreQueryUnclosedMdfeFactory;
import org.dfe.interfaces.process.ProcessFactory;
import org.dfe.interfaces.process.mdfe.query_unclosed.AfterQueryUnclosed;
import org.dfe.interfaces.process.mdfe.query_unclosed.BeforeQueryUnclosed;

import java.util.Collection;

public abstract class QueryUnclosedMdfeProcessFactory implements ProcessFactory<TConsMDFeNaoEnc, TRetConsMDFeNaoEnc> {

    public static QueryUnclosedMdfeProcessFactory noStore() {
        return Holder.NOSTORE;
    }

    public static QueryUnclosedMdfeProcessFactory fileStore() {
        return Holder.FILESYSTEM;
    }

    public static QueryUnclosedMdfeProcessFactory s3() {
        return HolderS3.INSTANCE;
    }

    public abstract Collection<BeforeQueryUnclosed> before();

    public abstract Collection<AfterQueryUnclosed> after();

    final static class HolderS3 {
        final static QueryUnclosedMdfeProcessFactory INSTANCE = new S3StoreQueryUnclosedMdfeFactory();
    }

    final static class Holder {
        final static QueryUnclosedMdfeProcessFactory NOSTORE = new NoStoreQueryUnclosedMdfeFactory();
        final static QueryUnclosedMdfeProcessFactory FILESYSTEM = new FileSystemStoreQueryUnclosedMdfeFactory();
    }
}
