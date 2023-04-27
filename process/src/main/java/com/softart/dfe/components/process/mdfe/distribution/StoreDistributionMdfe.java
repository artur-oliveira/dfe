package com.softart.dfe.components.process.mdfe.distribution;

import br.inf.portalfiscal.mdfe.classes.TDistDFe;
import com.softart.dfe.components.internal.xml.marshaller.MdfeMarshallerFactory;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.interfaces.process.BeforeRequest;
import com.softart.dfe.interfaces.process.mdfe.distribution.BeforeDistribution;
import com.softart.dfe.interfaces.storage.mdfe.MdfeDistributionStorage;
import com.softart.dfe.models.internal.xml.XMLStore;

import java.util.Objects;

public abstract class StoreDistributionMdfe implements BeforeDistribution {

    @Override
    public <T extends BeforeRequest<TDistDFe>> void process(T o) throws ProcessException {
        if (Objects.nonNull(o.getConfig()) && Objects.nonNull(o.getRequest())) {
            getStorage().storeSendDistribution(new XMLStore<>(o.getRequest(), o.getConfig(), MdfeMarshallerFactory.getInstance().sendDistribution(o.getRequest())));
        }
    }

    public abstract MdfeDistributionStorage getStorage();

}
