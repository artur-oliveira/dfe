package com.softart.dfe.components.process.nf.query_gtin.impl;

import br.inf.portalfiscal.nfe.gtin.TConsGTIN;
import br.inf.portalfiscal.nfe.gtin.TRetConsGTIN;
import com.softart.dfe.components.process.nf.query_gtin.impl.file.FileStoreFactory;
import com.softart.dfe.components.process.nf.query_gtin.impl.nostore.NoStoreFactory;
import com.softart.dfe.interfaces.process.ProcessFactory;
import com.softart.dfe.interfaces.process.nf.query_gtin.AfterQueryGtin;
import com.softart.dfe.interfaces.process.nf.query_gtin.BeforeQueryGtin;

import java.util.Collection;

public abstract class QueryGtinProcessFactory implements ProcessFactory<TConsGTIN, TRetConsGTIN> {

    public static QueryGtinProcessFactory noStore() {
        return new NoStoreFactory();
    }

    public static QueryGtinProcessFactory fileStore() {
        return new FileStoreFactory();
    }

    public abstract Collection<AfterQueryGtin> after();

    public abstract Collection<BeforeQueryGtin> before();
}
