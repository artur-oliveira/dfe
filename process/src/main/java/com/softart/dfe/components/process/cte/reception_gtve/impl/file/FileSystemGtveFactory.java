package com.softart.dfe.components.process.cte.reception_gtve.impl.file;

import com.softart.dfe.components.process.cte.reception_gtve.impl.GtveProcessFactory;
import com.softart.dfe.interfaces.process.cte.reception_gtve.AfterReceptionGtve;
import com.softart.dfe.interfaces.process.cte.reception_gtve.BeforeReceptionGtve;

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
