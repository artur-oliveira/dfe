package org.dfe.components.process.mdfe.reception_sync.impl.file;

import org.dfe.components.process.mdfe.reception_sync.impl.ReceptionSyncMdfeProcessFactory;
import org.dfe.interfaces.process.mdfe.reception_sync.AfterReceptionSync;
import org.dfe.interfaces.process.mdfe.reception_sync.BeforeReceptionSync;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public final class FileSystemStoreReceptionSyncMdfeFactory extends ReceptionSyncMdfeProcessFactory {

    private final Collection<AfterReceptionSync> after = Arrays.asList(new FileSystemStoreReturnReceptionSyncMdfe(), new FileSystemStoreProcReceptionSyncMdfe());
    private final Collection<BeforeReceptionSync> before = Collections.singletonList(new FileSystemStoreReceptionSyncMdfe());


    @Override
    public Collection<BeforeReceptionSync> before() {
        return before;
    }

    @Override
    public Collection<AfterReceptionSync> after() {
        return after;
    }
}
