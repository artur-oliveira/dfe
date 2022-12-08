package com.softart.dfe.components.process.cte.event.impl;

import br.inf.portalfiscal.cte.send.TEvento;
import br.inf.portalfiscal.cte.send.TRetEvento;
import com.softart.dfe.interfaces.process.ProcessFactory;
import com.softart.dfe.interfaces.process.cte.event.AfterEvent;
import com.softart.dfe.interfaces.process.cte.event.BeforeEvent;

import java.util.Collection;

public abstract class EventCteProcessFactory implements ProcessFactory<TEvento, TRetEvento> {

    public abstract Collection<BeforeEvent> before();

    public abstract Collection<AfterEvent> after();
}
