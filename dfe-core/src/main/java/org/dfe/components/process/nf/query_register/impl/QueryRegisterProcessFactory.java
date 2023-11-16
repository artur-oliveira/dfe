package org.dfe.components.process.nf.query_register.impl;

import br.inf.portalfiscal.nfe.send.TConsCad;
import br.inf.portalfiscal.nfe.send.TRetConsCad;
import org.dfe.components.process.nf.query_register.impl.file.FileStoreFactory;
import org.dfe.components.process.nf.query_register.impl.nostore.NoStoreFactory;
import org.dfe.components.process.nf.query_register.impl.s3.S3StoreFactory;
import org.dfe.interfaces.process.ProcessFactory;
import org.dfe.interfaces.process.nf.query_register.AfterQueryRegister;
import org.dfe.interfaces.process.nf.query_register.BeforeQueryRegister;

import java.util.Collection;

public abstract class QueryRegisterProcessFactory implements ProcessFactory<TConsCad, TRetConsCad> {

    public static QueryRegisterProcessFactory noStore() {
        return Holder.NO_STORE;
    }

    public static QueryRegisterProcessFactory fileStore() {
        return Holder.FILE_STORE;
    }

    public static QueryRegisterProcessFactory s3() {
        return HolderS3.S3;
    }

    public abstract Collection<AfterQueryRegister> after();

    public abstract Collection<BeforeQueryRegister> before();

    private final static class HolderS3 {
        private final static QueryRegisterProcessFactory S3 = new S3StoreFactory();
    }

    private final static class Holder {
        private final static QueryRegisterProcessFactory NO_STORE = new NoStoreFactory();
        private final static QueryRegisterProcessFactory FILE_STORE = new FileStoreFactory();
    }
}
