package com.softart.dfe.components.process.mdfe.status_service.impl.file;

import com.softart.dfe.components.process.mdfe.status_service.impl.StatusServiceMdfeProcessFactory;
import com.softart.dfe.interfaces.process.mdfe.status_service.AfterStatusService;
import com.softart.dfe.interfaces.process.mdfe.status_service.BeforeStatusService;

import java.util.Collection;
import java.util.Collections;

public final class FileSystemStoreStatusServiceMdfeFactory extends StatusServiceMdfeProcessFactory {

    private final Collection<AfterStatusService> after = Collections.singletonList(new FileSystemStoreReturnStatusServiceMdfe());
    private final Collection<BeforeStatusService> before = Collections.singletonList(new FileSystemStoreStatusServiceMdfe());


    @Override
    public Collection<BeforeStatusService> before() {
        return before;
    }

    @Override
    public Collection<AfterStatusService> after() {
        return after;
    }
}
