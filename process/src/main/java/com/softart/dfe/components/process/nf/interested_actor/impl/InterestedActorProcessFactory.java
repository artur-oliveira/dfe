package com.softart.dfe.components.process.nf.interested_actor.impl;

import br.inf.portalfiscal.nfe.event_interested_actor.TEnvEvento;
import br.inf.portalfiscal.nfe.event_interested_actor.TRetEnvEvento;
import com.softart.dfe.components.process.nf.interested_actor.impl.file.FileStoreInterestedActorFactory;
import com.softart.dfe.components.process.nf.interested_actor.impl.nostore.NoStoreInterestedActorFactory;
import com.softart.dfe.components.process.nf.interested_actor.impl.s3.S3StoreFactory;
import com.softart.dfe.interfaces.process.ProcessFactory;
import com.softart.dfe.interfaces.process.nf.interested_actor.AfterInterestedActor;
import com.softart.dfe.interfaces.process.nf.interested_actor.BeforeInterestedActor;

import java.util.Collection;

public abstract class InterestedActorProcessFactory implements ProcessFactory<TEnvEvento, TRetEnvEvento> {

    public static InterestedActorProcessFactory noStore() {
        return Holder.NO_STORE;
    }

    public static InterestedActorProcessFactory fileStore() {
        return Holder.FILE_STORE;
    }

    public static InterestedActorProcessFactory s3() {
        return HolderS3.S3;
    }

    public abstract Collection<AfterInterestedActor> after();

    public abstract Collection<BeforeInterestedActor> before();

    private final static class HolderS3 {
        private final static InterestedActorProcessFactory S3 = new S3StoreFactory();
    }

    private final static class Holder {
        private final static InterestedActorProcessFactory NO_STORE = new NoStoreInterestedActorFactory();
        private final static InterestedActorProcessFactory FILE_STORE = new FileStoreInterestedActorFactory();
    }

}
