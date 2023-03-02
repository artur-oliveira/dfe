package com.softart.dfe.components.process.nf.manifestation.impl;

import br.inf.portalfiscal.nfe.event_manifestation.TEnvEvento;
import br.inf.portalfiscal.nfe.event_manifestation.TRetEnvEvento;
import com.softart.dfe.components.process.nf.manifestation.impl.file.FileStoreFactory;
import com.softart.dfe.components.process.nf.manifestation.impl.nostore.NoStoreFactory;
import com.softart.dfe.components.process.nf.manifestation.impl.s3.S3StoreFactory;
import com.softart.dfe.interfaces.process.ProcessFactory;
import com.softart.dfe.interfaces.process.nf.manifestation.AfterManifestation;
import com.softart.dfe.interfaces.process.nf.manifestation.BeforeManifestation;
import com.softart.dfe.util.ReflectionUtils;
import com.softart.dfe.util.RequireUtils;

import java.util.Collection;

public abstract class ManifestationProcessFactory implements ProcessFactory<TEnvEvento, TRetEnvEvento> {

    public static ManifestationProcessFactory noStore() {
        return Holder.NO_STORE;
    }

    public static ManifestationProcessFactory fileStore() {
        return Holder.FILE_STORE;
    }

    public static ManifestationProcessFactory s3() {
        return RequireUtils.nonNull(Holder.S3, "com.softart.dfe.components.process.nf.inut.manifestation.s3.S3StoreFactory is not initialized");
    }

    public abstract Collection<AfterManifestation> after();

    public abstract Collection<BeforeManifestation> before();

    private final static class Holder {
        private final static ManifestationProcessFactory NO_STORE = new NoStoreFactory();
        private final static ManifestationProcessFactory FILE_STORE = new FileStoreFactory();
        private final static ManifestationProcessFactory S3 = ReflectionUtils.safeNewInstance(S3StoreFactory.class);
    }
}
