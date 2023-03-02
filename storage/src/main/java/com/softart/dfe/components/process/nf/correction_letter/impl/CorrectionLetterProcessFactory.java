package com.softart.dfe.components.process.nf.correction_letter.impl;

import br.inf.portalfiscal.nfe.event_correction_letter.TEnvEvento;
import br.inf.portalfiscal.nfe.event_correction_letter.TRetEnvEvento;
import com.softart.dfe.components.process.nf.correction_letter.impl.file.FileStoreFactory;
import com.softart.dfe.components.process.nf.correction_letter.impl.nostore.NoStoreFactory;
import com.softart.dfe.components.process.nf.correction_letter.impl.s3.S3StoreFactory;
import com.softart.dfe.interfaces.process.ProcessFactory;
import com.softart.dfe.interfaces.process.nf.correction_letter.AfterCorrectionLetter;
import com.softart.dfe.interfaces.process.nf.correction_letter.BeforeCorrectionLetter;
import com.softart.dfe.util.ReflectionUtils;
import com.softart.dfe.util.RequireUtils;

import java.util.Collection;

public abstract class CorrectionLetterProcessFactory implements ProcessFactory<TEnvEvento, TRetEnvEvento> {

    public static CorrectionLetterProcessFactory noStore() {
        return Holder.NO_STORE;
    }

    public static CorrectionLetterProcessFactory fileStore() {
        return Holder.FILE_STORE;
    }

    public static CorrectionLetterProcessFactory s3() {
        return RequireUtils.nonNull(Holder.S3, "com.softart.dfe.components.process.nf.correction_letter.impl.s3.S3StoreFactory is not initialized");
    }

    public abstract Collection<AfterCorrectionLetter> after();

    public abstract Collection<BeforeCorrectionLetter> before();

    private final static class Holder {
        private final static CorrectionLetterProcessFactory NO_STORE = new NoStoreFactory();
        private final static CorrectionLetterProcessFactory FILE_STORE = new FileStoreFactory();
        private final static CorrectionLetterProcessFactory S3 = ReflectionUtils.safeNewInstance(S3StoreFactory.class);
    }
}
