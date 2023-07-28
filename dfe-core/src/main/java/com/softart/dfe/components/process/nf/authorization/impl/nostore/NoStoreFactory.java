package com.softart.dfe.components.process.nf.authorization.impl.nostore;


import com.softart.dfe.components.process.nf.authorization.impl.AuthorizationProcessFactory;
import com.softart.dfe.interfaces.process.nf.authorization.AfterAuthorization;
import com.softart.dfe.interfaces.process.nf.authorization.BeforeAuthorization;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public final class NoStoreFactory extends AuthorizationProcessFactory {

    public Collection<AfterAuthorization> after() {
        return Arrays.asList(
                new NoStoreRetAuthorizationNfe(),
                new NoStoreProcAuthorizationNfe()
        );
    }


    public Collection<BeforeAuthorization> before() {
        return Collections.singletonList(
                new NoStoreAuthorizationNfe()
        );
    }


}
