package com.softart.dfe.components.process.nf.epec.impl.s3;

import com.softart.dfe.components.process.nf.epec.impl.EpecProcessFactory;
import com.softart.dfe.interfaces.process.nf.epec.AfterEpec;
import com.softart.dfe.interfaces.process.nf.epec.BeforeEpec;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public final class S3StoreFactory extends EpecProcessFactory {

    @Override
    public Collection<BeforeEpec> before() {
        return Collections.singletonList(
                new S3StoreSendEpecNfe()
        );
    }

    @Override
    public Collection<AfterEpec> after() {
        return Arrays.asList(
                new S3StoreRetEpecNfe(),
                new S3StoreProcEpecNfe()
        );
    }


}
