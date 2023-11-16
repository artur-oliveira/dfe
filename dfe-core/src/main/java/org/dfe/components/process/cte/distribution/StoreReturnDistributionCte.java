package org.dfe.components.process.cte.distribution;

import br.inf.portalfiscal.cte.distribution.DistDFeInt;
import br.inf.portalfiscal.cte.distribution.RetDistDFeInt;
import org.dfe.components.internal.xml.marshaller.CteMarshallerFactory;
import org.dfe.exceptions.ProcessException;
import org.dfe.interfaces.process.AfterRequest;
import org.dfe.interfaces.process.cte.distribution.AfterDistribution;
import org.dfe.interfaces.storage.cte.CteDistributionStorage;
import org.dfe.models.internal.xml.XMLStore;

import java.util.Objects;

public abstract class StoreReturnDistributionCte implements AfterDistribution {

    @Override
    public <T extends AfterRequest<DistDFeInt, RetDistDFeInt>> void process(T o) throws ProcessException {
        if (Objects.nonNull(o.response()) && Objects.nonNull(getStorage())) {
            getStorage().storeReturnDistribution(new XMLStore<>(o.response(), o.config(), CteMarshallerFactory.getInstance().returnDistributionCte(o.response())));
        }
    }

    protected abstract CteDistributionStorage getStorage();

}
