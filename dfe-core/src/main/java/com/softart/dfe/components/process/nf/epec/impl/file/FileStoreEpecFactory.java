package com.softart.dfe.components.process.nf.epec.impl.file;

import com.softart.dfe.components.process.nf.epec.impl.EpecProcessFactory;
import com.softart.dfe.interfaces.process.nf.epec.AfterEpec;
import com.softart.dfe.interfaces.process.nf.epec.BeforeEpec;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public final class FileStoreEpecFactory extends EpecProcessFactory {

    @Override
    public Collection<BeforeEpec> before() {
        return Collections.singletonList(
                new FileStoreSendEpecNfe()
        );
    }

    @Override
    public Collection<AfterEpec> after() {
        return Arrays.asList(
                new FileStoreRetEpecNfe(),
                new FileStoreProcEpecNfe()
        );
    }


}
