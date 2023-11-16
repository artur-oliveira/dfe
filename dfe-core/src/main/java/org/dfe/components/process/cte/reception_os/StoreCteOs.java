package org.dfe.components.process.cte.reception_os;

import br.inf.portalfiscal.cte.send.TCTeOS;
import org.dfe.components.internal.xml.marshaller.CteMarshallerFactory;
import org.dfe.exceptions.ProcessException;
import org.dfe.interfaces.process.BeforeRequest;
import org.dfe.interfaces.process.cte.reception_os.BeforeReceptionCteOs;
import org.dfe.interfaces.storage.cte.CteReceptionOsStorage;
import org.dfe.models.internal.xml.XMLStore;

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
