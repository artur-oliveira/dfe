package com.softart.dfe.components.process.nf.distribution;

import br.inf.portalfiscal.nfe.distribution.TDistDFeInt;
import br.inf.portalfiscal.nfe.distribution.TRetDistDFeInt;
import com.softart.dfe.components.internal.xml.marshaller.NfMarshallerFactory;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.interfaces.process.AfterRequest;
import com.softart.dfe.interfaces.process.nf.distribution.AfterDistribution;
import com.softart.dfe.interfaces.storage.nf.NfeDistributionStorage;
import com.softart.dfe.models.internal.xml.XMLStore;

import java.util.Objects;

public abstract class StoreRetDistributionNfe implements AfterDistribution {
    @Override
    public <T extends AfterRequest<TDistDFeInt, TRetDistDFeInt>> void process(T o) throws ProcessException {
        if (Objects.nonNull(o.getRequest())) if (Objects.nonNull(getStorage()))
            getStorage().storeRetDistribution(new XMLStore<>(o.getResponse(), o.getConfig(), NfMarshallerFactory.getInstance().returnDistributionNfe(o.getResponse())));
    }

    public abstract NfeDistributionStorage getStorage();
}
