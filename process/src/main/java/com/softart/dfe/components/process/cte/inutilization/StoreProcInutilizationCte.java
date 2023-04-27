package com.softart.dfe.components.process.cte.inutilization;


import br.inf.portalfiscal.cte.send.TInutCTe;
import br.inf.portalfiscal.cte.send.TProcInutCTe;
import br.inf.portalfiscal.cte.send.TRetInutCTe;
import com.softart.dfe.components.internal.xml.marshaller.CteMarshallerFactory;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.interfaces.process.AfterRequest;
import com.softart.dfe.interfaces.process.cte.inutilization.AfterInutilization;
import com.softart.dfe.interfaces.storage.cte.CteInutilizationStorage;
import com.softart.dfe.models.internal.xml.XMLStore;

import java.util.Objects;

public abstract class StoreProcInutilizationCte implements AfterInutilization {

    @Override
    public <T extends AfterRequest<TInutCTe, TRetInutCTe>> void process(T o) throws ProcessException {
        if (Objects.nonNull(getStorage()) && Objects.nonNull(o.getResponse())) {
            TProcInutCTe procInutCTe = new br.inf.portalfiscal.cte.send.ObjectFactory().createTProcInutCTe();
            procInutCTe.setInutCTe(o.getRequest());
            procInutCTe.setRetInutCTe(o.getResponse());
            procInutCTe.setVersao(o.getResponse().getVersao());
            getStorage().storeProcInutilization(new XMLStore<>(procInutCTe, o.getConfig(), CteMarshallerFactory.getInstance().procInutilizationCte(procInutCTe)));
        }
    }

    protected abstract CteInutilizationStorage getStorage();

}
