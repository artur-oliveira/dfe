package org.dfe.components.process.cte4.status_service.impl.s3;

import org.dfe.components.process.cte4.status_service.impl.StatusServiceCteProcessFactory;
import org.dfe.interfaces.process.cte4.status_service.AfterStatusService;
import org.dfe.interfaces.process.cte4.status_service.BeforeStatusService;

import java.util.Collection;
import java.util.Collections;

public final class S3StoreStatusServiceCteFactory extends StatusServiceCteProcessFactory {

    @Override
    public Collection<BeforeStatusService> before() {
        return Collections.singletonList(new S3StoreStatusServiceCte());
    }

    @Override
    public Collection<AfterStatusService> after() {
        return Collections.singletonList(new S3StoreReturnStatusServiceCte());
    }
}
