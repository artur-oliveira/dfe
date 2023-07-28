package com.softart.dfe.components.process.nf.query_protocol.impl;

import br.inf.portalfiscal.nfe.send.TConsSitNFe;
import br.inf.portalfiscal.nfe.send.TRetConsSitNFe;
import com.softart.dfe.components.process.nf.query_protocol.impl.file.FileStoreFactory;
import com.softart.dfe.components.process.nf.query_protocol.impl.nostore.NoStoreFactory;
import com.softart.dfe.components.process.nf.query_protocol.impl.s3.S3StoreFactory;
import com.softart.dfe.interfaces.process.ProcessFactory;
import com.softart.dfe.interfaces.process.nf.query_protocol.AfterQueryProtocol;
import com.softart.dfe.interfaces.process.nf.query_protocol.BeforeQueryProtocol;

import java.util.Collection;

public abstract class QueryProtocolProcessFactory implements ProcessFactory<TConsSitNFe, TRetConsSitNFe> {

    public static QueryProtocolProcessFactory noStore() {
        return Holder.NO_STORE;
    }

    public static QueryProtocolProcessFactory fileStore() {
        return Holder.FILE_STORE;
    }

    public static QueryProtocolProcessFactory s3() {
        return HolderS3.S3;
    }

    public abstract Collection<AfterQueryProtocol> after();

    public abstract Collection<BeforeQueryProtocol> before();

    private final static class HolderS3 {
        private final static QueryProtocolProcessFactory S3 = new S3StoreFactory();
    }

    private final static class Holder {
        private final static QueryProtocolProcessFactory NO_STORE = new NoStoreFactory();
        private final static QueryProtocolProcessFactory FILE_STORE = new FileStoreFactory();
    }
}
