package org.dfe.components.process.cte.query_receipt.impl;

import br.inf.portalfiscal.cte.send.TConsReciCTe;
import br.inf.portalfiscal.cte.send.TRetConsReciCTe;
import org.dfe.components.process.cte.query_receipt.impl.file.FileSystemQueryReceiptCteFactory;
import org.dfe.components.process.cte.query_receipt.impl.nostore.NoStoreQueryReceiptCteFactory;
import org.dfe.components.process.cte.query_receipt.impl.s3.S3StoreQueryReceiptCteFactory;
import org.dfe.interfaces.process.ProcessFactory;
import org.dfe.interfaces.process.cte.query_receipt.AfterQueryReceipt;
import org.dfe.interfaces.process.cte.query_receipt.BeforeQueryReceipt;

import java.util.Collection;

public abstract class QueryReceiptCteProcessFactory implements ProcessFactory<TConsReciCTe, TRetConsReciCTe> {

    public static QueryReceiptCteProcessFactory noStore() {
        return Holder.NOSTORE;
    }

    public static QueryReceiptCteProcessFactory fileStore() {
        return Holder.FILESYSTEM;
    }

    public static QueryReceiptCteProcessFactory s3() {
        return HolderS3.INSTANCE;
    }


    public abstract Collection<BeforeQueryReceipt> before();


    public abstract Collection<AfterQueryReceipt> after();

    final static class HolderS3 {
        final static QueryReceiptCteProcessFactory INSTANCE = new S3StoreQueryReceiptCteFactory();
    }

    final static class Holder {
        final static QueryReceiptCteProcessFactory NOSTORE = new NoStoreQueryReceiptCteFactory();
        final static QueryReceiptCteProcessFactory FILESYSTEM = new FileSystemQueryReceiptCteFactory();
    }
}
