package com.softart.dfe.components.process.nf.inut;

import br.inf.portalfiscal.nfe.send.TInutNFe;
import com.softart.dfe.components.internal.xml.marshaller.NfMarshallerFactory;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.interfaces.process.BeforeRequest;
import com.softart.dfe.interfaces.process.nf.inut.BeforeInut;
import com.softart.dfe.interfaces.storage.nf.NfInutStorage;
import com.softart.dfe.models.internal.xml.XMLStore;
import lombok.extern.log4j.Log4j2;

import java.util.Objects;

@Log4j2
public abstract class StoreSendInutilizationNfe implements BeforeInut {

    @Override
    public <T extends BeforeRequest<TInutNFe>> void process(T data) throws ProcessException {
        if (Objects.nonNull(data.request())) if (Objects.nonNull(getStorage()))
            getStorage().storeEnvInut(new XMLStore<>(data.request(), data.config(), NfMarshallerFactory.getInstance().inutNfe(data.request())));

    }

    public abstract NfInutStorage getStorage();
}
