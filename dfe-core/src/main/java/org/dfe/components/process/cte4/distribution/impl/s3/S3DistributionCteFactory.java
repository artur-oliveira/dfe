package org.dfe.components.process.cte4.distribution.impl.s3;

import org.dfe.components.process.cte4.distribution.impl.DistributionCteProcessFactory;
import org.dfe.interfaces.process.cte4.distribution.AfterDistribution;
import org.dfe.interfaces.process.cte4.distribution.BeforeDistribution;

import java.util.Collection;
import java.util.Collections;

public final class S3DistributionCteFactory extends DistributionCteProcessFactory {

    @Override
    public Collection<BeforeDistribution> before() {
        return Collections.singletonList(new S3DistributionCte());
    }

    @Override
    public Collection<AfterDistribution> after() {
        return Collections.singletonList(new S3ReturnDistributionCte());
    }
}
