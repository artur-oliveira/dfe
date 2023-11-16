package org.dfe.components.process.nf.authorization.impl.file;


import org.dfe.components.process.nf.authorization.impl.AuthorizationProcessFactory;
import org.dfe.interfaces.process.nf.authorization.AfterAuthorization;
import org.dfe.interfaces.process.nf.authorization.BeforeAuthorization;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public final class FileStoreFactory extends AuthorizationProcessFactory {

    public Collection<AfterAuthorization> after() {
        return Arrays.asList(
                new FileStoreRetAuthorizationNfe(),
                new FileStoreProcAuthorizationNfe()
        );
    }


    public Collection<BeforeAuthorization> before() {
        return Collections.singletonList(
                new FileStoreEnviNfe()
        );
    }


}
