package com.softart.dfe.components.process.cte.inutilization;

import br.inf.portalfiscal.cte.send.TInutCTe;
import com.softart.dfe.components.internal.xml.marshaller.CteMarshallerFactory;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.interfaces.process.BeforeRequest;
import com.softart.dfe.interfaces.process.cte.inutilization.BeforeInutilization;
import com.softart.dfe.interfaces.storage.cte.CteInutilizationStorage;
import com.softart.dfe.models.internal.xml.XMLStore;

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
