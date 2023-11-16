package org.dfe.components.process.cte.query_receipt.impl.file;

import org.dfe.components.process.cte.query_receipt.impl.QueryReceiptCteProcessFactory;
import org.dfe.interfaces.process.cte.query_receipt.AfterQueryReceipt;
import org.dfe.interfaces.process.cte.query_receipt.BeforeQueryReceipt;

import java.util.Collection;
import java.util.Collections;

public final class FileSystemQueryReceiptCteFactory extends QueryReceiptCteProcessFactory {

    @Override
    public Collection<BeforeQueryReceipt> before() {
        return Collections.singletonList(new FileSystemQueryReceiptCte());
    }

    @Override
    public Collection<AfterQueryReceipt> after() {
        return Collections.singletonList(new FileSystemReturnQueryReceiptCte());
    }
}
