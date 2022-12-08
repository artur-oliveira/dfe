package com.softart.dfe.components.process.cte.query_situation.impl;

import br.inf.portalfiscal.cte.send.TConsSitCTe;
import br.inf.portalfiscal.cte.send.TRetConsSitCTe;
import com.softart.dfe.interfaces.process.ProcessFactory;
import com.softart.dfe.interfaces.process.cte.query_situation.AfterQuerySituation;
import com.softart.dfe.interfaces.process.cte.query_situation.BeforeQuerySituation;

import java.util.Collection;

public abstract class QuerySituationCteProcessFactory implements ProcessFactory<TConsSitCTe, TRetConsSitCTe> {

    public abstract Collection<BeforeQuerySituation> before();

    public abstract Collection<AfterQuerySituation> after();
}
