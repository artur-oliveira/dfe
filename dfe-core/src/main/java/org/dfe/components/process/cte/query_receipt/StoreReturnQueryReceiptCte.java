package org.dfe.components.process.cte.query_receipt;

import br.inf.portalfiscal.cte.send.TConsReciCTe;
import br.inf.portalfiscal.cte.send.TRetConsReciCTe;
import org.dfe.components.internal.xml.marshaller.CteMarshallerFactory;
import org.dfe.exceptions.ProcessException;
import org.dfe.interfaces.process.AfterRequest;
import org.dfe.interfaces.process.cte.query_receipt.AfterQueryReceipt;
import org.dfe.interfaces.storage.cte.CteQueryReceiptStorage;
import org.dfe.models.internal.xml.XMLStore;

import java.util.Objects;

public abstract class StoreReturnQueryReceiptCte implements AfterQueryReceipt {

    @Override
    public <T extends AfterRequest<TConsReciCTe, TRetConsReciCTe>> void process(T o) throws ProcessException {
        if (Objects.nonNull(o.response()) && Objects.nonNull(getStorage())) {
            getStorage().storeReturnQueryReceipt(new XMLStore<>(o.response(), o.config(), CteMarshallerFactory.getInstance().returnQueryReceipt(o.response())));
        }
    }

    protected abstract CteQueryReceiptStorage getStorage();

}
