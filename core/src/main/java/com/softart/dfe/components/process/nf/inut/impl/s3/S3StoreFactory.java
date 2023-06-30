package com.softart.dfe.components.process.nf.inut.impl.s3;


import com.softart.dfe.components.process.nf.inut.impl.InutilizationProcessFactory;
import com.softart.dfe.interfaces.process.nf.inut.AfterInut;
import com.softart.dfe.interfaces.process.nf.inut.BeforeInut;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

@SuppressWarnings("unused")
public final class S3StoreFactory extends InutilizationProcessFactory {

    public Collection<AfterInut> after() {
        return Arrays.asList(
                new S3StoreRetInutNfe(),
                new S3StoreProcInutNfe()
        );
    }


    public Collection<BeforeInut> before() {
        return Collections.singletonList(
                new S3StoreInutNfe()
        );
    }


}
