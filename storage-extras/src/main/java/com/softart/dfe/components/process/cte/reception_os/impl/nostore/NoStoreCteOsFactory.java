package com.softart.dfe.components.process.cte.reception_os.impl.nostore;

import com.softart.dfe.components.process.cte.reception_os.impl.CteOsProcessFactory;
import com.softart.dfe.interfaces.process.cte.reception_os.AfterReceptionCteOs;
import com.softart.dfe.interfaces.process.cte.reception_os.BeforeReceptionCteOs;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public final class NoStoreCteOsFactory extends CteOsProcessFactory {

    @Override
    public Collection<BeforeReceptionCteOs> before() {
        return Collections.singletonList(new NoStoreCteOs());
    }

    @Override
    public Collection<AfterReceptionCteOs> after() {
        return Arrays.asList(new NoStoreReturnCteOs(), new NoStoreProcCteOs());
    }
}
