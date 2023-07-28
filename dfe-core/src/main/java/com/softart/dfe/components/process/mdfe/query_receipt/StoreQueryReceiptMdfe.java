package com.softart.dfe.components.process.mdfe.query_receipt;

import br.inf.portalfiscal.mdfe.classes.TConsReciMDFe;
import com.softart.dfe.components.internal.xml.marshaller.MdfeMarshallerFactory;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.interfaces.process.BeforeRequest;
import com.softart.dfe.interfaces.process.mdfe.query_receipt.BeforeQueryReceipt;
import com.softart.dfe.interfaces.storage.mdfe.MdfeQueryReceiptStorage;
import com.softart.dfe.models.internal.xml.XMLStore;

import java.util.Objects;

public abstract class StoreQueryReceiptMdfe implements BeforeQueryReceipt {

    @Override
    public <T extends BeforeRequest<TConsReciMDFe>> void process(T o) throws ProcessException {
        if (Objects.nonNull(o.config()) && Objects.nonNull(o.request())) {
            getStorage().storeSendQueryReceipt(new XMLStore<>(o.request(), o.config(), MdfeMarshallerFactory.getInstance().sendQueryReceipt(o.request())));
        }
    }

    public abstract MdfeQueryReceiptStorage getStorage();

}
