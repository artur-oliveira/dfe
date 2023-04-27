package com.softart.dfe.components.process.cte.query_receipt;

import br.inf.portalfiscal.cte.send.TConsReciCTe;
import br.inf.portalfiscal.cte.send.TRetConsReciCTe;
import com.softart.dfe.components.internal.xml.marshaller.CteMarshallerFactory;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.interfaces.process.AfterRequest;
import com.softart.dfe.interfaces.process.cte.query_receipt.AfterQueryReceipt;
import com.softart.dfe.interfaces.storage.cte.CteQueryReceiptStorage;
import com.softart.dfe.models.internal.xml.XMLStore;

import java.util.Objects;

public abstract class StoreReturnQueryReceiptCte implements AfterQueryReceipt {

    @Override
    public <T extends AfterRequest<TConsReciCTe, TRetConsReciCTe>> void process(T o) throws ProcessException {
        if (Objects.nonNull(o.getResponse()) && Objects.nonNull(getStorage())) {
            getStorage().storeReturnQueryReceipt(new XMLStore<>(o.getResponse(), o.getConfig(), CteMarshallerFactory.getInstance().returnQueryReceipt(o.getResponse())));
        }
    }

    protected abstract CteQueryReceiptStorage getStorage();

}
