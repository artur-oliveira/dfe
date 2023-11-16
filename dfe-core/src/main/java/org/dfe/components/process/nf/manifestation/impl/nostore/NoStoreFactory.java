package org.dfe.components.process.nf.manifestation.impl.nostore;

import org.dfe.components.process.nf.manifestation.impl.ManifestationProcessFactory;
import org.dfe.interfaces.process.nf.manifestation.AfterManifestation;
import org.dfe.interfaces.process.nf.manifestation.BeforeManifestation;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public final class NoStoreFactory extends ManifestationProcessFactory {

    @Override
    public Collection<BeforeManifestation> before() {
        return Collections.singletonList(
                new NoStoreSendManifestationNfe()
        );
    }

    @Override
    public Collection<AfterManifestation> after() {
        return Arrays.asList(
                new NoStoreRetEventNfe(),
                new NoStoreProcEventNfe()
        );
    }


}
