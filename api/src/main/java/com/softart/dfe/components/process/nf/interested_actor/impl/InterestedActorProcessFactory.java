package com.softart.dfe.components.process.nf.interested_actor.impl;

import br.inf.portalfiscal.nfe.event_interested_actor.TEnvEvento;
import br.inf.portalfiscal.nfe.event_interested_actor.TRetEnvEvento;
import com.softart.dfe.components.process.nf.interested_actor.impl.file.FileStoreInterestedActorFactory;
import com.softart.dfe.components.process.nf.interested_actor.impl.nostore.NoStoreInterestedActorFactory;
import com.softart.dfe.interfaces.process.ProcessFactory;
import com.softart.dfe.interfaces.process.nf.interested_actor.AfterInterestedActor;
import com.softart.dfe.interfaces.process.nf.interested_actor.BeforeInterestedActor;

import java.util.Collection;

public abstract class InterestedActorProcessFactory implements ProcessFactory<TEnvEvento, TRetEnvEvento> {

    public static InterestedActorProcessFactory noStore() {
        return new NoStoreInterestedActorFactory();
    }

    public static InterestedActorProcessFactory fileStore() {
        return new FileStoreInterestedActorFactory();
    }

    public abstract Collection<AfterInterestedActor> after();

    public abstract Collection<BeforeInterestedActor> before();

}
