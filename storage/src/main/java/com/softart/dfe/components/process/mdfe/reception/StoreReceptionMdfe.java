package com.softart.dfe.components.process.mdfe.reception;

import br.inf.portalfiscal.mdfe.classes.TEnviMDFe;
import com.softart.dfe.components.internal.xml.marshaller.MdfeMarshallerFactory;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.interfaces.process.BeforeRequest;
import com.softart.dfe.interfaces.process.mdfe.reception.BeforeReception;
import com.softart.dfe.interfaces.storage.mdfe.MdfeReceptionStorage;
import com.softart.dfe.models.internal.xml.XMLStore;

import java.util.Objects;

public abstract class StoreReceptionMdfe implements BeforeReception {

    @Override
    public <T extends BeforeRequest<TEnviMDFe>> void process(T o) throws ProcessException {
        if (Objects.nonNull(o.getRequest()) && Objects.nonNull(getStorage())) {
            getStorage().storeSendMdfe(new XMLStore<>(o.getRequest(), o.getConfig(), MdfeMarshallerFactory.getInstance().sendReception(o.getRequest())));
        }
    }

    protected abstract MdfeReceptionStorage getStorage();
}
