package com.softart.dfe.components.process.cte4.reception_os;

import br.inf.portalfiscal.cte.send400.TCTeOS;
import com.softart.dfe.components.internal.xml.marshaller.CteMarshallerFactory;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.interfaces.process.BeforeRequest;
import com.softart.dfe.interfaces.process.cte4.reception_os.BeforeReceptionCteOs;
import com.softart.dfe.interfaces.storage.cte4.CteReceptionOsStorage;
import com.softart.dfe.models.internal.xml.XMLStore;

import java.util.Objects;

public abstract class StoreCteOs implements BeforeReceptionCteOs {

    @Override
    public <T extends BeforeRequest<TCTeOS>> void process(T o) throws ProcessException {
        if (Objects.nonNull(o.request()) && Objects.nonNull(getStorage())) {
            getStorage().storeCteOs(new XMLStore<>(o.request(), o.config(), CteMarshallerFactory.getInstance().receptionCteOs(o.request())));
        }
    }

    protected abstract CteReceptionOsStorage getStorage();
}
