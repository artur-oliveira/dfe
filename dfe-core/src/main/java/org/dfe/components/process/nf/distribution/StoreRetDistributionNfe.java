package org.dfe.components.process.nf.distribution;

import br.inf.portalfiscal.nfe.distribution.TDistDFeInt;
import br.inf.portalfiscal.nfe.distribution.TRetDistDFeInt;
import org.dfe.components.internal.xml.marshaller.NfMarshallerFactory;
import org.dfe.exceptions.ProcessException;
import org.dfe.interfaces.process.AfterRequest;
import org.dfe.interfaces.process.nf.distribution.AfterDistribution;
import org.dfe.interfaces.storage.nf.NfeDistributionStorage;
import org.dfe.models.internal.xml.XMLStore;

import java.util.Objects;

public abstract class StoreRetDistributionNfe implements AfterDistribution {
    @Override
    public <T extends AfterRequest<TDistDFeInt, TRetDistDFeInt>> void process(T o) throws ProcessException {
        if (Objects.nonNull(o.request())) if (Objects.nonNull(getStorage()))
            getStorage().storeRetDistribution(new XMLStore<>(o.response(), o.config(), NfMarshallerFactory.getInstance().returnDistributionNfe(o.response())));
    }

    public abstract NfeDistributionStorage getStorage();
}
