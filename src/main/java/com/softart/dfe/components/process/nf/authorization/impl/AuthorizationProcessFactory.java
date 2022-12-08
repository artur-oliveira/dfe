package com.softart.dfe.components.process.nf.authorization.impl;

import br.inf.portalfiscal.nfe.send.TEnviNFe;
import br.inf.portalfiscal.nfe.send.TRetEnviNFe;
import com.softart.dfe.components.process.nf.authorization.impl.file.FileStoreFactory;
import com.softart.dfe.components.process.nf.authorization.impl.nostore.NoStoreFactory;
import com.softart.dfe.interfaces.process.ProcessFactory;
import com.softart.dfe.interfaces.process.nf.authorization.AfterAuthorization;
import com.softart.dfe.interfaces.process.nf.authorization.BeforeAuthorization;

import java.util.Collection;

public abstract class AuthorizationProcessFactory implements ProcessFactory<TEnviNFe, TRetEnviNFe> {

    public static AuthorizationProcessFactory noStore() {
        return new NoStoreFactory();
    }

    public static AuthorizationProcessFactory fileStore() {
        return new FileStoreFactory();
    }

    public abstract Collection<AfterAuthorization> after();

    public abstract Collection<BeforeAuthorization> before();
}
