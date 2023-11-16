package org.dfe.components.process.mdfe.status_service.impl.nostore;

import org.dfe.components.process.mdfe.status_service.impl.StatusServiceMdfeProcessFactory;
import org.dfe.interfaces.process.mdfe.status_service.AfterStatusService;
import org.dfe.interfaces.process.mdfe.status_service.BeforeStatusService;

import java.util.Collection;
import java.util.Collections;

public final class NoStoreStatusServiceMdfeFactory extends StatusServiceMdfeProcessFactory {

    private final Collection<AfterStatusService> after = Collections.singletonList(new NoStoreReturnStatusServiceMdfe());
    private final Collection<BeforeStatusService> before = Collections.singletonList(new NoStoreStatusServiceMdfe());


    @Override
    public Collection<BeforeStatusService> before() {
        return before;
    }

    @Override
    public Collection<AfterStatusService> after() {
        return after;
    }
}
