package org.dfe.components.process.cte.inutilization.impl.s3;

import org.dfe.components.process.cte.inutilization.impl.InutilizationCteProcessFactory;
import org.dfe.interfaces.process.cte.inutilization.AfterInutilization;
import org.dfe.interfaces.process.cte.inutilization.BeforeInutilization;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public final class S3StoreInutilizationCteFactory extends InutilizationCteProcessFactory {

    @Override
    public Collection<BeforeInutilization> before() {
        return Collections.singletonList(new S3StoreInutilizationCte());
    }

    @Override
    public Collection<AfterInutilization> after() {
        return Arrays.asList(new S3StoreReturnInutilizationCte(), new S3StoreProcInutilizationCte());
    }
}
