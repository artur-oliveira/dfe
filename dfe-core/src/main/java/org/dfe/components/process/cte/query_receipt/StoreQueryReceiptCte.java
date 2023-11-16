package org.dfe.components.process.cte.query_receipt;

import br.inf.portalfiscal.cte.send.TConsReciCTe;
import org.dfe.components.internal.xml.marshaller.CteMarshallerFactory;
import org.dfe.exceptions.ProcessException;
import org.dfe.interfaces.process.BeforeRequest;
import org.dfe.interfaces.process.cte.query_receipt.BeforeQueryReceipt;
import org.dfe.interfaces.storage.cte.CteQueryReceiptStorage;
import org.dfe.models.internal.xml.XMLStore;

import java.util.Objects;

public abstract class StoreQueryReceiptCte implements BeforeQueryReceipt {

    @Override
    public <T extends BeforeRequest<TConsReciCTe>> void process(T o) throws ProcessException {
        if (Objects.nonNull(o.request()) && Objects.nonNull(getStorage())) {
            getStorage().storeQueryReceipt(new XMLStore<>(o.request(), o.config(), CteMarshallerFactory.getInstance().queryReceipt(o.request())));
        }
    }

    protected abstract CteQueryReceiptStorage getStorage();
}
