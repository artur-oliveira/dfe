package com.softart.dfe.components.process.nf.correction_letter.impl;

import br.inf.portalfiscal.nfe.event_correction_letter.TEnvEvento;
import br.inf.portalfiscal.nfe.event_correction_letter.TRetEnvEvento;
import com.softart.dfe.components.process.nf.correction_letter.impl.file.FileStoreCorrectionLetterFactory;
import com.softart.dfe.components.process.nf.correction_letter.impl.nostore.NoStoreCorrectionLetterFactory;
import com.softart.dfe.interfaces.process.ProcessFactory;
import com.softart.dfe.interfaces.process.nf.correction_letter.AfterCorrectionLetter;
import com.softart.dfe.interfaces.process.nf.correction_letter.BeforeCorrectionLetter;

import java.util.Collection;

public abstract class CorrectionLetterProcessFactory implements ProcessFactory<TEnvEvento, TRetEnvEvento> {

    public static CorrectionLetterProcessFactory noStore() {
        return new NoStoreCorrectionLetterFactory();
    }

    public static CorrectionLetterProcessFactory fileStore() {
        return new FileStoreCorrectionLetterFactory();
    }

    public abstract Collection<AfterCorrectionLetter> after();

    public abstract Collection<BeforeCorrectionLetter> before();

}
