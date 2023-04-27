package com.softart.dfe.components.process.nf.query_register;

import br.inf.portalfiscal.nfe.send.TConsCad;
import br.inf.portalfiscal.nfe.send.TRetConsCad;
import com.softart.dfe.components.internal.xml.marshaller.NfMarshallerFactory;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.interfaces.process.AfterRequest;
import com.softart.dfe.interfaces.process.nf.query_register.AfterQueryRegister;
import com.softart.dfe.interfaces.storage.nf.common.NfeQueryRegisterStorage;
import com.softart.dfe.models.internal.xml.XMLStore;
import lombok.extern.log4j.Log4j2;

import java.util.Objects;

@Log4j2
public abstract class StoreReturnQueryRegisterNf implements AfterQueryRegister {

    @Override
    public <T extends AfterRequest<TConsCad, TRetConsCad>> void process(T data) throws ProcessException {
        if (Objects.nonNull(data.getResponse())) {
            if (Objects.nonNull(getStorage()))
                getStorage().storeReturnQueryRegister(new XMLStore<>(data.getResponse(), data.getConfig(), NfMarshallerFactory.getInstance().returnQueryRegister(data.getResponse())));
        }
    }

    public abstract NfeQueryRegisterStorage getStorage();
}
