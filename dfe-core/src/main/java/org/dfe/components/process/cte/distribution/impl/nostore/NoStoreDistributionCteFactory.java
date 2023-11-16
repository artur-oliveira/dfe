package org.dfe.components.process.cte.distribution.impl.nostore;

import org.dfe.components.process.cte.distribution.impl.DistributionCteProcessFactory;
import org.dfe.interfaces.process.cte.distribution.AfterDistribution;
import org.dfe.interfaces.process.cte.distribution.BeforeDistribution;

import java.util.Collection;
import java.util.Collections;

public final class NoStoreDistributionCteFactory extends DistributionCteProcessFactory {

    @Override
    public Collection<BeforeDistribution> before() {
        return Collections.singletonList(new NoStoreDistributionCte());
    }

    @Override
    public Collection<AfterDistribution> after() {
        return Collections.singletonList(new NoStoreReturnDistributionCte());
    }
}
