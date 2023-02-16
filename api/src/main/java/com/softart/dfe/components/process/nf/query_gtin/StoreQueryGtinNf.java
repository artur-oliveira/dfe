package com.softart.dfe.components.process.nf.query_gtin;

import br.inf.portalfiscal.nfe.gtin.TConsGTIN;
import com.softart.dfe.components.internal.xml.marshaller.NfMarshallerFactory;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.interfaces.process.BeforeRequest;
import com.softart.dfe.interfaces.process.nf.query_gtin.BeforeQueryGtin;
import com.softart.dfe.interfaces.storage.nf.common.NfQueryGtinStorage;
import com.softart.dfe.models.internal.xml.XMLStore;
import lombok.extern.log4j.Log4j2;

import java.util.Objects;

@Log4j2
public abstract class StoreQueryGtinNf implements BeforeQueryGtin {

    @Override
    public <T extends BeforeRequest<TConsGTIN>> void process(T data) throws ProcessException {
        if (Objects.nonNull(data.getRequest())) if (Objects.nonNull(getStorage()))
            getStorage().storeQueryGtin(new XMLStore<>(data.getRequest(), data.getConfig(), NfMarshallerFactory.getInstance().queryGtinNf(data.getRequest())));
    }

    public abstract NfQueryGtinStorage getStorage();
}
