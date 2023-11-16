package org.dfe.components.process.nf.query_protocol.impl.file;


import org.dfe.components.process.nf.query_protocol.impl.QueryProtocolProcessFactory;
import org.dfe.interfaces.process.nf.query_protocol.AfterQueryProtocol;
import org.dfe.interfaces.process.nf.query_protocol.BeforeQueryProtocol;

import java.util.Collection;
import java.util.Collections;

public final class FileStoreFactory extends QueryProtocolProcessFactory {

    public Collection<AfterQueryProtocol> after() {
        return Collections.singletonList(
                new FileStoreReturnQueryProtocolNfe()
        );
    }


    public Collection<BeforeQueryProtocol> before() {
        return Collections.singletonList(
                new FileStoreQueryProtocolNfe()
        );
    }


}
