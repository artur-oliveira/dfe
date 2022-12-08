package com.softart.dfe.components.process.nf.manifestation.impl.nostore;

import com.softart.dfe.components.process.nf.manifestation.impl.ManifestationProcessFactory;
import com.softart.dfe.interfaces.process.nf.manifestation.AfterManifestation;
import com.softart.dfe.interfaces.process.nf.manifestation.BeforeManifestation;

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
