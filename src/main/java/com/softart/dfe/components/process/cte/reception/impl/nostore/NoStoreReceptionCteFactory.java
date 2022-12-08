package com.softart.dfe.components.process.cte.reception.impl.nostore;

import com.softart.dfe.components.process.cte.reception.impl.ReceptionCteProcessFactory;
import com.softart.dfe.interfaces.process.cte.reception.AfterReception;
import com.softart.dfe.interfaces.process.cte.reception.BeforeReception;

import java.util.Collection;
import java.util.Collections;

public final class NoStoreReceptionCteFactory extends ReceptionCteProcessFactory {

    @Override
    public Collection<BeforeReception> before() {
        return Collections.singletonList(new NoStoreReceptionCte());
    }

    @Override
    public Collection<AfterReception> after() {
        return Collections.singletonList(new NoStoreReturnReceptionCte());
    }
}
