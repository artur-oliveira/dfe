package com.softart.dfe.components.process.nf.return_authorization.impl;

import br.inf.portalfiscal.nfe.send.TConsReciNFe;
import br.inf.portalfiscal.nfe.send.TRetConsReciNFe;
import com.softart.dfe.components.process.nf.return_authorization.impl.file.FileStoreFactory;
import com.softart.dfe.components.process.nf.return_authorization.impl.nostore.NoStoreFactory;
import com.softart.dfe.components.process.nf.return_authorization.impl.s3.S3StoreFactory;
import com.softart.dfe.interfaces.process.ProcessFactory;
import com.softart.dfe.interfaces.process.nf.return_authorization.AfterReturnAuthorization;
import com.softart.dfe.interfaces.process.nf.return_authorization.BeforeReturnAuthorization;

import java.util.Collection;

public abstract class ReturnAuthorizationProcessFactory implements ProcessFactory<TConsReciNFe, TRetConsReciNFe> {

    public static ReturnAuthorizationProcessFactory noStore() {
        return Holder.NO_STORE;
    }

    public static ReturnAuthorizationProcessFactory fileStore() {
        return Holder.FILE_STORE;
    }

    public static ReturnAuthorizationProcessFactory s3() {
        return HolderS3.S3;
    }

    public abstract Collection<AfterReturnAuthorization> after();

    public abstract Collection<BeforeReturnAuthorization> before();


    private final static class HolderS3 {
        private final static ReturnAuthorizationProcessFactory S3 = new S3StoreFactory();
    }

    private final static class Holder {
        private final static ReturnAuthorizationProcessFactory NO_STORE = new NoStoreFactory();
        private final static ReturnAuthorizationProcessFactory FILE_STORE = new FileStoreFactory();
    }
}
