package com.softart.dfe.components.process.cte.query_situation;

import br.inf.portalfiscal.cte.send.TConsSitCTe;
import br.inf.portalfiscal.cte.send.TRetConsSitCTe;
import com.softart.dfe.components.internal.xml.marshaller.CteMarshallerFactory;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.interfaces.process.AfterRequest;
import com.softart.dfe.interfaces.process.cte.query_situation.AfterQuerySituation;
import com.softart.dfe.interfaces.storage.cte.CteQuerySituationStorage;
import com.softart.dfe.models.internal.xml.XMLStore;

import java.util.Objects;

public abstract class StoreReturnQuerySituationCte implements AfterQuerySituation {

    @Override
    public <T extends AfterRequest<TConsSitCTe, TRetConsSitCTe>> void process(T o) throws ProcessException {
        if (Objects.nonNull(o.response()) && Objects.nonNull(getStorage())) {
            getStorage().storeReturnQuerySituation(new XMLStore<>(o.response(), o.config(), CteMarshallerFactory.getInstance().returnQuerySituationCte(o.response())));
        }
    }

    protected abstract CteQuerySituationStorage getStorage();

}
