package com.softart.dfe.components.process.mdfe.reception;


import br.inf.portalfiscal.mdfe.classes.TEnviMDFe;
import br.inf.portalfiscal.mdfe.classes.TRetEnviMDFe;
import com.softart.dfe.components.internal.xml.marshaller.MdfeMarshallerFactory;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.interfaces.process.AfterRequest;
import com.softart.dfe.interfaces.process.mdfe.reception.AfterReception;
import com.softart.dfe.interfaces.storage.mdfe.MdfeReceptionStorage;
import com.softart.dfe.models.internal.xml.XMLStore;

import java.util.Objects;

public abstract class StoreReturnReceptionMdfe implements AfterReception {

    @Override
    public <T extends AfterRequest<TEnviMDFe, TRetEnviMDFe>> void process(T o) throws ProcessException {
        if (Objects.nonNull(getStorage()) && Objects.nonNull(o.getResponse())) {
            getStorage().storeReturnSendMdfe(new XMLStore<>(o.getResponse(), o.getConfig(), MdfeMarshallerFactory.getInstance().returnReception(o.getResponse())));
        }
    }

    protected abstract MdfeReceptionStorage getStorage();

}
