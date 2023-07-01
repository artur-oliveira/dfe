package com.softart.dfe.components.process.cte4.reception_sync.impl.s3;

import com.softart.dfe.components.process.cte4.reception_sync.impl.CteSyncProcessFactory;
import com.softart.dfe.interfaces.process.cte4.reception_sync.AfterReceptionCteSync;
import com.softart.dfe.interfaces.process.cte4.reception_sync.BeforeReceptionCteSync;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public final class S3StoreCteFactory extends CteSyncProcessFactory {

    @Override
    public Collection<BeforeReceptionCteSync> before() {
        return Collections.singletonList(new S3StoreCte());
    }

    @Override
    public Collection<AfterReceptionCteSync> after() {
        return Arrays.asList(new S3StoreReturnCte(), new S3StoreProcCte());
    }
}
