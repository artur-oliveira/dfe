package org.dfe.components.process.cte.reception_os.impl.s3;

import org.dfe.components.process.cte.reception_os.impl.CteOsProcessFactory;
import org.dfe.interfaces.process.cte.reception_os.AfterReceptionCteOs;
import org.dfe.interfaces.process.cte.reception_os.BeforeReceptionCteOs;

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
