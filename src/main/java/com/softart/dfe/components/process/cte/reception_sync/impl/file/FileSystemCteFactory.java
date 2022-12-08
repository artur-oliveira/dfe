package com.softart.dfe.components.process.cte.reception_sync.impl.file;

import com.softart.dfe.components.process.cte.reception_sync.impl.CteSyncProcessFactory;
import com.softart.dfe.interfaces.process.cte.reception_sync.AfterReceptionCteSync;
import com.softart.dfe.interfaces.process.cte.reception_sync.BeforeReceptionCteSync;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public final class FileSystemCteFactory extends CteSyncProcessFactory {

    @Override
    public Collection<BeforeReceptionCteSync> before() {
        return Collections.singletonList(new FileSystemCte());
    }

    @Override
    public Collection<AfterReceptionCteSync> after() {
        return Arrays.asList(new FileSystemReturnCte(), new FileSystemProcCte());
    }
}
