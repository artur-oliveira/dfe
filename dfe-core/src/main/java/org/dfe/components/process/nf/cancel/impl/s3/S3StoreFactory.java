package org.dfe.components.process.nf.cancel.impl.s3;

import org.dfe.components.process.nf.cancel.impl.CancelProcessFactory;
import org.dfe.interfaces.process.nf.cancel.AfterCancel;
import org.dfe.interfaces.process.nf.cancel.BeforeCancel;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

@SuppressWarnings("unused")
public final class S3StoreFactory extends CancelProcessFactory {

    @Override
    public Collection<BeforeCancel> before() {
        return Collections.singletonList(
                new S3StoreEventNfe()
        );
    }

    @Override
    public Collection<AfterCancel> after() {
        return Arrays.asList(
                new S3RetEventNfe(),
                new S3ProcEventNfe()
        );
    }


}
