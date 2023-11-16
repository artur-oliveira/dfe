package org.dfe.components.process.cte.reception.impl.file;

import org.dfe.components.process.cte.reception.impl.ReceptionCteProcessFactory;
import org.dfe.interfaces.process.cte.reception.AfterReception;
import org.dfe.interfaces.process.cte.reception.BeforeReception;

import java.util.Collection;
import java.util.Collections;

public final class FileSystemReceptionCteFactory extends ReceptionCteProcessFactory {

    @Override
    public Collection<BeforeReception> before() {
        return Collections.singletonList(new FileSystemReceptionCte());
    }

    @Override
    public Collection<AfterReception> after() {
        return Collections.singletonList(new FileSystemReturnReceptionCte());
    }
}
