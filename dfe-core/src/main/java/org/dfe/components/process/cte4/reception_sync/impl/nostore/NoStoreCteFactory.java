package org.dfe.components.process.cte4.reception_sync.impl.nostore;

import org.dfe.components.process.cte4.reception_sync.impl.CteSyncProcessFactory;
import org.dfe.interfaces.process.cte4.reception_sync.AfterReceptionCteSync;
import org.dfe.interfaces.process.cte4.reception_sync.BeforeReceptionCteSync;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public final class NoStoreCteFactory extends CteSyncProcessFactory {

    @Override
    public Collection<BeforeReceptionCteSync> before() {
        return Collections.singletonList(new NoStoreCte());
    }

    @Override
    public Collection<AfterReceptionCteSync> after() {
        return Arrays.asList(new NoStoreReturnCte(), new NoStoreProcCte());
    }
}
