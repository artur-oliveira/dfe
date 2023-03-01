package com.softart.dfe.components.process.nf.cancel.impl.nostore;

import com.softart.dfe.components.process.nf.cancel.impl.CancelProcessFactory;
import com.softart.dfe.interfaces.process.nf.cancel.AfterCancel;
import com.softart.dfe.interfaces.process.nf.cancel.BeforeCancel;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public final class NoStoreFactory extends CancelProcessFactory {

    @Override
    public Collection<BeforeCancel> before() {
        return Collections.singletonList(
                new NoStoreEventNfe()
        );
    }

    @Override
    public Collection<AfterCancel> after() {
        return Arrays.asList(
                new NoStoreRetEventNfe(),
                new NoStoreProcEventNfe()
        );
    }


}
