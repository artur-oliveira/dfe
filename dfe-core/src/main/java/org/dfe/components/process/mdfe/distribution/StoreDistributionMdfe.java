package org.dfe.components.process.mdfe.distribution;

import br.inf.portalfiscal.mdfe.classes.TDistDFe;
import org.dfe.components.internal.xml.marshaller.MdfeMarshallerFactory;
import org.dfe.exceptions.ProcessException;
import org.dfe.interfaces.process.BeforeRequest;
import org.dfe.interfaces.process.mdfe.distribution.BeforeDistribution;
import org.dfe.interfaces.storage.mdfe.MdfeDistributionStorage;
import org.dfe.models.internal.xml.XMLStore;

import java.util.Objects;

public abstract class StoreDistributionMdfe implements BeforeDistribution {

    @Override
    public <T extends BeforeRequest<TDistDFe>> void process(T o) throws ProcessException {
        if (Objects.nonNull(o.config()) && Objects.nonNull(o.request())) {
            getStorage().storeSendDistribution(new XMLStore<>(o.request(), o.config(), MdfeMarshallerFactory.getInstance().sendDistribution(o.request())));
        }
    }

    public abstract MdfeDistributionStorage getStorage();

}
