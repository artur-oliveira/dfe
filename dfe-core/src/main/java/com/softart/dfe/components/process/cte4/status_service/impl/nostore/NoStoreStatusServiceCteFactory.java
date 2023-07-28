package com.softart.dfe.components.process.cte4.status_service.impl.nostore;

import com.softart.dfe.components.process.cte4.status_service.impl.StatusServiceCteProcessFactory;
import com.softart.dfe.interfaces.process.cte4.status_service.AfterStatusService;
import com.softart.dfe.interfaces.process.cte4.status_service.BeforeStatusService;

import java.util.Collection;
import java.util.Collections;

public final class NoStoreStatusServiceCteFactory extends StatusServiceCteProcessFactory {

    @Override
    public Collection<BeforeStatusService> before() {
        return Collections.singletonList(new NoStoreStatusServiceCte());
    }

    @Override
    public Collection<AfterStatusService> after() {
        return Collections.singletonList(new NoStoreReturnStatusServiceCte());
    }
}
