package com.softart.dfe.components.process.cte.distribution;

import br.inf.portalfiscal.cte.distribution.DistDFeInt;
import com.softart.dfe.components.internal.xml.marshaller.CteMarshallerFactory;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.interfaces.process.BeforeRequest;
import com.softart.dfe.interfaces.process.cte.distribution.BeforeDistribution;
import com.softart.dfe.interfaces.storage.cte.CteDistributionStorage;
import com.softart.dfe.models.internal.xml.XMLStore;

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
