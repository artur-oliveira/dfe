package com.softart.dfe.components.process.cte.query_receipt.impl;

import br.inf.portalfiscal.cte.send.TConsReciCTe;
import br.inf.portalfiscal.cte.send.TRetConsReciCTe;
import com.softart.dfe.interfaces.process.ProcessFactory;
import com.softart.dfe.interfaces.process.cte.query_receipt.AfterQueryReceipt;
import com.softart.dfe.interfaces.process.cte.query_receipt.BeforeQueryReceipt;

import java.util.Collection;

public abstract class QueryReceiptCteProcessFactory implements ProcessFactory<TConsReciCTe, TRetConsReciCTe> {

    public abstract Collection<BeforeQueryReceipt> before();

    public abstract Collection<AfterQueryReceipt> after();
}
