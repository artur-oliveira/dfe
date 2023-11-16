package org.dfe.components.process.nf.distribution.impl.file;


import org.dfe.components.process.nf.distribution.impl.DistributionProcessFactory;
import org.dfe.interfaces.process.nf.distribution.AfterDistribution;
import org.dfe.interfaces.process.nf.distribution.BeforeDistribution;

import java.util.Collection;
import java.util.Collections;

public final class FileStoreFactory extends DistributionProcessFactory {

    public Collection<AfterDistribution> after() {
        return Collections.singletonList(
                new FileStoreReturnQueryProtocolNfe()
        );
    }


    public Collection<BeforeDistribution> before() {
        return Collections.singletonList(
                new FileStoreQueryProtocolNfe()
        );
    }


}
