package com.softart.dfe.components.process.mdfe.query_receipt;

import br.inf.portalfiscal.mdfe.classes.TConsReciMDFe;
import br.inf.portalfiscal.mdfe.classes.TRetConsReciMDFe;
import com.softart.dfe.components.internal.xml.marshaller.MdfeMarshallerFactory;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.interfaces.process.AfterRequest;
import com.softart.dfe.interfaces.process.mdfe.query_receipt.AfterQueryReceipt;
import com.softart.dfe.interfaces.storage.mdfe.MdfeQueryReceiptStorage;
import com.softart.dfe.models.internal.xml.XMLStore;

import java.util.Objects;

public abstract class StoreReturnQueryReceiptMdfe implements AfterQueryReceipt {

    @Override
    public <T extends AfterRequest<TConsReciMDFe, TRetConsReciMDFe>> void process(T o) throws ProcessException {
        if (Objects.nonNull(o.getConfig()) && Objects.nonNull(o.getRequest())) {
            getStorage().storeRetQueryReceipt(new XMLStore<>(o.getResponse(), o.getConfig(), MdfeMarshallerFactory.getInstance().returnQueryReceipt(o.getResponse())));
        }
    }

    public abstract MdfeQueryReceiptStorage getStorage();

}
