package org.dfe.components.process.cte4.reception_gtve.impl.nostore;

import org.dfe.components.process.cte4.reception_gtve.impl.GtveProcessFactory;
import org.dfe.interfaces.process.cte4.reception_gtve.AfterReceptionGtve;
import org.dfe.interfaces.process.cte4.reception_gtve.BeforeReceptionGtve;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public final class NoStoreGtveFactory extends GtveProcessFactory {

    @Override
    public Collection<BeforeReceptionGtve> before() {
        return Collections.singletonList(new NoStoreGtve());
    }

    @Override
    public Collection<AfterReceptionGtve> after() {
        return Arrays.asList(new NoStoreReturnGtve(), new NoStoreProcGtve());
    }
}
