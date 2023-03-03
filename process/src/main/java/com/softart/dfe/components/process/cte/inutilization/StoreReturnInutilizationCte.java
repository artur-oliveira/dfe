package com.softart.dfe.components.process.cte.inutilization;


import br.inf.portalfiscal.cte.send.TInutCTe;
import br.inf.portalfiscal.cte.send.TRetInutCTe;
import com.softart.dfe.components.internal.xml.marshaller.CteMarshallerFactory;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.interfaces.process.AfterRequest;
import com.softart.dfe.interfaces.process.cte.inutilization.AfterInutilization;
import com.softart.dfe.interfaces.storage.cte.CteInutilizationStorage;
import com.softart.dfe.models.internal.xml.XMLStore;

import java.util.Objects;

public abstract class StoreReturnInutilizationCte implements AfterInutilization {

    @Override
    public <T extends AfterRequest<TInutCTe, TRetInutCTe>> void process(T o) throws ProcessException {
        if (Objects.nonNull(getStorage()) && Objects.nonNull(o.getResponse())) {
            getStorage().storeReturnInutilization(new XMLStore<>(o.getResponse(), o.getConfig(), CteMarshallerFactory.getInstance().returnInutilizationCte(o.getResponse())));
        }
    }

    protected abstract CteInutilizationStorage getStorage();

}
