package com.softart.dfe.components.process.cte.reception_gtve;


import br.inf.portalfiscal.cte.send.TGTVe;
import br.inf.portalfiscal.cte.send.TGTVeProc;
import br.inf.portalfiscal.cte.send.TRetGTVe;
import com.softart.dfe.components.internal.xml.marshaller.CteMarshallerFactory;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.interfaces.process.AfterRequest;
import com.softart.dfe.interfaces.process.cte.reception_gtve.AfterReceptionGtve;
import com.softart.dfe.interfaces.storage.cte.CteReceptionGtveStorage;
import com.softart.dfe.models.internal.xml.XMLStore;

import java.util.Objects;

public abstract class StoreProcGtve implements AfterReceptionGtve {

    @Override
    public <T extends AfterRequest<TGTVe, TRetGTVe>> void process(T o) throws ProcessException {
        if (Objects.nonNull(getStorage()) && Objects.nonNull(o.response())) {
            TGTVeProc procGtve = new br.inf.portalfiscal.cte.send.ObjectFactory().createTGTVeProc();
            procGtve.setGTVe(o.request());
            procGtve.setProtCTe(o.response().getProtCTe());
            procGtve.setVersao(o.response().getVersao());
            getStorage().storeProcGtve(new XMLStore<>(procGtve, o.config(), CteMarshallerFactory.getInstance().gtveProc(procGtve)));
        }
    }

    protected abstract CteReceptionGtveStorage getStorage();

}
