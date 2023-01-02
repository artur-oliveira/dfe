package com.softart.dfe.components.process.nf.cancel.impl;

import br.inf.portalfiscal.nfe.event_cancel.TEnvEvento;
import br.inf.portalfiscal.nfe.event_cancel.TRetEnvEvento;
import com.softart.dfe.components.process.nf.cancel.impl.file.FileStoreFactory;
import com.softart.dfe.components.process.nf.cancel.impl.nostore.NoStoreFactory;
import com.softart.dfe.interfaces.process.ProcessFactory;
import com.softart.dfe.interfaces.process.nf.cancel.AfterCancel;
import com.softart.dfe.interfaces.process.nf.cancel.BeforeCancel;

import java.util.Collection;

public abstract class CancelProcessFactory implements ProcessFactory<TEnvEvento, TRetEnvEvento> {

    public static CancelProcessFactory noStore() {
        return new NoStoreFactory();
    }

    public static CancelProcessFactory fileStore() {
        return new FileStoreFactory();
    }

    public abstract Collection<AfterCancel> after();

    public abstract Collection<BeforeCancel> before();

}
