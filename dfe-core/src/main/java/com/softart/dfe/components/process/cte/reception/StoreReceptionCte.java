package com.softart.dfe.components.process.cte.reception;

import br.inf.portalfiscal.cte.send.TEnviCTe;
import com.softart.dfe.components.internal.xml.marshaller.CteMarshallerFactory;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.interfaces.process.BeforeRequest;
import com.softart.dfe.interfaces.process.cte.reception.BeforeReception;
import com.softart.dfe.interfaces.storage.cte.CteReceptionStorage;
import com.softart.dfe.models.internal.xml.XMLStore;

import java.util.Objects;

public abstract class StoreReceptionCte implements BeforeReception {

    @Override
    public <T extends BeforeRequest<TEnviCTe>> void process(T o) throws ProcessException {
        if (Objects.nonNull(o.request()) && Objects.nonNull(getStorage())) {
            getStorage().storeCte(new XMLStore<>(o.request(), o.config(), CteMarshallerFactory.getInstance().receptionCte(o.request())));
        }
    }

    protected abstract CteReceptionStorage getStorage();
}
