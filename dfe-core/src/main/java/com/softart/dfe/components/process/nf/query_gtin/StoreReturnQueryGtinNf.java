package com.softart.dfe.components.process.nf.query_gtin;

import br.inf.portalfiscal.nfe.gtin.TConsGTIN;
import br.inf.portalfiscal.nfe.gtin.TRetConsGTIN;
import com.softart.dfe.components.internal.xml.marshaller.NfMarshallerFactory;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.interfaces.process.AfterRequest;
import com.softart.dfe.interfaces.process.nf.query_gtin.AfterQueryGtin;
import com.softart.dfe.interfaces.storage.nf.common.NfQueryGtinStorage;
import com.softart.dfe.models.internal.xml.XMLStore;
import lombok.extern.log4j.Log4j2;

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
