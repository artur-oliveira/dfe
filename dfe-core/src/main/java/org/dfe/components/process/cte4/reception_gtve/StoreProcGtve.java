package org.dfe.components.process.cte4.reception_gtve;


import br.inf.portalfiscal.cte.send400.TGTVe;
import br.inf.portalfiscal.cte.send400.TGTVeProc;
import br.inf.portalfiscal.cte.send400.TRetGTVe;
import org.dfe.components.internal.xml.marshaller.CteMarshallerFactory;
import org.dfe.exceptions.ProcessException;
import org.dfe.interfaces.process.AfterRequest;
import org.dfe.interfaces.process.cte4.reception_gtve.AfterReceptionGtve;
import org.dfe.interfaces.storage.cte4.CteReceptionGtveStorage;
import org.dfe.models.internal.xml.XMLStore;

import java.util.Objects;

public abstract class StoreProcGtve implements AfterReceptionGtve {

    @Override
    public <T extends AfterRequest<TGTVe, TRetGTVe>> void process(T o) throws ProcessException {
        if (Objects.nonNull(getStorage()) && Objects.nonNull(o.response())) {
            TGTVeProc procGtve = new br.inf.portalfiscal.cte.send400.ObjectFactory().createTGTVeProc();
            procGtve.setGTVe(o.request());
            procGtve.setProtCTe(o.response().getProtCTe());
            procGtve.setVersao(o.response().getVersao());
            getStorage().storeProcGtve(new XMLStore<>(procGtve, o.config(), CteMarshallerFactory.getInstance().gtveProc(procGtve)));
        }
    }

    protected abstract CteReceptionGtveStorage getStorage();

}
