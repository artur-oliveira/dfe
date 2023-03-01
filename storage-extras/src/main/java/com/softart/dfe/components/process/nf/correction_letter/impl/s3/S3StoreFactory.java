package com.softart.dfe.components.process.nf.correction_letter.impl.s3;

import com.softart.dfe.components.process.nf.correction_letter.impl.CorrectionLetterProcessFactory;
import com.softart.dfe.interfaces.process.nf.correction_letter.AfterCorrectionLetter;
import com.softart.dfe.interfaces.process.nf.correction_letter.BeforeCorrectionLetter;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

@SuppressWarnings("unused")
public final class S3StoreFactory extends CorrectionLetterProcessFactory {

    @Override
    public Collection<BeforeCorrectionLetter> before() {
        return Collections.singletonList(
                new S3StoreSendCorrectionLetterNfe()
        );
    }

    @Override
    public Collection<AfterCorrectionLetter> after() {
        return Arrays.asList(
                new S3StoreRetCorrectionLetterNfe(),
                new S3StoreProcCorrectionLetterNfe()
        );
    }


}
