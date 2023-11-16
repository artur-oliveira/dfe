package org.dfe.components.process.nf.authorization.impl.s3;


import org.dfe.components.process.nf.authorization.impl.AuthorizationProcessFactory;
import org.dfe.interfaces.process.nf.authorization.AfterAuthorization;
import org.dfe.interfaces.process.nf.authorization.BeforeAuthorization;

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
