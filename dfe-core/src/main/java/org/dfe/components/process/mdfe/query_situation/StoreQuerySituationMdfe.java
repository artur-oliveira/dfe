package org.dfe.components.process.mdfe.query_situation;

import br.inf.portalfiscal.mdfe.classes.TConsSitMDFe;
import org.dfe.components.internal.xml.marshaller.MdfeMarshallerFactory;
import org.dfe.exceptions.ProcessException;
import org.dfe.interfaces.process.BeforeRequest;
import org.dfe.interfaces.process.mdfe.query_situation.BeforeQuerySituation;
import org.dfe.interfaces.storage.mdfe.MdfeQuerySituationStorage;
import org.dfe.models.internal.xml.XMLStore;

import java.util.Objects;

public abstract class StoreQuerySituationMdfe implements BeforeQuerySituation {

    @Override
    public <T extends BeforeRequest<TConsSitMDFe>> void process(T o) throws ProcessException {
        if (Objects.nonNull(o.config()) && Objects.nonNull(o.request())) {
            getStorage().storeSendQuerySituation(new XMLStore<>(o.request(), o.config(), MdfeMarshallerFactory.getInstance().sendQuerySituation(o.request())));
        }
    }

    public abstract MdfeQuerySituationStorage getStorage();

}
