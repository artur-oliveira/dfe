package com.softart.dfe.components.process.mdfe.distribution;

import br.inf.portalfiscal.mdfe.classes.DistDFeInt;
import br.inf.portalfiscal.mdfe.classes.RetDistDFeInt;
import com.softart.dfe.components.internal.xml.marshaller.MdfeMarshaller;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.interfaces.process.AfterRequest;
import com.softart.dfe.interfaces.process.mdfe.distribution.AfterDistribution;
import com.softart.dfe.interfaces.storage.mdfe.MdfeDistributionStorage;
import com.softart.dfe.models.internal.xml.XMLStore;

import java.util.Objects;

public abstract class StoreReturnDistributionMdfe implements AfterDistribution {

    @Override
    public <T extends AfterRequest<DistDFeInt, RetDistDFeInt>> void process(T o) throws ProcessException {
        if (Objects.nonNull(o.getConfig()) && Objects.nonNull(o.getRequest())) {
            getStorage().storeRetDistribution(new XMLStore<>(o.getResponse(), o.getConfig(), MdfeMarshaller.returnDistribution(o.getResponse())));
        }
    }

    public abstract MdfeDistributionStorage getStorage();

}
