package org.dfe.components.process.mdfe.reception_sync.impl.s3;

import org.dfe.components.process.mdfe.reception_sync.impl.ReceptionSyncMdfeProcessFactory;
import org.dfe.interfaces.process.mdfe.reception_sync.AfterReceptionSync;
import org.dfe.interfaces.process.mdfe.reception_sync.BeforeReceptionSync;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public final class S3StoreReceptionSyncMdfeFactory extends ReceptionSyncMdfeProcessFactory {

    private final Collection<AfterReceptionSync> after = Arrays.asList(new S3StoreReturnReceptionSyncMdfe(), new S3StoreProcMdfe());
    private final Collection<BeforeReceptionSync> before = Collections.singletonList(new S3StoreReceptionSyncMdfe());


    @Override
    public Collection<BeforeReceptionSync> before() {
        return before;
    }

    @Override
    public Collection<AfterReceptionSync> after() {
        return after;
    }
}
