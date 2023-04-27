package com.softart.dfe.components.process.nf.authorization.impl;

import br.inf.portalfiscal.nfe.send.TEnviNFe;
import br.inf.portalfiscal.nfe.send.TRetEnviNFe;
import com.softart.dfe.components.process.nf.authorization.impl.file.FileStoreFactory;
import com.softart.dfe.components.process.nf.authorization.impl.nostore.NoStoreFactory;
import com.softart.dfe.components.process.nf.authorization.impl.s3.S3StoreFactory;
import com.softart.dfe.interfaces.process.ProcessFactory;
import com.softart.dfe.interfaces.process.nf.authorization.AfterAuthorization;
import com.softart.dfe.interfaces.process.nf.authorization.BeforeAuthorization;

import java.util.Collection;

public abstract class AuthorizationProcessFactory implements ProcessFactory<TEnviNFe, TRetEnviNFe> {

    public static AuthorizationProcessFactory noStore() {
        return Holder.NO_STORE;
    }

    public static AuthorizationProcessFactory fileStore() {
        return Holder.FILE_STORE;
    }

    public static AuthorizationProcessFactory s3() {
        return HolderS3.S3;
    }

    public abstract Collection<AfterAuthorization> after();

    public abstract Collection<BeforeAuthorization> before();

    private final static class HolderS3 {
        private final static AuthorizationProcessFactory S3 = new S3StoreFactory();
    }

    private final static class Holder {
        private final static AuthorizationProcessFactory NO_STORE = new NoStoreFactory();
        private final static AuthorizationProcessFactory FILE_STORE = new FileStoreFactory();
    }
}
