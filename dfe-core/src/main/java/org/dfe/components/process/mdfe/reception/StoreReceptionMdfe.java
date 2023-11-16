package org.dfe.components.process.mdfe.reception;

import br.inf.portalfiscal.mdfe.classes.TEnviMDFe;
import org.dfe.components.internal.xml.marshaller.MdfeMarshallerFactory;
import org.dfe.exceptions.ProcessException;
import org.dfe.interfaces.process.BeforeRequest;
import org.dfe.interfaces.process.mdfe.reception.BeforeReception;
import org.dfe.interfaces.storage.mdfe.MdfeReceptionStorage;
import org.dfe.models.internal.xml.XMLStore;

import java.util.Objects;

public abstract class StoreReceptionMdfe implements BeforeReception {

    @Override
    public <T extends BeforeRequest<TEnviMDFe>> void process(T o) throws ProcessException {
        if (Objects.nonNull(o.request()) && Objects.nonNull(getStorage())) {
            getStorage().storeSendMdfe(new XMLStore<>(o.request(), o.config(), MdfeMarshallerFactory.getInstance().sendReception(o.request())));
        }
    }

    protected abstract MdfeReceptionStorage getStorage();
}
