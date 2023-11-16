package org.dfe.components.process.cte.inutilization.impl.nostore;

import org.dfe.components.process.cte.inutilization.impl.InutilizationCteProcessFactory;
import org.dfe.interfaces.process.cte.inutilization.AfterInutilization;
import org.dfe.interfaces.process.cte.inutilization.BeforeInutilization;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public final class NoStoreInutilizationCteFactory extends InutilizationCteProcessFactory {

    @Override
    public Collection<BeforeInutilization> before() {
        return Collections.singletonList(new NoStoreInutilizationCte());
    }

    @Override
    public Collection<AfterInutilization> after() {
        return Arrays.asList(new NoStoreReturnInutilizationCte(), new NoStoreProcInutilizationCte());
    }
}
