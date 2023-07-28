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
        if (Objects.nonNull(getStorage()) && Objects.nonNull(o.response())) {
            TProcInutCTe procInutCTe = new br.inf.portalfiscal.cte.send.ObjectFactory().createTProcInutCTe();
            procInutCTe.setInutCTe(o.request());
            procInutCTe.setRetInutCTe(o.response());
            procInutCTe.setVersao(o.response().getVersao());
            getStorage().storeProcInutilization(new XMLStore<>(procInutCTe, o.config(), CteMarshallerFactory.getInstance().procInutilizationCte(procInutCTe)));
        }
    }

    protected abstract CteInutilizationStorage getStorage();

}
