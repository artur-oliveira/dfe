package org.dfe.components.process.cte.reception;

import br.inf.portalfiscal.cte.send.TEnviCTe;
import br.inf.portalfiscal.cte.send.TRetEnviCTe;
import org.dfe.components.internal.xml.marshaller.CteMarshallerFactory;
import org.dfe.exceptions.ProcessException;
import org.dfe.interfaces.process.AfterRequest;
import org.dfe.interfaces.process.cte.reception.AfterReception;
import org.dfe.interfaces.storage.cte.CteReceptionStorage;
import org.dfe.models.internal.xml.XMLStore;

import java.util.Objects;

public abstract class StoreReturnReceptionCte implements AfterReception {

    @Override
    public <T extends AfterRequest<TEnviCTe, TRetEnviCTe>> void process(T o) throws ProcessException {
        if (Objects.nonNull(o.response()) && Objects.nonNull(getStorage())) {
            getStorage().storeReturnCte(new XMLStore<>(o.response(), o.config(), CteMarshallerFactory.getInstance().returnReceptionCte(o.response())));
        }
    }

    protected abstract CteReceptionStorage getStorage();

}
