package com.softart.dfe.components.process.nf.return_authorization;

import br.inf.portalfiscal.nfe.send.TConsReciNFe;
import br.inf.portalfiscal.nfe.send.TRetConsReciNFe;
import com.softart.dfe.components.internal.xml.marshaller.NfMarshallerFactory;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.interfaces.process.AfterRequest;
import com.softart.dfe.interfaces.process.nf.return_authorization.AfterReturnAuthorization;
import com.softart.dfe.interfaces.storage.nf.common.NfReturnAuthorizationStorage;
import com.softart.dfe.models.internal.xml.XMLStore;
import lombok.extern.log4j.Log4j2;

import java.util.Objects;

@Log4j2
public abstract class StoreReturnQueryReceiptNfe implements AfterReturnAuthorization {

    @Override
    public <T extends AfterRequest<TConsReciNFe, TRetConsReciNFe>> void process(T data) throws ProcessException {
        if (Objects.nonNull(data.response()) && Objects.nonNull(data.response().getProtNFe()) && !data.response().getProtNFe().isEmpty()) {
            if (Objects.nonNull(getStorage()))
                getStorage().storeRetReturnAuthorization(new XMLStore<>(data.response(), data.config(), NfMarshallerFactory.getInstance().returnQueryReceiptNfe(data.response())));
        } else {
            log.warn(Objects.requireNonNull(data.response()).getXMotivo());
        }
    }

    public abstract NfReturnAuthorizationStorage getStorage();
}
