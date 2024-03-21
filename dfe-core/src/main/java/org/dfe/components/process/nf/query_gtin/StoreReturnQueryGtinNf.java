package org.dfe.components.process.nf.query_gtin;

import br.inf.portalfiscal.nfe.gtin.TConsGTIN;
import br.inf.portalfiscal.nfe.gtin.TRetConsGTIN;
import lombok.extern.log4j.Log4j2;
import org.dfe.components.internal.xml.marshaller.NfMarshallerFactory;
import org.dfe.exceptions.ProcessException;
import org.dfe.interfaces.process.AfterRequest;
import org.dfe.interfaces.process.nf.query_gtin.AfterQueryGtin;
import org.dfe.interfaces.storage.nf.common.NfQueryGtinStorage;
import org.dfe.models.internal.xml.XMLStore;

import java.util.Objects;

@Log4j2
public abstract class StoreReturnQueryGtinNf implements AfterQueryGtin {

    @Override
    public <T extends AfterRequest<TConsGTIN, TRetConsGTIN>> void process(T data) throws ProcessException {
        if (Objects.nonNull(data.response())) {
            if (Objects.nonNull(getStorage()))
                getStorage().storeReturnQueryGtin(new XMLStore<>(data.response(), data.config(), NfMarshallerFactory.getInstance().returnQueryGtinNf(data.response())));
        } else {
            log.warn(Objects.requireNonNull(data.response()).getXMotivo());
        }

    }

    public abstract NfQueryGtinStorage getStorage();
}
