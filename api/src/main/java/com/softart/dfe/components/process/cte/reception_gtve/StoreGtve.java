package com.softart.dfe.components.process.cte.reception_gtve;

import br.inf.portalfiscal.cte.send.TGTVe;
import com.softart.dfe.components.internal.xml.marshaller.CteMarshallerFactory;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.interfaces.process.BeforeRequest;
import com.softart.dfe.interfaces.process.cte.reception_gtve.BeforeReceptionGtve;
import com.softart.dfe.interfaces.storage.cte.CteReceptionGtveStorage;
import com.softart.dfe.models.internal.xml.XMLStore;

import java.util.Objects;

public abstract class StoreGtve implements BeforeReceptionGtve {

    @Override
    public <T extends BeforeRequest<TGTVe>> void process(T o) throws ProcessException {
        if (Objects.nonNull(o.getRequest()) && Objects.nonNull(getStorage())) {
            getStorage().storeGtve(new XMLStore<>(o.getRequest(), o.getConfig(), CteMarshallerFactory.getInstance().receptionGtve(o.getRequest())));
        }
    }

    protected abstract CteReceptionGtveStorage getStorage();
}
