package org.dfe.components.process.nf.manifestation.impl.s3;

import org.dfe.components.process.nf.manifestation.impl.ManifestationProcessFactory;
import org.dfe.interfaces.process.nf.manifestation.AfterManifestation;
import org.dfe.interfaces.process.nf.manifestation.BeforeManifestation;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public final class S3StoreFactory extends ManifestationProcessFactory {

    @Override
    public Collection<BeforeManifestation> before() {
        return Collections.singletonList(
                new S3StoreSendManifestationNfe()
        );
    }

    @Override
    public Collection<AfterManifestation> after() {
        return Arrays.asList(
                new S3StoreRetManifestationNfe(),
                new S3StoreProcManifestationNfe()
        );
    }


}
