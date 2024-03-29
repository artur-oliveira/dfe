package org.dfe.components.process.cte4.reception_sync;


import br.inf.portalfiscal.cte.send400.TCTe;
import br.inf.portalfiscal.cte.send400.TCteProc;
import br.inf.portalfiscal.cte.send400.TRetCTe;
import org.dfe.components.internal.xml.marshaller.CteMarshallerFactory;
import org.dfe.exceptions.ProcessException;
import org.dfe.interfaces.process.AfterRequest;
import org.dfe.interfaces.process.cte4.reception_sync.AfterReceptionCteSync;
import org.dfe.interfaces.storage.cte4.CteReceptionSyncStorage;
import org.dfe.models.internal.xml.XMLStore;

import java.util.Objects;

public abstract class StoreProcCte implements AfterReceptionCteSync {

    @Override
    public <T extends AfterRequest<TCTe, TRetCTe>> void process(T o) throws ProcessException {
        if (Objects.nonNull(getStorage()) && Objects.nonNull(o.response())) {
            TCteProc procCte = new br.inf.portalfiscal.cte.send400.ObjectFactory().createTCteProc();
            procCte.setCTe(o.request());
            procCte.setProtCTe(o.response().getProtCTe());
            procCte.setVersao(o.response().getVersao());
            getStorage().storeProcCteSync(new XMLStore<>(procCte, o.config(), CteMarshallerFactory.getInstance().cteProc(procCte)));
        }
    }

    protected abstract CteReceptionSyncStorage getStorage();

}
