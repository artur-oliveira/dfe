package com.softart.dfe.components.process.cte.status_service.impl.s3;

import com.softart.dfe.components.process.cte.status_service.impl.StatusServiceCteProcessFactory;
import com.softart.dfe.interfaces.process.cte.status_service.AfterStatusService;
import com.softart.dfe.interfaces.process.cte.status_service.BeforeStatusService;

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
