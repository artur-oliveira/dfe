package org.dfe.components.process.cte4.query_situation;

import br.inf.portalfiscal.cte.send400.TConsSitCTe;
import br.inf.portalfiscal.cte.send400.TRetConsSitCTe;
import org.dfe.components.internal.xml.marshaller.CteMarshallerFactory;
import org.dfe.exceptions.ProcessException;
import org.dfe.interfaces.process.AfterRequest;
import org.dfe.interfaces.process.cte4.query_situation.AfterQuerySituation;
import org.dfe.interfaces.storage.cte4.CteQuerySituationStorage;
import org.dfe.models.internal.xml.XMLStore;

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
