package com.softart.dfe.components.process.nf.correction_letter.impl.file;

import com.softart.dfe.components.process.nf.correction_letter.impl.CorrectionLetterProcessFactory;
import com.softart.dfe.interfaces.process.nf.correction_letter.AfterCorrectionLetter;
import com.softart.dfe.interfaces.process.nf.correction_letter.BeforeCorrectionLetter;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public final class FileStoreFactory extends CorrectionLetterProcessFactory {

    @Override
    public Collection<BeforeCorrectionLetter> before() {
        return Collections.singletonList(
                new FileStoreSendCorrectionLetterNfe()
        );
    }

    @Override
    public Collection<AfterCorrectionLetter> after() {
        return Arrays.asList(
                new FileStoreRetCorrectionLetterNfe(),
                new FileStoreProcCorrectionLetterNfe()
        );
    }


}
