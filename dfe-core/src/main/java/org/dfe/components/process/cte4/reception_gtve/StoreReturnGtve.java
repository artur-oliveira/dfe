package org.dfe.components.process.cte4.reception_gtve;


import br.inf.portalfiscal.cte.send400.TGTVe;
import br.inf.portalfiscal.cte.send400.TRetGTVe;
import org.dfe.components.internal.xml.marshaller.CteMarshallerFactory;
import org.dfe.exceptions.ProcessException;
import org.dfe.interfaces.process.AfterRequest;
import org.dfe.interfaces.process.cte4.reception_gtve.AfterReceptionGtve;
import org.dfe.interfaces.storage.cte4.CteReceptionGtveStorage;
import org.dfe.models.internal.xml.XMLStore;

import java.util.Objects;

public abstract class StoreReturnGtve implements AfterReceptionGtve {

    @Override
    public <T extends AfterRequest<TGTVe, TRetGTVe>> void process(T o) throws ProcessException {
        if (Objects.nonNull(getStorage()) && Objects.nonNull(o.response())) {
            getStorage().storeReturnGtve(new XMLStore<>(o.response(), o.config(), CteMarshallerFactory.getInstance().returnReceptionGtve(o.response())));
        }
    }

    protected abstract CteReceptionGtveStorage getStorage();

}
