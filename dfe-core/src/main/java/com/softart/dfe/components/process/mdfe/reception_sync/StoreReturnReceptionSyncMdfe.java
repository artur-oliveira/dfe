package com.softart.dfe.components.process.mdfe.reception_sync;


import br.inf.portalfiscal.mdfe.classes.TMDFe;
import br.inf.portalfiscal.mdfe.classes.TRetMDFe;
import com.softart.dfe.components.internal.xml.marshaller.MdfeMarshallerFactory;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.interfaces.process.AfterRequest;
import com.softart.dfe.interfaces.process.mdfe.reception_sync.AfterReceptionSync;
import com.softart.dfe.interfaces.storage.mdfe.MdfeReceptionSyncStorage;
import com.softart.dfe.models.internal.xml.XMLStore;

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
