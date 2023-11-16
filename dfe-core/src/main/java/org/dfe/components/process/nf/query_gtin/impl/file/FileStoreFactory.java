package org.dfe.components.process.nf.query_gtin.impl.file;


import org.dfe.components.process.nf.query_gtin.impl.QueryGtinProcessFactory;
import org.dfe.interfaces.process.nf.query_gtin.AfterQueryGtin;
import org.dfe.interfaces.process.nf.query_gtin.BeforeQueryGtin;

import java.util.Collection;
import java.util.Collections;

public final class FileStoreFactory extends QueryGtinProcessFactory {


    @Override
    public Collection<AfterQueryGtin> after() {
        return Collections.singletonList(new FileStoreReturnQueryGtinNfe());
    }

    @Override
    public Collection<BeforeQueryGtin> before() {
        return Collections.singletonList(new FileStoreQueryGtinNfe());
    }
}
