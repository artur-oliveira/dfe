package org.dfe.components.process.mdfe.query_receipt.impl.s3;

import org.dfe.components.process.mdfe.query_receipt.impl.QueryReceiptMdfeProcessFactory;
import org.dfe.interfaces.process.mdfe.query_receipt.AfterQueryReceipt;
import org.dfe.interfaces.process.mdfe.query_receipt.BeforeQueryReceipt;

import java.util.Collection;
import java.util.Collections;

public final class S3StoreQueryReceiptMdfeFactory extends QueryReceiptMdfeProcessFactory {

    private final Collection<AfterQueryReceipt> after = Collections.singletonList(new S3StoreReturnQueryReceiptMdfe());
    private final Collection<BeforeQueryReceipt> before = Collections.singletonList(new S3StoreQueryReceiptMdfe());


    @Override
    public Collection<BeforeQueryReceipt> before() {
        return before;
    }

    @Override
    public Collection<AfterQueryReceipt> after() {
        return after;
    }
}
