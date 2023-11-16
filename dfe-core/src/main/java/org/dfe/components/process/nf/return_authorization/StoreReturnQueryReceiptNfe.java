package org.dfe.components.process.nf.return_authorization;

import br.inf.portalfiscal.nfe.send.TConsReciNFe;
import br.inf.portalfiscal.nfe.send.TRetConsReciNFe;
import org.dfe.components.internal.xml.marshaller.NfMarshallerFactory;
import org.dfe.exceptions.ProcessException;
import org.dfe.interfaces.process.AfterRequest;
import org.dfe.interfaces.process.nf.return_authorization.AfterReturnAuthorization;
import org.dfe.interfaces.storage.nf.common.NfReturnAuthorizationStorage;
import org.dfe.models.internal.xml.XMLStore;
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
