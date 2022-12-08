package com.softart.dfe.components.process.nf.query_status_service.impl;

import br.inf.portalfiscal.nfe.send.TConsStatServ;
import br.inf.portalfiscal.nfe.send.TRetConsStatServ;
import com.softart.dfe.components.process.nf.query_status_service.impl.file.FileStoreFactory;
import com.softart.dfe.components.process.nf.query_status_service.impl.nostore.NoStoreFactory;
import com.softart.dfe.interfaces.process.ProcessFactory;
import com.softart.dfe.interfaces.process.nf.query_status_service.AfterQueryStatusService;
import com.softart.dfe.interfaces.process.nf.query_status_service.BeforeQueryStatusService;

import java.util.Collection;

public abstract class QueryStatusServiceProcessFactory implements ProcessFactory<TConsStatServ, TRetConsStatServ> {

    public static QueryStatusServiceProcessFactory noStore() {
        return new NoStoreFactory();
    }

    public static QueryStatusServiceProcessFactory fileStore() {
        return new FileStoreFactory();
    }

    public abstract Collection<AfterQueryStatusService> after();

    public abstract Collection<BeforeQueryStatusService> before();
}
