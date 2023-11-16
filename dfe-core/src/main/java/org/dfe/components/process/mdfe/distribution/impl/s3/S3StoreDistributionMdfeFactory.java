package org.dfe.components.process.mdfe.distribution.impl.s3;

import org.dfe.components.process.mdfe.distribution.impl.DistributionMdfeProcessFactory;
import org.dfe.interfaces.process.mdfe.distribution.AfterDistribution;
import org.dfe.interfaces.process.mdfe.distribution.BeforeDistribution;

import java.util.Collection;
import java.util.Collections;

public final class S3StoreDistributionMdfeFactory extends DistributionMdfeProcessFactory {

    private final Collection<AfterDistribution> after = Collections.singletonList(new S3StoreReturnDistributionMdfe());
    private final Collection<BeforeDistribution> before = Collections.singletonList(new S3StoreDistributionMdfe());


    @Override
    public Collection<BeforeDistribution> before() {
        return before;
    }

    @Override
    public Collection<AfterDistribution> after() {
        return after;
    }
}
