package org.dfe.components.process.cte4.distribution;

import br.inf.portalfiscal.cte.distribution.DistDFeInt;
import org.dfe.components.internal.xml.marshaller.CteMarshallerFactory;
import org.dfe.exceptions.ProcessException;
import org.dfe.interfaces.process.BeforeRequest;
import org.dfe.interfaces.process.cte4.distribution.BeforeDistribution;
import org.dfe.interfaces.storage.cte4.CteDistributionStorage;
import org.dfe.models.internal.xml.XMLStore;

import java.util.Objects;

public abstract class StoreDistributionCte implements BeforeDistribution {

    @Override
    public <T extends BeforeRequest<DistDFeInt>> void process(T o) throws ProcessException {
        if (Objects.nonNull(o.request()) && Objects.nonNull(getStorage())) {
            getStorage().storeDistribution(new XMLStore<>(o.request(), o.config(), CteMarshallerFactory.getInstance().distributionCte(o.request())));
        }
    }

    protected abstract CteDistributionStorage getStorage();
}
