package com.softart.dfe.components.process.nf.query_protocol.impl;

import br.inf.portalfiscal.nfe.send.TConsSitNFe;
import br.inf.portalfiscal.nfe.send.TRetConsSitNFe;
import com.softart.dfe.components.process.nf.query_protocol.impl.file.FileStoreFactory;
import com.softart.dfe.components.process.nf.query_protocol.impl.nostore.NoStoreFactory;
import com.softart.dfe.interfaces.process.ProcessFactory;
import com.softart.dfe.interfaces.process.nf.query_protocol.AfterQueryProtocol;
import com.softart.dfe.interfaces.process.nf.query_protocol.BeforeQueryProtocol;

import java.util.Collection;

public abstract class QueryProtocolProcessFactory implements ProcessFactory<TConsSitNFe, TRetConsSitNFe> {

    public static QueryProtocolProcessFactory noStore() {
        return new NoStoreFactory();
    }

    public static QueryProtocolProcessFactory fileStore() {
        return new FileStoreFactory();
    }

    public abstract Collection<AfterQueryProtocol> after();

    public abstract Collection<BeforeQueryProtocol> before();
}
