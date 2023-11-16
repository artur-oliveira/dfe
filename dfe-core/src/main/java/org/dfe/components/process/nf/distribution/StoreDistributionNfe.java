package org.dfe.components.process.nf.distribution;

import br.inf.portalfiscal.nfe.distribution.TDistDFeInt;
import org.dfe.components.internal.xml.marshaller.NfMarshallerFactory;
import org.dfe.exceptions.ProcessException;
import org.dfe.interfaces.process.BeforeRequest;
import org.dfe.interfaces.process.nf.distribution.BeforeDistribution;
import org.dfe.interfaces.storage.nf.NfeDistributionStorage;
import org.dfe.models.internal.xml.XMLStore;

import java.util.Objects;

public abstract class StoreDistributionNfe implements BeforeDistribution {

    @Override
    public <T extends BeforeRequest<TDistDFeInt>> void process(T o) throws ProcessException {
        if (Objects.nonNull(o.request())) if (Objects.nonNull(getStorage()))
            getStorage().storeEnvDistribution(new XMLStore<>(o.request(), o.config(), NfMarshallerFactory.getInstance().distributionNfe(o.request())));
    }

    public abstract NfeDistributionStorage getStorage();

}
