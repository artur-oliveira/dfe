package org.dfe.components.process.mdfe.query_unclosed;

import br.inf.portalfiscal.mdfe.classes.TConsMDFeNaoEnc;
import org.dfe.components.internal.xml.marshaller.MdfeMarshallerFactory;
import org.dfe.exceptions.ProcessException;
import org.dfe.interfaces.process.BeforeRequest;
import org.dfe.interfaces.process.mdfe.query_unclosed.BeforeQueryUnclosed;
import org.dfe.interfaces.storage.mdfe.MdfeQueryUnclosedStorage;
import org.dfe.models.internal.xml.XMLStore;

import java.util.Objects;

public abstract class StoreQueryUnclosedMdfe implements BeforeQueryUnclosed {

    @Override
    public <T extends BeforeRequest<TConsMDFeNaoEnc>> void process(T o) throws ProcessException {
        if (Objects.nonNull(o.config()) && Objects.nonNull(o.request())) {
            getStorage().storeSendQueryUnclosed(new XMLStore<>(o.request(), o.config(), MdfeMarshallerFactory.getInstance().sendQueryUnclosed(o.request())));
        }
    }

    public abstract MdfeQueryUnclosedStorage getStorage();

}
