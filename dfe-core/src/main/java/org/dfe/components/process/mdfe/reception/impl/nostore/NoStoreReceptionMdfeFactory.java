package org.dfe.components.process.mdfe.reception.impl.nostore;

import org.dfe.components.process.mdfe.reception.impl.ReceptionMdfeProcessFactory;
import org.dfe.interfaces.process.mdfe.reception.AfterReception;
import org.dfe.interfaces.process.mdfe.reception.BeforeReception;

import java.util.Collection;
import java.util.Collections;

public final class NoStoreReceptionMdfeFactory extends ReceptionMdfeProcessFactory {

    private final Collection<AfterReception> after = Collections.singletonList(new NoStoreReturnReceptionMdfe());
    private final Collection<BeforeReception> before = Collections.singletonList(new NoStoreReceptionMdfe());


    @Override
    public Collection<BeforeReception> before() {
        return before;
    }

    @Override
    public Collection<AfterReception> after() {
        return after;
    }
}
