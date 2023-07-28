package com.softart.dfe.components.process.cte4.reception_sync;

import br.inf.portalfiscal.cte.send400.TCTe;
import com.softart.dfe.components.internal.xml.marshaller.CteMarshallerFactory;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.interfaces.process.BeforeRequest;
import com.softart.dfe.interfaces.process.cte4.reception_sync.BeforeReceptionCteSync;
import com.softart.dfe.interfaces.storage.cte4.CteReceptionSyncStorage;
import com.softart.dfe.models.internal.xml.XMLStore;

import java.util.Objects;

public abstract class StoreCte implements BeforeReceptionCteSync {

    @Override
    public <T extends BeforeRequest<TCTe>> void process(T o) throws ProcessException {
        if (Objects.nonNull(o.request()) && Objects.nonNull(getStorage())) {
            getStorage().storeCteSync(new XMLStore<>(o.request(), o.config(), CteMarshallerFactory.getInstance().receptionCteSync(o.request())));
        }
    }

    protected abstract CteReceptionSyncStorage getStorage();
}
