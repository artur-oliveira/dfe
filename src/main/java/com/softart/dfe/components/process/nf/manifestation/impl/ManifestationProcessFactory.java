package com.softart.dfe.components.process.nf.manifestation.impl;

import br.inf.portalfiscal.nfe.event_manifestation.TEnvEvento;
import br.inf.portalfiscal.nfe.event_manifestation.TRetEnvEvento;
import com.softart.dfe.components.process.nf.manifestation.impl.file.FileStoreFactory;
import com.softart.dfe.components.process.nf.manifestation.impl.nostore.NoStoreFactory;
import com.softart.dfe.interfaces.process.ProcessFactory;
import com.softart.dfe.interfaces.process.nf.manifestation.AfterManifestation;
import com.softart.dfe.interfaces.process.nf.manifestation.BeforeManifestation;

import java.util.Collection;

public abstract class ManifestationProcessFactory implements ProcessFactory<TEnvEvento, TRetEnvEvento> {

    public static ManifestationProcessFactory noStore() {
        return new NoStoreFactory();
    }

    public static ManifestationProcessFactory fileStore() {
        return new FileStoreFactory();
    }

    public abstract Collection<AfterManifestation> after();

    public abstract Collection<BeforeManifestation> before();

}
