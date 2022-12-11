package com.softart.dfe.components.process.mdfe.query_receipt.impl.file;

import com.softart.dfe.components.process.mdfe.query_receipt.impl.QueryReceiptMdfeProcessFactory;
import com.softart.dfe.interfaces.process.mdfe.query_receipt.AfterQueryReceipt;
import com.softart.dfe.interfaces.process.mdfe.query_receipt.BeforeQueryReceipt;

import java.util.Collection;
import java.util.Collections;

public final class FileSystemStoreQueryReceiptMdfeFactory extends QueryReceiptMdfeProcessFactory {

    private final Collection<AfterQueryReceipt> after = Collections.singletonList(new FileSystemStoreReturnQueryReceiptMdfe());
    private final Collection<BeforeQueryReceipt> before = Collections.singletonList(new FileSystemStoreQueryReceiptMdfe());


    @Override
    public Collection<BeforeQueryReceipt> before() {
        return before;
    }

    @Override
    public Collection<AfterQueryReceipt> after() {
        return after;
    }
}
