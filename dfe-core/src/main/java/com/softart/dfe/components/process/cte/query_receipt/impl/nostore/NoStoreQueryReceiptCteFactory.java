package com.softart.dfe.components.process.cte.query_receipt.impl.nostore;

import com.softart.dfe.components.process.cte.query_receipt.impl.QueryReceiptCteProcessFactory;
import com.softart.dfe.interfaces.process.cte.query_receipt.AfterQueryReceipt;
import com.softart.dfe.interfaces.process.cte.query_receipt.BeforeQueryReceipt;

import java.util.Collection;
import java.util.Collections;

public final class NoStoreQueryReceiptCteFactory extends QueryReceiptCteProcessFactory {

    @Override
    public Collection<BeforeQueryReceipt> before() {
        return Collections.singletonList(new NoStoreQueryReceiptCte());
    }

    @Override
    public Collection<AfterQueryReceipt> after() {
        return Collections.singletonList(new NoStoreReturnQueryReceiptCte());
    }
}
