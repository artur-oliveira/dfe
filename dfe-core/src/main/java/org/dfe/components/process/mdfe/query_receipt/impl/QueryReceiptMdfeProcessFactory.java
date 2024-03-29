package org.dfe.components.process.mdfe.query_receipt.impl;

import br.inf.portalfiscal.mdfe.classes.TConsReciMDFe;
import br.inf.portalfiscal.mdfe.classes.TRetConsReciMDFe;
import org.dfe.components.process.mdfe.query_receipt.impl.file.FileSystemStoreQueryReceiptMdfeFactory;
import org.dfe.components.process.mdfe.query_receipt.impl.nostore.NoStoreQueryReceiptMdfeFactory;
import org.dfe.components.process.mdfe.query_receipt.impl.s3.S3StoreQueryReceiptMdfeFactory;
import org.dfe.interfaces.process.ProcessFactory;
import org.dfe.interfaces.process.mdfe.query_receipt.AfterQueryReceipt;
import org.dfe.interfaces.process.mdfe.query_receipt.BeforeQueryReceipt;

import java.util.Collection;

public abstract class QueryReceiptMdfeProcessFactory implements ProcessFactory<TConsReciMDFe, TRetConsReciMDFe> {

    public static QueryReceiptMdfeProcessFactory noStore() {
        return Holder.NOSTORE;
    }

    public static QueryReceiptMdfeProcessFactory fileStore() {
        return Holder.FILESYSTEM;
    }

    public static QueryReceiptMdfeProcessFactory s3() {
        return HolderS3.INSTANCE;
    }

    public abstract Collection<BeforeQueryReceipt> before();

    public abstract Collection<AfterQueryReceipt> after();

    final static class HolderS3 {
        final static QueryReceiptMdfeProcessFactory INSTANCE = new S3StoreQueryReceiptMdfeFactory();
    }

    final static class Holder {
        final static QueryReceiptMdfeProcessFactory NOSTORE = new NoStoreQueryReceiptMdfeFactory();
        final static QueryReceiptMdfeProcessFactory FILESYSTEM = new FileSystemStoreQueryReceiptMdfeFactory();
    }
}
