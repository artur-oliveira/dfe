package com.softart.dfe.components.process.nf.substitute_cancel.impl.s3;

import com.softart.dfe.components.process.nf.substitute_cancel.impl.SubstituteCancelProcessFactory;
import com.softart.dfe.interfaces.process.nf.substitute_cancel.AfterSubstituteCancel;
import com.softart.dfe.interfaces.process.nf.substitute_cancel.BeforeSubstituteCancel;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public final class S3StoreFactory extends SubstituteCancelProcessFactory {

    @Override
    public Collection<BeforeSubstituteCancel> before() {
        return Collections.singletonList(
                new S3StoreSubstituteCancelNfe()
        );
    }

    @Override
    public Collection<AfterSubstituteCancel> after() {
        return Arrays.asList(
                new S3StoreReturnSubstituteCancelNfe(),
                new S3StoreProcSubstituteCancelNfe()
        );
    }


}
