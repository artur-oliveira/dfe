package org.dfe.components.process.nf.query_status_service.impl.file;


import org.dfe.components.process.nf.query_status_service.impl.QueryStatusServiceProcessFactory;
import org.dfe.interfaces.process.nf.query_status_service.AfterQueryStatusService;
import org.dfe.interfaces.process.nf.query_status_service.BeforeQueryStatusService;

import java.util.Collection;
import java.util.Collections;

public final class FileStoreFactory extends QueryStatusServiceProcessFactory {


    @Override
    public Collection<AfterQueryStatusService> after() {
        return Collections.singletonList(new FileStoreReturnQueryStatusServiceNfe());
    }

    @Override
    public Collection<BeforeQueryStatusService> before() {
        return Collections.singletonList(new FileStoreQueryStatusServiceNfe());
    }
}
