package com.softart.dfe.components.process.nf.substitute_cancel.impl;

import br.inf.portalfiscal.nfe.event_substitute_cancel.TEnvEvento;
import br.inf.portalfiscal.nfe.event_substitute_cancel.TRetEnvEvento;
import com.softart.dfe.components.process.nf.substitute_cancel.impl.file.FileStoreFactory;
import com.softart.dfe.components.process.nf.substitute_cancel.impl.nostore.NoStoreFactory;
import com.softart.dfe.interfaces.process.ProcessFactory;
import com.softart.dfe.interfaces.process.nf.substitute_cancel.AfterSubstituteCancel;
import com.softart.dfe.interfaces.process.nf.substitute_cancel.BeforeSubstituteCancel;

import java.util.Collection;

public abstract class SubstituteCancelProcessFactory implements ProcessFactory<TEnvEvento, TRetEnvEvento> {

    public static SubstituteCancelProcessFactory noStore() {
        return new NoStoreFactory();
    }

    public static SubstituteCancelProcessFactory fileStore() {
        return new FileStoreFactory();
    }

    public abstract Collection<AfterSubstituteCancel> after();

    public abstract Collection<BeforeSubstituteCancel> before();

}
