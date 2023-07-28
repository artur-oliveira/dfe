package com.softart.dfe.components.process.mdfe.query_situation;

import br.inf.portalfiscal.mdfe.classes.TConsSitMDFe;
import com.softart.dfe.components.internal.xml.marshaller.MdfeMarshallerFactory;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.interfaces.process.BeforeRequest;
import com.softart.dfe.interfaces.process.mdfe.query_situation.BeforeQuerySituation;
import com.softart.dfe.interfaces.storage.mdfe.MdfeQuerySituationStorage;
import com.softart.dfe.models.internal.xml.XMLStore;

import java.util.Objects;

public abstract class StoreQuerySituationMdfe implements BeforeQuerySituation {

    @Override
    public <T extends BeforeRequest<TConsSitMDFe>> void process(T o) throws ProcessException {
        if (Objects.nonNull(o.config()) && Objects.nonNull(o.request())) {
            getStorage().storeSendQuerySituation(new XMLStore<>(o.request(), o.config(), MdfeMarshallerFactory.getInstance().sendQuerySituation(o.request())));
        }
    }

    public abstract MdfeQuerySituationStorage getStorage();

}
