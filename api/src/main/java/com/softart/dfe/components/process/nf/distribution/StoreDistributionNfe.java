package com.softart.dfe.components.process.nf.distribution;

import br.inf.portalfiscal.nfe.distribution.TDistDFeInt;
import com.softart.dfe.components.internal.xml.marshaller.NfMarshallerFactory;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.interfaces.process.BeforeRequest;
import com.softart.dfe.interfaces.process.nf.distribution.BeforeDistribution;
import com.softart.dfe.interfaces.storage.nf.NfeDistributionStorage;
import com.softart.dfe.models.internal.xml.XMLStore;

import java.util.Objects;

public abstract class StoreDistributionNfe implements BeforeDistribution {

    @Override
    public <T extends BeforeRequest<TDistDFeInt>> void process(T o) throws ProcessException {
        if (Objects.nonNull(o.getRequest())) if (Objects.nonNull(getStorage()))
            getStorage().storeEnvDistribution(new XMLStore<>(o.getRequest(), o.getConfig(), NfMarshallerFactory.getInstance().distributionNfe(o.getRequest())));
    }

    public abstract NfeDistributionStorage getStorage();

}
