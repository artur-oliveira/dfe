package com.softart.dfe.components.process.nf.manifestation.impl;

import br.inf.portalfiscal.nfe.event_manifestation.TEnvEvento;
import br.inf.portalfiscal.nfe.event_manifestation.TRetEnvEvento;
import com.softart.dfe.components.process.nf.manifestation.impl.file.FileStoreFactory;
import com.softart.dfe.components.process.nf.manifestation.impl.nostore.NoStoreFactory;
import com.softart.dfe.components.process.nf.manifestation.impl.s3.S3StoreFactory;
import com.softart.dfe.interfaces.process.ProcessFactory;
import com.softart.dfe.interfaces.process.nf.manifestation.AfterManifestation;
import com.softart.dfe.interfaces.process.nf.manifestation.BeforeManifestation;

import java.util.Collection;

public abstract class ManifestationProcessFactory implements ProcessFactory<TEnvEvento, TRetEnvEvento> {

    public static ManifestationProcessFactory noStore() {
        return Holder.NO_STORE;
    }

    public static ManifestationProcessFactory fileStore() {
        return Holder.FILE_STORE;
    }

    public static ManifestationProcessFactory s3() {
        return HolderS3.S3;
    }

    public abstract Collection<AfterManifestation> after();

    public abstract Collection<BeforeManifestation> before();

    private final static class HolderS3 {
        private final static ManifestationProcessFactory S3 = new S3StoreFactory();
    }

    private final static class Holder {
        private final static ManifestationProcessFactory NO_STORE = new NoStoreFactory();
        private final static ManifestationProcessFactory FILE_STORE = new FileStoreFactory();
    }
}
