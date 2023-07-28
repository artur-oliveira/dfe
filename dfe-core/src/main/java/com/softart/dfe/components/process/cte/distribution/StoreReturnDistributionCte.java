package com.softart.dfe.components.process.cte.distribution;

import br.inf.portalfiscal.cte.distribution.DistDFeInt;
import br.inf.portalfiscal.cte.distribution.RetDistDFeInt;
import com.softart.dfe.components.internal.xml.marshaller.CteMarshallerFactory;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.interfaces.process.AfterRequest;
import com.softart.dfe.interfaces.process.cte.distribution.AfterDistribution;
import com.softart.dfe.interfaces.storage.cte.CteDistributionStorage;
import com.softart.dfe.models.internal.xml.XMLStore;

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
