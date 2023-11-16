package org.dfe.components.process.cte4.reception_gtve.impl.file;

import org.dfe.components.process.cte4.reception_gtve.impl.GtveProcessFactory;
import org.dfe.interfaces.process.cte4.reception_gtve.AfterReceptionGtve;
import org.dfe.interfaces.process.cte4.reception_gtve.BeforeReceptionGtve;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public final class FileSystemGtveFactory extends GtveProcessFactory {

    @Override
    public Collection<BeforeReceptionGtve> before() {
        return Collections.singletonList(new FileSystemGtve());
    }

    @Override
    public Collection<AfterReceptionGtve> after() {
        return Arrays.asList(new FileSystemReturnGtve(), new FileSystemProcGtve());
    }
}
