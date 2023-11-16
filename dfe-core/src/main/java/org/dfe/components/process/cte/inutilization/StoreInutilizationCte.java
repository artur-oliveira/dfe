package org.dfe.components.process.cte.inutilization;

import br.inf.portalfiscal.cte.send.TInutCTe;
import org.dfe.components.internal.xml.marshaller.CteMarshallerFactory;
import org.dfe.exceptions.ProcessException;
import org.dfe.interfaces.process.BeforeRequest;
import org.dfe.interfaces.process.cte.inutilization.BeforeInutilization;
import org.dfe.interfaces.storage.cte.CteInutilizationStorage;
import org.dfe.models.internal.xml.XMLStore;

import java.util.Objects;

public abstract class StoreInutilizationCte implements BeforeInutilization {

    @Override
    public <T extends BeforeRequest<TInutCTe>> void process(T o) throws ProcessException {
        if (Objects.nonNull(o.request()) && Objects.nonNull(getStorage())) {
            getStorage().storeInutilization(new XMLStore<>(o.request(), o.config(), CteMarshallerFactory.getInstance().inutilizationCte(o.request())));
        }
    }

    protected abstract CteInutilizationStorage getStorage();
}
