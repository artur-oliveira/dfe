package com.softart.dfe.components.process.cte.query_situation;

import br.inf.portalfiscal.cte.send.TConsSitCTe;
import com.softart.dfe.components.internal.xml.marshaller.CteMarshallerFactory;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.interfaces.process.BeforeRequest;
import com.softart.dfe.interfaces.process.cte.query_situation.BeforeQuerySituation;
import com.softart.dfe.interfaces.storage.cte.CteQuerySituationStorage;
import com.softart.dfe.models.internal.xml.XMLStore;

import java.util.Objects;

public abstract class StoreQuerySituationCte implements BeforeQuerySituation {

    @Override
    public <T extends BeforeRequest<TConsSitCTe>> void process(T o) throws ProcessException {
        if (Objects.nonNull(o.getRequest()) && Objects.nonNull(getStorage())) {
            getStorage().storeQuerySituation(new XMLStore<>(o.getRequest(), o.getConfig(), CteMarshallerFactory.getInstance().querySituationCte(o.getRequest())));
        }
    }

    protected abstract CteQuerySituationStorage getStorage();
}
