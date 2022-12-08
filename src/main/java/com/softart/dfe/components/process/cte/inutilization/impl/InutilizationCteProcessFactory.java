package com.softart.dfe.components.process.cte.inutilization.impl;

import br.inf.portalfiscal.cte.send.TInutCTe;
import br.inf.portalfiscal.cte.send.TRetInutCTe;
import com.softart.dfe.interfaces.process.ProcessFactory;
import com.softart.dfe.interfaces.process.cte.inutilization.AfterInutilization;
import com.softart.dfe.interfaces.process.cte.inutilization.BeforeInutilization;

import java.util.Collection;

public abstract class InutilizationCteProcessFactory implements ProcessFactory<TInutCTe, TRetInutCTe> {

    public abstract Collection<BeforeInutilization> before();

    public abstract Collection<AfterInutilization> after();
}
