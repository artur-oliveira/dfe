package org.dfe.components.process.cte.reception_os.impl.file;

import org.dfe.components.process.cte.reception_os.impl.CteOsProcessFactory;
import org.dfe.interfaces.process.cte.reception_os.AfterReceptionCteOs;
import org.dfe.interfaces.process.cte.reception_os.BeforeReceptionCteOs;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public final class FileSystemCteOsFactory extends CteOsProcessFactory {

    @Override
    public Collection<BeforeReceptionCteOs> before() {
        return Collections.singletonList(new FileSystemCteOs());
    }

    @Override
    public Collection<AfterReceptionCteOs> after() {
        return Arrays.asList(new FileSystemReturnCteOs(), new FileSystemProcCteOs());
    }
}
