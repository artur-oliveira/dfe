package org.dfe.components.process.cte.inutilization;


import br.inf.portalfiscal.cte.send.TInutCTe;
import br.inf.portalfiscal.cte.send.TRetInutCTe;
import org.dfe.components.internal.xml.marshaller.CteMarshallerFactory;
import org.dfe.exceptions.ProcessException;
import org.dfe.interfaces.process.AfterRequest;
import org.dfe.interfaces.process.cte.inutilization.AfterInutilization;
import org.dfe.interfaces.storage.cte.CteInutilizationStorage;
import org.dfe.models.internal.xml.XMLStore;

import java.util.Objects;

public abstract class StoreReturnInutilizationCte implements AfterInutilization {

    @Override
    public <T extends AfterRequest<TInutCTe, TRetInutCTe>> void process(T o) throws ProcessException {
        if (Objects.nonNull(getStorage()) && Objects.nonNull(o.response())) {
            getStorage().storeReturnInutilization(new XMLStore<>(o.response(), o.config(), CteMarshallerFactory.getInstance().returnInutilizationCte(o.response())));
        }
    }

    protected abstract CteInutilizationStorage getStorage();

}
