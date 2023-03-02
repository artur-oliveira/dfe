package com.softart.dfe.components.process.nf.authorization;

import br.inf.portalfiscal.nfe.send.TEnviNFe;
import com.softart.dfe.components.internal.xml.marshaller.NfMarshallerFactory;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.interfaces.process.BeforeRequest;
import com.softart.dfe.interfaces.process.nf.authorization.BeforeAuthorization;
import com.softart.dfe.interfaces.storage.nf.common.NfAuthorizationStorage;
import com.softart.dfe.models.internal.xml.XMLStore;
import lombok.extern.log4j.Log4j2;

import java.util.Objects;

@Log4j2
public abstract class StoreAuthorizationNfe implements BeforeAuthorization {

    @Override
    public <T extends BeforeRequest<TEnviNFe>> void process(T data) throws ProcessException {
        if (Objects.nonNull(data.getRequest()))
            if (Objects.nonNull(getStorage()))
                getStorage().storeEnvNfe(new XMLStore<>(data.getRequest(), data.getConfig(), NfMarshallerFactory.getInstance().sendNfe(data.getRequest())));
    }

    public abstract NfAuthorizationStorage getStorage();
}
