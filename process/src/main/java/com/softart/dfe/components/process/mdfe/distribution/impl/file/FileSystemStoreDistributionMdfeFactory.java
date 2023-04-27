package com.softart.dfe.components.process.mdfe.distribution.impl.file;

import com.softart.dfe.components.process.mdfe.distribution.impl.DistributionMdfeProcessFactory;
import com.softart.dfe.interfaces.process.mdfe.distribution.AfterDistribution;
import com.softart.dfe.interfaces.process.mdfe.distribution.BeforeDistribution;

import java.util.Collection;
import java.util.Collections;

public final class FileSystemStoreDistributionMdfeFactory extends DistributionMdfeProcessFactory {

    private final Collection<AfterDistribution> after = Collections.singletonList(new FileSystemStoreReturnDistributionMdfe());
    private final Collection<BeforeDistribution> before = Collections.singletonList(new FileSystemStoreDistributionMdfe());


    @Override
    public Collection<BeforeDistribution> before() {
        return before;
    }

    @Override
    public Collection<AfterDistribution> after() {
        return after;
    }
}
