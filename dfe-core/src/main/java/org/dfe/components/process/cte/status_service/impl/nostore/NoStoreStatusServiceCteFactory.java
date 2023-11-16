package org.dfe.components.process.cte.status_service.impl.nostore;

import org.dfe.components.process.cte.status_service.impl.StatusServiceCteProcessFactory;
import org.dfe.interfaces.process.cte.status_service.AfterStatusService;
import org.dfe.interfaces.process.cte.status_service.BeforeStatusService;

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
