package org.dfe.components.process.nf.correction_letter.impl.nostore;

import org.dfe.components.process.nf.correction_letter.impl.CorrectionLetterProcessFactory;
import org.dfe.interfaces.process.nf.correction_letter.AfterCorrectionLetter;
import org.dfe.interfaces.process.nf.correction_letter.BeforeCorrectionLetter;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public final class NoStoreFactory extends CorrectionLetterProcessFactory {

    @Override
    public Collection<BeforeCorrectionLetter> before() {
        return Collections.singletonList(
                new NoStoreCorrectionLetterNfe()
        );
    }

    @Override
    public Collection<AfterCorrectionLetter> after() {
        return Arrays.asList(
                new NoStoreRetCorrectionLetterNfe(),
                new NoStoreProcCorrectionLetterNfe()
        );
    }


}
