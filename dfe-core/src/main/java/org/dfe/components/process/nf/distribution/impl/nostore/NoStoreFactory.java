package org.dfe.components.process.nf.distribution.impl.nostore;


import org.dfe.components.process.nf.distribution.impl.DistributionProcessFactory;
import org.dfe.interfaces.process.nf.distribution.AfterDistribution;
import org.dfe.interfaces.process.nf.distribution.BeforeDistribution;

import java.util.Collection;
import java.util.Collections;

public final class NoStoreFactory extends DistributionProcessFactory {

    public Collection<AfterDistribution> after() {
        return Collections.singletonList(
                new NoStoreRetDistributionNfe()
        );
    }


    public Collection<BeforeDistribution> before() {
        return Collections.singletonList(
                new NoStoreDistributionNfe()
        );
    }


}
