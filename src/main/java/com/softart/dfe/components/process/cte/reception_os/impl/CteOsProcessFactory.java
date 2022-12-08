package com.softart.dfe.components.process.cte.reception_os.impl;

import br.inf.portalfiscal.cte.send.TCTeOS;
import br.inf.portalfiscal.cte.send.TRetCTeOS;
import com.softart.dfe.interfaces.process.ProcessFactory;
import com.softart.dfe.interfaces.process.cte.reception_os.AfterReceptionCteOs;
import com.softart.dfe.interfaces.process.cte.reception_os.BeforeReceptionCteOs;

import java.util.Collection;

public abstract class CteOsProcessFactory implements ProcessFactory<TCTeOS, TRetCTeOS> {

    public abstract Collection<BeforeReceptionCteOs> before();

    public abstract Collection<AfterReceptionCteOs> after();
}
