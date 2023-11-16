package org.dfe.components.process.nf.query_register;

import br.inf.portalfiscal.nfe.send.TConsCad;
import br.inf.portalfiscal.nfe.send.TRetConsCad;
import org.dfe.components.internal.xml.marshaller.NfMarshallerFactory;
import org.dfe.exceptions.ProcessException;
import org.dfe.interfaces.process.AfterRequest;
import org.dfe.interfaces.process.nf.query_register.AfterQueryRegister;
import org.dfe.interfaces.storage.nf.common.NfeQueryRegisterStorage;
import org.dfe.models.internal.xml.XMLStore;
import lombok.extern.log4j.Log4j2;

import java.util.Objects;

@Log4j2
public abstract class StoreReturnQueryRegisterNf implements AfterQueryRegister {

    @Override
    public <T extends AfterRequest<TConsCad, TRetConsCad>> void process(T data) throws ProcessException {
        if (Objects.nonNull(data.response())) {
            if (Objects.nonNull(getStorage()))
                getStorage().storeReturnQueryRegister(new XMLStore<>(data.response(), data.config(), NfMarshallerFactory.getInstance().returnQueryRegister(data.response())));
        }
    }

    public abstract NfeQueryRegisterStorage getStorage();
}
