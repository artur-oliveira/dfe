package org.dfe.components.process.nf.return_authorization;

import br.inf.portalfiscal.nfe.send.TConsReciNFe;
import lombok.extern.log4j.Log4j2;
import org.dfe.components.internal.xml.marshaller.NfMarshallerFactory;
import org.dfe.exceptions.ProcessException;
import org.dfe.interfaces.process.BeforeRequest;
import org.dfe.interfaces.process.nf.return_authorization.BeforeReturnAuthorization;
import org.dfe.interfaces.storage.nf.common.NfReturnAuthorizationStorage;
import org.dfe.models.internal.xml.XMLStore;

import java.util.Objects;

@Log4j2
public abstract class StoreSendQueryReceiptNfe implements BeforeReturnAuthorization {

    @Override
    public <T extends BeforeRequest<TConsReciNFe>> void process(T data) throws ProcessException {
        if (Objects.nonNull(data.request())) if (Objects.nonNull(getStorage()))
            getStorage().storeEnvReturnAuthorization(new XMLStore<>(data.request(), data.config(), NfMarshallerFactory.getInstance().queryReceiptNfe(data.request())));

    }

    public abstract NfReturnAuthorizationStorage getStorage();
}
