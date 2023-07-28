package com.softart.dfe.components.process.nf.substitute_cancel.impl.file;

import com.softart.dfe.components.process.nf.substitute_cancel.impl.SubstituteCancelProcessFactory;
import com.softart.dfe.interfaces.process.nf.substitute_cancel.AfterSubstituteCancel;
import com.softart.dfe.interfaces.process.nf.substitute_cancel.BeforeSubstituteCancel;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public final class FileStoreFactory extends SubstituteCancelProcessFactory {

    @Override
    public Collection<BeforeSubstituteCancel> before() {
        return Collections.singletonList(
                new FileStoreSubstituteCancelNfe()
        );
    }

    @Override
    public Collection<AfterSubstituteCancel> after() {
        return Arrays.asList(
                new FileStoreReturnSubstituteCancelNfe(),
                new FileStoreProcSubstituteCancelNfe()
        );
    }


}
