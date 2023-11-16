package org.dfe.components.process.mdfe.reception;


import br.inf.portalfiscal.mdfe.classes.TEnviMDFe;
import br.inf.portalfiscal.mdfe.classes.TRetEnviMDFe;
import org.dfe.components.internal.xml.marshaller.MdfeMarshallerFactory;
import org.dfe.exceptions.ProcessException;
import org.dfe.interfaces.process.AfterRequest;
import org.dfe.interfaces.process.mdfe.reception.AfterReception;
import org.dfe.interfaces.storage.mdfe.MdfeReceptionStorage;
import org.dfe.models.internal.xml.XMLStore;

import java.util.Objects;

public abstract class StoreReturnReceptionMdfe implements AfterReception {

    @Override
    public <T extends AfterRequest<TEnviMDFe, TRetEnviMDFe>> void process(T o) throws ProcessException {
        if (Objects.nonNull(getStorage()) && Objects.nonNull(o.response())) {
            getStorage().storeReturnSendMdfe(new XMLStore<>(o.response(), o.config(), MdfeMarshallerFactory.getInstance().returnReception(o.response())));
        }
    }

    protected abstract MdfeReceptionStorage getStorage();

}
