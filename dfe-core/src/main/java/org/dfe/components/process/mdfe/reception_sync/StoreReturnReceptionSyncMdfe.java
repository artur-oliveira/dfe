package org.dfe.components.process.mdfe.reception_sync;


import br.inf.portalfiscal.mdfe.classes.TMDFe;
import br.inf.portalfiscal.mdfe.classes.TRetMDFe;
import org.dfe.components.internal.xml.marshaller.MdfeMarshallerFactory;
import org.dfe.exceptions.ProcessException;
import org.dfe.interfaces.process.AfterRequest;
import org.dfe.interfaces.process.mdfe.reception_sync.AfterReceptionSync;
import org.dfe.interfaces.storage.mdfe.MdfeReceptionSyncStorage;
import org.dfe.models.internal.xml.XMLStore;

import java.util.Objects;

public abstract class StoreReturnReceptionSyncMdfe implements AfterReceptionSync {

    @Override
    public <T extends AfterRequest<TMDFe, TRetMDFe>> void process(T o) throws ProcessException {
        if (Objects.nonNull(getStorage()) && Objects.nonNull(o.response())) {
            getStorage().storeReturnMdfe(new XMLStore<>(o.response(), o.config(), MdfeMarshallerFactory.getInstance().returnReceptionSync(o.response())));
        }
    }

    protected abstract MdfeReceptionSyncStorage getStorage();

}
