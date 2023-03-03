package com.softart.dfe.components.process.cte.reception_os;


import br.inf.portalfiscal.cte.send.TCTeOS;
import br.inf.portalfiscal.cte.send.TCteOSProc;
import br.inf.portalfiscal.cte.send.TRetCTeOS;
import com.softart.dfe.components.internal.xml.marshaller.CteMarshallerFactory;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.interfaces.process.AfterRequest;
import com.softart.dfe.interfaces.process.cte.reception_os.AfterReceptionCteOs;
import com.softart.dfe.interfaces.storage.cte.CteReceptionOsStorage;
import com.softart.dfe.models.internal.xml.XMLStore;

import java.util.Objects;

public abstract class StoreProcCteOs implements AfterReceptionCteOs {

    @Override
    public <T extends AfterRequest<TCTeOS, TRetCTeOS>> void process(T o) throws ProcessException {
        if (Objects.nonNull(getStorage()) && Objects.nonNull(o.getResponse())) {
            TCteOSProc procCteOS = new br.inf.portalfiscal.cte.send.ObjectFactory().createTCteOSProc();
            procCteOS.setCTeOS(o.getRequest());
            procCteOS.setProtCTe(o.getResponse().getProtCTe());
            procCteOS.setVersao(o.getResponse().getVersao());
            getStorage().storeProcCteOs(new XMLStore<>(procCteOS, o.getConfig(), CteMarshallerFactory.getInstance().cteOsProc(procCteOS)));
        }
    }

    protected abstract CteReceptionOsStorage getStorage();

}
