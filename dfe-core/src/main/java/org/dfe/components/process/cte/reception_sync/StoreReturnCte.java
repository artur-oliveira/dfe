package org.dfe.components.process.cte.reception_sync;


import br.inf.portalfiscal.cte.send.TCTe;
import br.inf.portalfiscal.cte.send.TRetCTe;
import org.dfe.components.internal.xml.marshaller.CteMarshallerFactory;
import org.dfe.exceptions.ProcessException;
import org.dfe.interfaces.process.AfterRequest;
import org.dfe.interfaces.process.cte.reception_sync.AfterReceptionCteSync;
import org.dfe.interfaces.storage.cte.CteReceptionSyncStorage;
import org.dfe.models.internal.xml.XMLStore;

import java.util.Objects;

public abstract class StoreReturnCte implements AfterReceptionCteSync {

    @Override
    public <T extends AfterRequest<TCTe, TRetCTe>> void process(T o) throws ProcessException {
        if (Objects.nonNull(getStorage()) && Objects.nonNull(o.response())) {
            getStorage().storeReturnCteSync(new XMLStore<>(o.response(), o.config(), CteMarshallerFactory.getInstance().returnReceptionCteSync(o.response())));
        }
    }

    protected abstract CteReceptionSyncStorage getStorage();

}
