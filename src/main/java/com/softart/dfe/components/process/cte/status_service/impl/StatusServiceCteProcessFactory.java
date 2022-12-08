package com.softart.dfe.components.process.cte.status_service.impl;

import br.inf.portalfiscal.cte.send.TConsStatServ;
import br.inf.portalfiscal.cte.send.TRetConsStatServ;
import com.softart.dfe.interfaces.process.ProcessFactory;
import com.softart.dfe.interfaces.process.cte.status_service.AfterStatusService;
import com.softart.dfe.interfaces.process.cte.status_service.BeforeStatusService;

import java.util.Collection;

public abstract class StatusServiceCteProcessFactory implements ProcessFactory<TConsStatServ, TRetConsStatServ> {

    public abstract Collection<BeforeStatusService> before();

    public abstract Collection<AfterStatusService> after();
}
