package com.softart.dfe.components.process.cte4.reception_gtve;

import br.inf.portalfiscal.cte.send400.TGTVe;
import com.softart.dfe.components.internal.xml.marshaller.CteMarshallerFactory;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.interfaces.process.BeforeRequest;
import com.softart.dfe.interfaces.process.cte4.reception_gtve.BeforeReceptionGtve;
import com.softart.dfe.interfaces.storage.cte4.CteReceptionGtveStorage;
import com.softart.dfe.models.internal.xml.XMLStore;

import java.util.Objects;

public abstract class StoreGtve implements BeforeReceptionGtve {

    @Override
    public <T extends BeforeRequest<TGTVe>> void process(T o) throws ProcessException {
        if (Objects.nonNull(o.request()) && Objects.nonNull(getStorage())) {
            getStorage().storeGtve(new XMLStore<>(o.request(), o.config(), CteMarshallerFactory.getInstance().receptionGtve(o.request())));
        }
    }

    protected abstract CteReceptionGtveStorage getStorage();
}
