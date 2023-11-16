package org.dfe.components.process.nf.query_register.impl.nostore;

import org.dfe.components.process.nf.query_register.impl.QueryRegisterProcessFactory;
import org.dfe.interfaces.process.nf.query_register.AfterQueryRegister;
import org.dfe.interfaces.process.nf.query_register.BeforeQueryRegister;

import java.util.Collection;
import java.util.Collections;

public final class NoStoreFactory extends QueryRegisterProcessFactory {


    @Override
    public Collection<AfterQueryRegister> after() {
        return Collections.singletonList(new NoStoreReturnQueryRegister());
    }

    @Override
    public Collection<BeforeQueryRegister> before() {
        return Collections.singletonList(new NoStoreQueryRegister());
    }
}
