package com.softart.dfe.components.process.mdfe.query_unclosed;

import br.inf.portalfiscal.mdfe.classes.TConsMDFeNaoEnc;
import br.inf.portalfiscal.mdfe.classes.TRetConsMDFeNaoEnc;
import com.softart.dfe.components.internal.xml.marshaller.MdfeMarshallerFactory;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.interfaces.process.AfterRequest;
import com.softart.dfe.interfaces.process.mdfe.query_unclosed.AfterQueryUnclosed;
import com.softart.dfe.interfaces.storage.mdfe.MdfeQueryUnclosedStorage;
import com.softart.dfe.models.internal.xml.XMLStore;

import java.util.Objects;

public abstract class StoreReturnQueryUnclosedMdfe implements AfterQueryUnclosed {

    @Override
    public <T extends AfterRequest<TConsMDFeNaoEnc, TRetConsMDFeNaoEnc>> void process(T o) throws ProcessException {
        if (Objects.nonNull(o.config()) && Objects.nonNull(o.request())) {
            getStorage().storeRetQueryUnclosed(new XMLStore<>(o.response(), o.config(), MdfeMarshallerFactory.getInstance().returnQueryUnclosed(o.response())));
        }
    }

    public abstract MdfeQueryUnclosedStorage getStorage();

}
