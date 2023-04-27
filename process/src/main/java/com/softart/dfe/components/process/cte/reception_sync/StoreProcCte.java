package com.softart.dfe.components.process.cte.reception_sync;


import br.inf.portalfiscal.cte.send.TCTe;
import br.inf.portalfiscal.cte.send.TCteProc;
import br.inf.portalfiscal.cte.send.TRetCTe;
import com.softart.dfe.components.internal.xml.marshaller.CteMarshallerFactory;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.interfaces.process.AfterRequest;
import com.softart.dfe.interfaces.process.cte.reception_sync.AfterReceptionCteSync;
import com.softart.dfe.interfaces.storage.cte.CteReceptionSyncStorage;
import com.softart.dfe.models.internal.xml.XMLStore;

import java.util.Objects;

public abstract class StoreProcCte implements AfterReceptionCteSync {

    @Override
    public <T extends AfterRequest<TCTe, TRetCTe>> void process(T o) throws ProcessException {
        if (Objects.nonNull(getStorage()) && Objects.nonNull(o.getResponse())) {
            TCteProc procCte = new br.inf.portalfiscal.cte.send.ObjectFactory().createTCteProc();
            procCte.setCTe(o.getRequest());
            procCte.setProtCTe(o.getResponse().getProtCTe());
            procCte.setVersao(o.getResponse().getVersao());
            getStorage().storeProcCteSync(new XMLStore<>(procCte, o.getConfig(), CteMarshallerFactory.getInstance().cteProc(procCte)));
        }
    }

    protected abstract CteReceptionSyncStorage getStorage();

}
