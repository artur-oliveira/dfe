package org.dfe.components.process.nf.query_gtin.impl.nostore;

import org.dfe.components.process.nf.query_gtin.impl.QueryGtinProcessFactory;
import org.dfe.interfaces.process.nf.query_gtin.AfterQueryGtin;
import org.dfe.interfaces.process.nf.query_gtin.BeforeQueryGtin;

import java.util.Collection;
import java.util.Collections;

public final class NoStoreFactory extends QueryGtinProcessFactory {


    @Override
    public Collection<AfterQueryGtin> after() {
        return Collections.singletonList(new NoStoreReturnQueryGtinNfe());
    }

    @Override
    public Collection<BeforeQueryGtin> before() {
        return Collections.singletonList(new NoStoreQueryGtinNfe());
    }
}
