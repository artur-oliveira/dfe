package org.dfe.components.process.nf.epec.impl.nostore;

import org.dfe.components.process.nf.epec.impl.EpecProcessFactory;
import org.dfe.interfaces.process.nf.epec.AfterEpec;
import org.dfe.interfaces.process.nf.epec.BeforeEpec;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public final class NoStoreEpecFactory extends EpecProcessFactory {

    @Override
    public Collection<BeforeEpec> before() {
        return Collections.singletonList(
                new NoStoreSendEpecNfe()
        );
    }

    @Override
    public Collection<AfterEpec> after() {
        return Arrays.asList(
                new NoStoreRetEpecNfe(),
                new NoStoreProcEpecNfe()
        );
    }


}
