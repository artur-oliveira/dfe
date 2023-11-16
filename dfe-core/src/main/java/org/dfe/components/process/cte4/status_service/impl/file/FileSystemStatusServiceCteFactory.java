package org.dfe.components.process.cte4.status_service.impl.file;

import org.dfe.components.process.cte4.status_service.impl.StatusServiceCteProcessFactory;
import org.dfe.interfaces.process.cte4.status_service.AfterStatusService;
import org.dfe.interfaces.process.cte4.status_service.BeforeStatusService;

import java.util.Collection;
import java.util.Collections;

public final class FileSystemStatusServiceCteFactory extends StatusServiceCteProcessFactory {

    @Override
    public Collection<BeforeStatusService> before() {
        return Collections.singletonList(new FileSystemStatusServiceCte());
    }

    @Override
    public Collection<AfterStatusService> after() {
        return Collections.singletonList(new FileSystemReturnStatusServiceCte());
    }
}
