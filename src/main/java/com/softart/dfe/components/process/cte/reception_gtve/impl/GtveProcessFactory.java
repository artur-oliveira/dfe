package com.softart.dfe.components.process.cte.reception_gtve.impl;

import br.inf.portalfiscal.cte.send.TGTVe;
import br.inf.portalfiscal.cte.send.TRetGTVe;
import com.softart.dfe.interfaces.process.ProcessFactory;
import com.softart.dfe.interfaces.process.cte.reception_gtve.AfterReceptionGtve;
import com.softart.dfe.interfaces.process.cte.reception_gtve.BeforeReceptionGtve;

import java.util.Collection;

public abstract class GtveProcessFactory implements ProcessFactory<TGTVe, TRetGTVe> {

    public abstract Collection<BeforeReceptionGtve> before();

    public abstract Collection<AfterReceptionGtve> after();
}
