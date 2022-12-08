package com.softart.dfe.components.process.cte.reception.impl;

import br.inf.portalfiscal.cte.send.TEnviCTe;
import br.inf.portalfiscal.cte.send.TRetEnviCTe;
import com.softart.dfe.interfaces.process.ProcessFactory;
import com.softart.dfe.interfaces.process.cte.reception.AfterReception;
import com.softart.dfe.interfaces.process.cte.reception.BeforeReception;

import java.util.Collection;

public abstract class ReceptionCteProcessFactory implements ProcessFactory<TEnviCTe, TRetEnviCTe> {

    public abstract Collection<BeforeReception> before();

    public abstract Collection<AfterReception> after();
}
