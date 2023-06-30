package com.softart.dfe.components.process.nf.substitute_cancel.impl.nostore;

import com.softart.dfe.components.process.nf.substitute_cancel.impl.SubstituteCancelProcessFactory;
import com.softart.dfe.interfaces.process.nf.substitute_cancel.AfterSubstituteCancel;
import com.softart.dfe.interfaces.process.nf.substitute_cancel.BeforeSubstituteCancel;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public final class NoStoreFactory extends SubstituteCancelProcessFactory {

    @Override
    public Collection<BeforeSubstituteCancel> before() {
        return Collections.singletonList(
                new NoStoreSubstituteCancelNfe()
        );
    }

    @Override
    public Collection<AfterSubstituteCancel> after() {
        return Arrays.asList(
                new NoStoreReturnSubstituteCancelNfe(),
                new NoStoreProcSubstituteCancelNfe()
        );
    }


}
