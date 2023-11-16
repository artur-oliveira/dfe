package org.dfe.components.process.cte.reception_gtve;

import br.inf.portalfiscal.cte.send.TGTVe;
import org.dfe.components.internal.xml.marshaller.CteMarshallerFactory;
import org.dfe.exceptions.ProcessException;
import org.dfe.interfaces.process.BeforeRequest;
import org.dfe.interfaces.process.cte.reception_gtve.BeforeReceptionGtve;
import org.dfe.interfaces.storage.cte.CteReceptionGtveStorage;
import org.dfe.models.internal.xml.XMLStore;

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
