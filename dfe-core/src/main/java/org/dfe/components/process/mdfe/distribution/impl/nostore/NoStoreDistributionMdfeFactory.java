package org.dfe.components.process.mdfe.distribution.impl.nostore;

import org.dfe.components.process.mdfe.distribution.impl.DistributionMdfeProcessFactory;
import org.dfe.interfaces.process.mdfe.distribution.AfterDistribution;
import org.dfe.interfaces.process.mdfe.distribution.BeforeDistribution;

import java.util.Collection;
import java.util.Collections;

public final class NoStoreDistributionMdfeFactory extends DistributionMdfeProcessFactory {

    private final Collection<AfterDistribution> after = Collections.singletonList(new NoStoreReturnDistributionMdfe());
    private final Collection<BeforeDistribution> before = Collections.singletonList(new NoStoreDistributionMdfe());


    @Override
    public Collection<BeforeDistribution> before() {
        return before;
    }

    @Override
    public Collection<AfterDistribution> after() {
        return after;
    }
}
