package com.softart.dfe.components.process.cte.query_receipt.impl;

import br.inf.portalfiscal.cte.send.TConsReciCTe;
import br.inf.portalfiscal.cte.send.TRetConsReciCTe;
import com.softart.dfe.components.process.cte.query_receipt.impl.file.FileSystemQueryReceiptCteFactory;
import com.softart.dfe.components.process.cte.query_receipt.impl.nostore.NoStoreQueryReceiptCteFactory;
import com.softart.dfe.interfaces.process.ProcessFactory;
import com.softart.dfe.interfaces.process.cte.query_receipt.AfterQueryReceipt;
import com.softart.dfe.interfaces.process.cte.query_receipt.BeforeQueryReceipt;

import java.util.Collection;

public abstract class QueryReceiptCteProcessFactory implements ProcessFactory<TConsReciCTe, TRetConsReciCTe> {

    public static QueryReceiptCteProcessFactory noStore() {
        return Holder.NOSTORE;
    }

    public static QueryReceiptCteProcessFactory fileStore() {
        return Holder.FILESYSTEM;
    }

    public abstract Collection<BeforeQueryReceipt> before();

    public abstract Collection<AfterQueryReceipt> after();

    final static class Holder {
        final static QueryReceiptCteProcessFactory NOSTORE = new NoStoreQueryReceiptCteFactory();
        final static QueryReceiptCteProcessFactory FILESYSTEM = new FileSystemQueryReceiptCteFactory();
    }
}
