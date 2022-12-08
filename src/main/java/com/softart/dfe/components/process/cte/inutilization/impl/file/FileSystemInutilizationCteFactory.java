package com.softart.dfe.components.process.cte.inutilization.impl.file;

import com.softart.dfe.components.process.cte.inutilization.impl.InutilizationCteProcessFactory;
import com.softart.dfe.interfaces.process.cte.inutilization.AfterInutilization;
import com.softart.dfe.interfaces.process.cte.inutilization.BeforeInutilization;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public final class FileSystemInutilizationCteFactory extends InutilizationCteProcessFactory {

    @Override
    public Collection<BeforeInutilization> before() {
        return Collections.singletonList(new FileSystemInutilizationCte());
    }

    @Override
    public Collection<AfterInutilization> after() {
        return Arrays.asList(new FileSystemReturnInutilizationCte(), new FileSystemProcInutilizationCte());
    }
}
