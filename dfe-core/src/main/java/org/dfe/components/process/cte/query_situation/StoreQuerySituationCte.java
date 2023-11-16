package org.dfe.components.process.cte.query_situation;

import br.inf.portalfiscal.cte.send.TConsSitCTe;
import org.dfe.components.internal.xml.marshaller.CteMarshallerFactory;
import org.dfe.exceptions.ProcessException;
import org.dfe.interfaces.process.BeforeRequest;
import org.dfe.interfaces.process.cte.query_situation.BeforeQuerySituation;
import org.dfe.interfaces.storage.cte.CteQuerySituationStorage;
import org.dfe.models.internal.xml.XMLStore;

import java.util.Objects;

public abstract class StoreQuerySituationCte implements BeforeQuerySituation {

    @Override
    public <T extends BeforeRequest<TConsSitCTe>> void process(T o) throws ProcessException {
        if (Objects.nonNull(o.request()) && Objects.nonNull(getStorage())) {
            getStorage().storeQuerySituation(new XMLStore<>(o.request(), o.config(), CteMarshallerFactory.getInstance().querySituationCte(o.request())));
        }
    }

    protected abstract CteQuerySituationStorage getStorage();
}
