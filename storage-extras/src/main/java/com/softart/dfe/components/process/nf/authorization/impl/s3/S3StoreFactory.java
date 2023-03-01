package com.softart.dfe.components.process.nf.authorization.impl.s3;


import com.softart.dfe.components.process.nf.authorization.impl.AuthorizationProcessFactory;
import com.softart.dfe.interfaces.process.nf.authorization.AfterAuthorization;
import com.softart.dfe.interfaces.process.nf.authorization.BeforeAuthorization;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

@SuppressWarnings("unused")
public final class S3StoreFactory extends AuthorizationProcessFactory {

    public Collection<AfterAuthorization> after() {
        return Arrays.asList(
                new S3RetAuthorizationNfe(),
                new S3ProcAuthorizationNfe()
        );
    }


    public Collection<BeforeAuthorization> before() {
        return Collections.singletonList(
                new S3AuthorizationNfe()
        );
    }


}
