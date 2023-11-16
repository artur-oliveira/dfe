package org.dfe.components.process.nf.query_register.impl.s3;

import org.dfe.components.process.nf.query_register.impl.QueryRegisterProcessFactory;
import org.dfe.interfaces.process.nf.query_register.AfterQueryRegister;
import org.dfe.interfaces.process.nf.query_register.BeforeQueryRegister;

import java.util.Collection;
import java.util.Collections;

public final class S3StoreFactory extends QueryRegisterProcessFactory {


    @Override
    public Collection<AfterQueryRegister> after() {
        return Collections.singletonList(new S3StoreReturnQueryRegister());
    }

    @Override
    public Collection<BeforeQueryRegister> before() {
        return Collections.singletonList(new S3StoreQueryRegister());
    }
}
