package org.dfe.components.process.mdfe.query_receipt;

import br.inf.portalfiscal.mdfe.classes.TConsReciMDFe;
import br.inf.portalfiscal.mdfe.classes.TRetConsReciMDFe;
import org.dfe.components.internal.xml.marshaller.MdfeMarshallerFactory;
import org.dfe.exceptions.ProcessException;
import org.dfe.interfaces.process.AfterRequest;
import org.dfe.interfaces.process.mdfe.query_receipt.AfterQueryReceipt;
import org.dfe.interfaces.storage.mdfe.MdfeQueryReceiptStorage;
import org.dfe.models.internal.xml.XMLStore;

import java.util.Objects;

public abstract class StoreReturnQueryReceiptMdfe implements AfterQueryReceipt {

    @Override
    public <T extends AfterRequest<TConsReciMDFe, TRetConsReciMDFe>> void process(T o) throws ProcessException {
        if (Objects.nonNull(o.config()) && Objects.nonNull(o.request())) {
            getStorage().storeRetQueryReceipt(new XMLStore<>(o.response(), o.config(), MdfeMarshallerFactory.getInstance().returnQueryReceipt(o.response())));
        }
    }

    public abstract MdfeQueryReceiptStorage getStorage();

}
