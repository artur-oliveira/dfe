package com.softart.dfe.components.process.nf.distribution.impl.nostore;


import com.softart.dfe.components.process.nf.distribution.impl.DistributionProcessFactory;
import com.softart.dfe.interfaces.process.nf.distribution.AfterDistribution;
import com.softart.dfe.interfaces.process.nf.distribution.BeforeDistribution;

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
