package com.softart.dfe.components.process.nf.substitute_cancel.impl;

import br.inf.portalfiscal.nfe.event_substitute_cancel.TEnvEvento;
import br.inf.portalfiscal.nfe.event_substitute_cancel.TRetEnvEvento;
import com.softart.dfe.components.process.nf.substitute_cancel.impl.file.FileStoreFactory;
import com.softart.dfe.components.process.nf.substitute_cancel.impl.nostore.NoStoreFactory;
import com.softart.dfe.components.process.nf.substitute_cancel.impl.s3.S3StoreFactory;
import com.softart.dfe.interfaces.process.ProcessFactory;
import com.softart.dfe.interfaces.process.nf.substitute_cancel.AfterSubstituteCancel;
import com.softart.dfe.interfaces.process.nf.substitute_cancel.BeforeSubstituteCancel;
import com.softart.dfe.util.ReflectionUtils;
import com.softart.dfe.util.RequireUtils;

import java.util.Collection;

public abstract class SubstituteCancelProcessFactory implements ProcessFactory<TEnvEvento, TRetEnvEvento> {

    public static SubstituteCancelProcessFactory noStore() {
        return Holder.NO_STORE;
    }

    public static SubstituteCancelProcessFactory fileStore() {
        return Holder.FILE_STORE;
    }

    public static SubstituteCancelProcessFactory s3() {
        return RequireUtils.nonNull(Holder.S3, "com.softart.dfe.components.process.nf.substitute_cancel.s3.S3StoreFactory is not initialized");
    }

    public abstract Collection<AfterSubstituteCancel> after();

    public abstract Collection<BeforeSubstituteCancel> before();

    static final class Holder {
        static final SubstituteCancelProcessFactory NO_STORE = new NoStoreFactory();
        static final SubstituteCancelProcessFactory FILE_STORE = new FileStoreFactory();

        private final static SubstituteCancelProcessFactory S3 = ReflectionUtils.safeNewInstance(S3StoreFactory.class);

    }

}
