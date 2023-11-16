package org.dfe.components.process.cte4.distribution.impl.file;

import org.dfe.components.process.cte4.distribution.impl.DistributionCteProcessFactory;
import org.dfe.interfaces.process.cte.distribution.AfterDistribution;
import org.dfe.interfaces.process.cte.distribution.BeforeDistribution;

import java.util.Collection;
import java.util.Collections;

public final class FileSystemDistributionCteFactory extends DistributionCteProcessFactory {

    @Override
    public Collection<BeforeDistribution> before() {
        return Collections.singletonList(new FileSystemDistributionCte());
    }

    @Override
    public Collection<AfterDistribution> after() {
        return Collections.singletonList(new FileSystemReturnDistributionCte());
    }
}
