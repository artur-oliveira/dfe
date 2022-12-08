package com.softart.dfe.components.process.nf.return_authorization.impl;

import br.inf.portalfiscal.nfe.send.TConsReciNFe;
import br.inf.portalfiscal.nfe.send.TRetConsReciNFe;
import com.softart.dfe.components.process.nf.return_authorization.impl.file.FileStoreFactory;
import com.softart.dfe.components.process.nf.return_authorization.impl.nostore.NoStoreFactory;
import com.softart.dfe.interfaces.process.ProcessFactory;
import com.softart.dfe.interfaces.process.nf.return_authorization.AfterReturnAuthorization;
import com.softart.dfe.interfaces.process.nf.return_authorization.BeforeReturnAuthorization;

import java.util.Collection;

public abstract class ReturnAuthorizationProcessFactory implements ProcessFactory<TConsReciNFe, TRetConsReciNFe> {

    public static ReturnAuthorizationProcessFactory noStore() {
        return new NoStoreFactory();
    }

    public static ReturnAuthorizationProcessFactory fileStore() {
        return new FileStoreFactory();
    }

    public abstract Collection<AfterReturnAuthorization> after();

    public abstract Collection<BeforeReturnAuthorization> before();
}
