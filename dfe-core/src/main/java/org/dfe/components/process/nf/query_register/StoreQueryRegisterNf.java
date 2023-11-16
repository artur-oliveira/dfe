package org.dfe.components.process.nf.query_register;

import br.inf.portalfiscal.nfe.send.TConsCad;
import org.dfe.components.internal.xml.marshaller.NfMarshallerFactory;
import org.dfe.exceptions.ProcessException;
import org.dfe.interfaces.process.BeforeRequest;
import org.dfe.interfaces.process.nf.query_register.BeforeQueryRegister;
import org.dfe.interfaces.storage.nf.common.NfeQueryRegisterStorage;
import org.dfe.models.internal.xml.XMLStore;
import lombok.extern.log4j.Log4j2;

import java.util.Objects;

@Log4j2
public abstract class StoreQueryRegisterNf implements BeforeQueryRegister {

    @Override
    public <T extends BeforeRequest<TConsCad>> void process(T data) throws ProcessException {
        if (Objects.nonNull(data.request())) if (Objects.nonNull(getStorage()))
            getStorage().storeSendQueryRegister(new XMLStore<>(data.request(), data.config(), NfMarshallerFactory.getInstance().queryRegister(data.request())));
    }

    public abstract NfeQueryRegisterStorage getStorage();
}
