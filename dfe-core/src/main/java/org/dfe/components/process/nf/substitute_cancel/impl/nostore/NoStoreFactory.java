package org.dfe.components.process.nf.substitute_cancel.impl.nostore;

import org.dfe.components.process.nf.substitute_cancel.impl.SubstituteCancelProcessFactory;
import org.dfe.interfaces.process.nf.substitute_cancel.AfterSubstituteCancel;
import org.dfe.interfaces.process.nf.substitute_cancel.BeforeSubstituteCancel;

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
