package com.softart.dfe.components.process.mdfe.query_unclosed;

import br.inf.portalfiscal.mdfe.classes.TConsMDFeNaoEnc;
import com.softart.dfe.components.internal.xml.marshaller.MdfeMarshallerFactory;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.interfaces.process.BeforeRequest;
import com.softart.dfe.interfaces.process.mdfe.query_unclosed.BeforeQueryUnclosed;
import com.softart.dfe.interfaces.storage.mdfe.MdfeQueryUnclosedStorage;
import com.softart.dfe.models.internal.xml.XMLStore;

import java.util.Objects;

public abstract class StoreQueryUnclosedMdfe implements BeforeQueryUnclosed {

    @Override
    public <T extends BeforeRequest<TConsMDFeNaoEnc>> void process(T o) throws ProcessException {
        if (Objects.nonNull(o.getConfig()) && Objects.nonNull(o.getRequest())) {
            getStorage().storeSendQueryUnclosed(new XMLStore<>(o.getRequest(), o.getConfig(), MdfeMarshallerFactory.getInstance().sendQueryUnclosed(o.getRequest())));
        }
    }

    public abstract MdfeQueryUnclosedStorage getStorage();

}
