package com.softart.dfe.components.process.cte4.reception_os.impl.s3;

import com.softart.dfe.components.process.cte4.reception_os.impl.CteOsProcessFactory;
import com.softart.dfe.interfaces.process.cte4.reception_os.AfterReceptionCteOs;
import com.softart.dfe.interfaces.process.cte4.reception_os.BeforeReceptionCteOs;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public final class S3StoreCteOsFactory extends CteOsProcessFactory {

    @Override
    public Collection<BeforeReceptionCteOs> before() {
        return Collections.singletonList(new S3StoreCteOs());
    }

    @Override
    public Collection<AfterReceptionCteOs> after() {
        return Arrays.asList(new S3StoreReturnCteOs(), new S3StoreProcCteOs());
    }
}
