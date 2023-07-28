package com.softart.dfe.components.process.nf.query_register.impl.file;


import com.softart.dfe.components.process.nf.query_register.impl.QueryRegisterProcessFactory;
import com.softart.dfe.interfaces.process.nf.query_register.AfterQueryRegister;
import com.softart.dfe.interfaces.process.nf.query_register.BeforeQueryRegister;

import java.util.Collection;
import java.util.Collections;

public final class FileStoreFactory extends QueryRegisterProcessFactory {


    @Override
    public Collection<AfterQueryRegister> after() {
        return Collections.singletonList(new FileStoreReturnQueryRegister());
    }

    @Override
    public Collection<BeforeQueryRegister> before() {
        return Collections.singletonList(new FileStoreQueryRegister());
    }
}
