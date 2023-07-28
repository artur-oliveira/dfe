package com.softart.dfe.components.process.cte4.reception_gtve.impl.nostore;

import com.softart.dfe.components.process.cte4.reception_gtve.impl.GtveProcessFactory;
import com.softart.dfe.interfaces.process.cte4.reception_gtve.AfterReceptionGtve;
import com.softart.dfe.interfaces.process.cte4.reception_gtve.BeforeReceptionGtve;

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
