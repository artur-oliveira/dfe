package org.dfe.components.process.nf.return_authorization.impl.nostore;


import org.dfe.components.process.nf.return_authorization.impl.ReturnAuthorizationProcessFactory;
import org.dfe.interfaces.process.nf.return_authorization.AfterReturnAuthorization;
import org.dfe.interfaces.process.nf.return_authorization.BeforeReturnAuthorization;

import java.util.Collection;
import java.util.Collections;

public final class NoStoreFactory extends ReturnAuthorizationProcessFactory {

    public Collection<AfterReturnAuthorization> after() {
        return Collections.singletonList(
                new NoStoreReturnQueryReceiptNfe()
        );
    }


    public Collection<BeforeReturnAuthorization> before() {
        return Collections.singletonList(
                new NoStoreQueryReceiptNfe()
        );
    }


}
