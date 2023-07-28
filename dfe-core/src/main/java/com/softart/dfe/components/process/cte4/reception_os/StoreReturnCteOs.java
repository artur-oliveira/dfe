package com.softart.dfe.components.process.cte4.reception_os;


import br.inf.portalfiscal.cte.send400.TCTeOS;
import br.inf.portalfiscal.cte.send400.TRetCTeOS;
import com.softart.dfe.components.internal.xml.marshaller.CteMarshallerFactory;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.interfaces.process.AfterRequest;
import com.softart.dfe.interfaces.process.cte4.reception_os.AfterReceptionCteOs;
import com.softart.dfe.interfaces.storage.cte4.CteReceptionOsStorage;
import com.softart.dfe.models.internal.xml.XMLStore;

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
