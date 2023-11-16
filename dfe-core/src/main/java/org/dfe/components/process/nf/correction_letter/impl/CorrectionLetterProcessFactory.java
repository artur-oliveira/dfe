package org.dfe.components.process.nf.correction_letter.impl;

import br.inf.portalfiscal.nfe.event_correction_letter.TEnvEvento;
import br.inf.portalfiscal.nfe.event_correction_letter.TRetEnvEvento;
import org.dfe.components.process.nf.correction_letter.impl.file.FileStoreFactory;
import org.dfe.components.process.nf.correction_letter.impl.nostore.NoStoreFactory;
import org.dfe.components.process.nf.correction_letter.impl.s3.S3StoreFactory;
import org.dfe.interfaces.process.ProcessFactory;
import org.dfe.interfaces.process.nf.correction_letter.AfterCorrectionLetter;
import org.dfe.interfaces.process.nf.correction_letter.BeforeCorrectionLetter;

import java.util.Collection;

public abstract class CorrectionLetterProcessFactory implements ProcessFactory<TEnvEvento, TRetEnvEvento> {

    public static CorrectionLetterProcessFactory noStore() {
        return Holder.NO_STORE;
    }

    public static CorrectionLetterProcessFactory fileStore() {
        return Holder.FILE_STORE;
    }

    public static CorrectionLetterProcessFactory s3() {
        return HolderS3.S3;
    }

    public abstract Collection<AfterCorrectionLetter> after();

    public abstract Collection<BeforeCorrectionLetter> before();

    private final static class HolderS3 {
        private final static CorrectionLetterProcessFactory S3 = new S3StoreFactory();
    }

    private final static class Holder {
        private final static CorrectionLetterProcessFactory NO_STORE = new NoStoreFactory();
        private final static CorrectionLetterProcessFactory FILE_STORE = new FileStoreFactory();
    }
}
