package org.dfe.components.process.cte4.reception_os;


import br.inf.portalfiscal.cte.send400.TCTeOS;
import br.inf.portalfiscal.cte.send400.TRetCTeOS;
import org.dfe.components.internal.xml.marshaller.CteMarshallerFactory;
import org.dfe.exceptions.ProcessException;
import org.dfe.interfaces.process.AfterRequest;
import org.dfe.interfaces.process.cte4.reception_os.AfterReceptionCteOs;
import org.dfe.interfaces.storage.cte4.CteReceptionOsStorage;
import org.dfe.models.internal.xml.XMLStore;

import java.util.Objects;

public abstract class StoreReturnCteOs implements AfterReceptionCteOs {

    @Override
    public <T extends AfterRequest<TCTeOS, TRetCTeOS>> void process(T o) throws ProcessException {
        if (Objects.nonNull(getStorage()) && Objects.nonNull(o.response())) {
            getStorage().storeReturnCteOs(new XMLStore<>(o.response(), o.config(), CteMarshallerFactory.getInstance().returnReceptionCteOs(o.response())));
        }
    }

    protected abstract CteReceptionOsStorage getStorage();

}
