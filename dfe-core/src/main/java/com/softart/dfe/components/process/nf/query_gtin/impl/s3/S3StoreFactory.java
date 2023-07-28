package com.softart.dfe.components.process.nf.query_gtin.impl.s3;

import com.softart.dfe.components.process.nf.query_gtin.impl.QueryGtinProcessFactory;
import com.softart.dfe.interfaces.process.nf.query_gtin.AfterQueryGtin;
import com.softart.dfe.interfaces.process.nf.query_gtin.BeforeQueryGtin;

import java.util.Collection;
import java.util.Collections;

public final class S3StoreFactory extends QueryGtinProcessFactory {


    @Override
    public Collection<AfterQueryGtin> after() {
        return Collections.singletonList(new S3StoreReturnQueryGtinNfe());
    }

    @Override
    public Collection<BeforeQueryGtin> before() {
        return Collections.singletonList(new S3StoreQueryGtinNfe());
    }
}
