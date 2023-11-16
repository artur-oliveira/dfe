package org.dfe.components.process.cte.query_receipt.impl.s3;

import org.dfe.components.process.cte.query_receipt.impl.QueryReceiptCteProcessFactory;
import org.dfe.interfaces.process.cte.query_receipt.AfterQueryReceipt;
import org.dfe.interfaces.process.cte.query_receipt.BeforeQueryReceipt;

import java.util.Collection;
import java.util.Collections;

public final class S3StoreQueryReceiptCteFactory extends QueryReceiptCteProcessFactory {

    @Override
    public Collection<BeforeQueryReceipt> before() {
        return Collections.singletonList(new S3StoreQueryReceiptCte());
    }

    @Override
    public Collection<AfterQueryReceipt> after() {
        return Collections.singletonList(new S3StoreReturnQueryReceiptCte());
    }
}
