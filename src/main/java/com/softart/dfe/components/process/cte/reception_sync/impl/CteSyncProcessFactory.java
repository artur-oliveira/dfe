package com.softart.dfe.components.process.cte.reception_sync.impl;

import br.inf.portalfiscal.cte.send.TCTe;
import br.inf.portalfiscal.cte.send.TRetCTe;
import com.softart.dfe.interfaces.process.ProcessFactory;
import com.softart.dfe.interfaces.process.cte.reception_sync.AfterReceptionCteSync;
import com.softart.dfe.interfaces.process.cte.reception_sync.BeforeReceptionCteSync;

import java.util.Collection;

public abstract class CteSyncProcessFactory implements ProcessFactory<TCTe, TRetCTe> {

    public abstract Collection<BeforeReceptionCteSync> before();

    public abstract Collection<AfterReceptionCteSync> after();
}
