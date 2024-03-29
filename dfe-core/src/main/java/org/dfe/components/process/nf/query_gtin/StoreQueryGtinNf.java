package org.dfe.components.process.nf.query_gtin;

import br.inf.portalfiscal.nfe.gtin.TConsGTIN;
import lombok.extern.log4j.Log4j2;
import org.dfe.components.internal.xml.marshaller.NfMarshallerFactory;
import org.dfe.exceptions.ProcessException;
import org.dfe.interfaces.process.BeforeRequest;
import org.dfe.interfaces.process.nf.query_gtin.BeforeQueryGtin;
import org.dfe.interfaces.storage.nf.common.NfQueryGtinStorage;
import org.dfe.models.internal.xml.XMLStore;

import java.util.Objects;

@Log4j2
public abstract class StoreQueryGtinNf implements BeforeQueryGtin {

    @Override
    public <T extends BeforeRequest<TConsGTIN>> void process(T data) throws ProcessException {
        if (Objects.nonNull(data.request())) if (Objects.nonNull(getStorage()))
            getStorage().storeQueryGtin(new XMLStore<>(data.request(), data.config(), NfMarshallerFactory.getInstance().queryGtinNf(data.request())));
    }

    public abstract NfQueryGtinStorage getStorage();
}
