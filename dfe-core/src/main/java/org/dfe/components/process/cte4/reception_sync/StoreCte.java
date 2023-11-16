package org.dfe.components.process.cte4.reception_sync;

import br.inf.portalfiscal.cte.send400.TCTe;
import org.dfe.components.internal.xml.marshaller.CteMarshallerFactory;
import org.dfe.exceptions.ProcessException;
import org.dfe.interfaces.process.BeforeRequest;
import org.dfe.interfaces.process.cte4.reception_sync.BeforeReceptionCteSync;
import org.dfe.interfaces.storage.cte4.CteReceptionSyncStorage;
import org.dfe.models.internal.xml.XMLStore;

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
