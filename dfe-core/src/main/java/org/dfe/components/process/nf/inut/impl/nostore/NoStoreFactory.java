package org.dfe.components.process.nf.inut.impl.nostore;


import org.dfe.components.process.nf.inut.impl.InutilizationProcessFactory;
import org.dfe.interfaces.process.nf.inut.AfterInut;
import org.dfe.interfaces.process.nf.inut.BeforeInut;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public final class NoStoreFactory extends InutilizationProcessFactory {

    public Collection<AfterInut> after() {
        return Arrays.asList(
                new NoStoreRetInutilizationNfe(),
                new NoStoreProcInutilizationNfe()
        );
    }


    public Collection<BeforeInut> before() {
        return Collections.singletonList(
                new NoStoreSendInutilizationNfe()
        );
    }


}
