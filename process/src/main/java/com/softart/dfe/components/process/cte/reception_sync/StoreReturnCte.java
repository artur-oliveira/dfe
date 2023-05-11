package com.softart.dfe.components.process.cte.reception_sync;


import br.inf.portalfiscal.cte.send.TCTe;
import br.inf.portalfiscal.cte.send.TRetCTe;
import com.softart.dfe.components.internal.xml.marshaller.CteMarshallerFactory;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.interfaces.process.AfterRequest;
import com.softart.dfe.interfaces.process.cte.reception_sync.AfterReceptionCteSync;
import com.softart.dfe.interfaces.storage.cte.CteReceptionSyncStorage;
import com.softart.dfe.models.internal.xml.XMLStore;

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
