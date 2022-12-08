package com.softart.dfe.components.process.nf.query_status_service.impl.file;


import com.softart.dfe.components.process.nf.query_status_service.impl.QueryStatusServiceProcessFactory;
import com.softart.dfe.interfaces.process.nf.query_status_service.AfterQueryStatusService;
import com.softart.dfe.interfaces.process.nf.query_status_service.BeforeQueryStatusService;

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
