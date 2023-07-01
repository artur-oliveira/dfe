package com.softart.dfe.components.process.cte4.reception_gtve.impl.s3;

import com.softart.dfe.components.process.cte4.reception_gtve.impl.GtveProcessFactory;
import com.softart.dfe.interfaces.process.cte4.reception_gtve.AfterReceptionGtve;
import com.softart.dfe.interfaces.process.cte4.reception_gtve.BeforeReceptionGtve;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public final class S3StoreGtveFactory extends GtveProcessFactory {

    @Override
    public Collection<BeforeReceptionGtve> before() {
        return Collections.singletonList(new S3StoreGtve());
    }

    @Override
    public Collection<AfterReceptionGtve> after() {
        return Arrays.asList(new S3StoreReturnGtve(), new S3StoreProcGtve());
    }
}
