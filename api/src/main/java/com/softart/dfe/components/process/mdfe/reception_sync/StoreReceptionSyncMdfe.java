package com.softart.dfe.components.process.mdfe.reception_sync;

import br.inf.portalfiscal.mdfe.classes.TMDFe;
import com.softart.dfe.components.internal.xml.marshaller.MdfeMarshallerFactory;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.interfaces.process.BeforeRequest;
import com.softart.dfe.interfaces.process.mdfe.reception_sync.BeforeReceptionSync;
import com.softart.dfe.interfaces.storage.mdfe.MdfeReceptionSyncStorage;
import com.softart.dfe.models.internal.xml.XMLStore;

import java.util.Objects;

public abstract class StoreReceptionSyncMdfe implements BeforeReceptionSync {

    @Override
    public <T extends BeforeRequest<TMDFe>> void process(T o) throws ProcessException {
        if (Objects.nonNull(o.getRequest()) && Objects.nonNull(getStorage())) {
            getStorage().storeMdfe(new XMLStore<>(o.getRequest(), o.getConfig(), MdfeMarshallerFactory.getInstance().sendReceptionSync(o.getRequest())));
        }
    }

    protected abstract MdfeReceptionSyncStorage getStorage();
}
