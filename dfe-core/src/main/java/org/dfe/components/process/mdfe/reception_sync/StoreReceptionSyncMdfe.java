package org.dfe.components.process.mdfe.reception_sync;

import br.inf.portalfiscal.mdfe.classes.TMDFe;
import org.dfe.components.internal.xml.marshaller.MdfeMarshallerFactory;
import org.dfe.exceptions.ProcessException;
import org.dfe.interfaces.process.BeforeRequest;
import org.dfe.interfaces.process.mdfe.reception_sync.BeforeReceptionSync;
import org.dfe.interfaces.storage.mdfe.MdfeReceptionSyncStorage;
import org.dfe.models.internal.xml.XMLStore;

import java.util.Objects;

public abstract class StoreReceptionSyncMdfe implements BeforeReceptionSync {

    @Override
    public <T extends BeforeRequest<TMDFe>> void process(T o) throws ProcessException {
        if (Objects.nonNull(o.request()) && Objects.nonNull(getStorage())) {
            getStorage().storeMdfe(new XMLStore<>(o.request(), o.config(), MdfeMarshallerFactory.getInstance().sendReceptionSync(o.request())));
        }
    }

    protected abstract MdfeReceptionSyncStorage getStorage();
}
