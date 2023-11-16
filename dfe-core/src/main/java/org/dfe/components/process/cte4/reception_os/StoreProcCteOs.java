package org.dfe.components.process.cte4.reception_os;


import br.inf.portalfiscal.cte.send400.TCTeOS;
import br.inf.portalfiscal.cte.send400.TCteOSProc;
import br.inf.portalfiscal.cte.send400.TRetCTeOS;
import org.dfe.components.internal.xml.marshaller.CteMarshallerFactory;
import org.dfe.exceptions.ProcessException;
import org.dfe.interfaces.process.AfterRequest;
import org.dfe.interfaces.process.cte4.reception_os.AfterReceptionCteOs;
import org.dfe.interfaces.storage.cte4.CteReceptionOsStorage;
import org.dfe.models.internal.xml.XMLStore;

import java.util.Objects;

public abstract class StoreProcCteOs implements AfterReceptionCteOs {

    @Override
    public <T extends AfterRequest<TCTeOS, TRetCTeOS>> void process(T o) throws ProcessException {
        if (Objects.nonNull(getStorage()) && Objects.nonNull(o.response())) {
            TCteOSProc procCteOS = new br.inf.portalfiscal.cte.send400.ObjectFactory().createTCteOSProc();
            procCteOS.setCTeOS(o.request());
            procCteOS.setProtCTe(o.response().getProtCTe());
            procCteOS.setVersao(o.response().getVersao());
            getStorage().storeProcCteOs(new XMLStore<>(procCteOS, o.config(), CteMarshallerFactory.getInstance().cteOsProc(procCteOS)));
        }
    }

    protected abstract CteReceptionOsStorage getStorage();

}
