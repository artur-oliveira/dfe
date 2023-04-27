package com.softart.dfe.components.process.cte.reception_sync;

import br.inf.portalfiscal.cte.send.TCTe;
import com.softart.dfe.components.internal.xml.marshaller.CteMarshallerFactory;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.interfaces.process.BeforeRequest;
import com.softart.dfe.interfaces.process.cte.reception_sync.BeforeReceptionCteSync;
import com.softart.dfe.interfaces.storage.cte.CteReceptionSyncStorage;
import com.softart.dfe.models.internal.xml.XMLStore;

import java.util.Objects;

public abstract class StoreCte implements BeforeReceptionCteSync {

    @Override
    public <T extends BeforeRequest<TCTe>> void process(T o) throws ProcessException {
        if (Objects.nonNull(o.getRequest()) && Objects.nonNull(getStorage())) {
            getStorage().storeCteSync(new XMLStore<>(o.getRequest(), o.getConfig(), CteMarshallerFactory.getInstance().receptionCteSync(o.getRequest())));
        }
    }

    protected abstract CteReceptionSyncStorage getStorage();
}
