package com.softart.dfe.components.process.nf.query_register;

import br.inf.portalfiscal.nfe.send.TConsCad;
import com.softart.dfe.components.internal.xml.marshaller.NfMarshallerFactory;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.interfaces.process.BeforeRequest;
import com.softart.dfe.interfaces.process.nf.query_register.BeforeQueryRegister;
import com.softart.dfe.interfaces.storage.nf.common.NfeQueryRegisterStorage;
import com.softart.dfe.models.internal.xml.XMLStore;
import lombok.extern.log4j.Log4j2;

import java.util.Objects;

@Log4j2
public abstract class StoreQueryRegisterNf implements BeforeQueryRegister {

    @Override
    public <T extends BeforeRequest<TConsCad>> void process(T data) throws ProcessException {
        if (Objects.nonNull(data.getRequest())) if (Objects.nonNull(getStorage()))
            getStorage().storeSendQueryRegister(new XMLStore<>(data.getRequest(), data.getConfig(), NfMarshallerFactory.getInstance().queryRegister(data.getRequest())));
    }

    public abstract NfeQueryRegisterStorage getStorage();
}
