package com.softart.dfe.components.process.mdfe.query_situation;

import br.inf.portalfiscal.mdfe.classes.TConsSitMDFe;
import br.inf.portalfiscal.mdfe.classes.TRetConsSitMDFe;
import com.softart.dfe.components.internal.xml.marshaller.MdfeMarshallerFactory;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.interfaces.process.AfterRequest;
import com.softart.dfe.interfaces.process.mdfe.query_situation.AfterQuerySituation;
import com.softart.dfe.interfaces.storage.mdfe.MdfeQuerySituationStorage;
import com.softart.dfe.models.internal.xml.XMLStore;

import java.util.Objects;

public abstract class StoreReturnQuerySituationMdfe implements AfterQuerySituation {

    @Override
    public <T extends AfterRequest<TConsSitMDFe, TRetConsSitMDFe>> void process(T o) throws ProcessException {
        if (Objects.nonNull(o.config()) && Objects.nonNull(o.request())) {
            getStorage().storeRetQuerySituation(new XMLStore<>(o.response(), o.config(), MdfeMarshallerFactory.getInstance().returnQuerySituation(o.response())));
        }
    }

    public abstract MdfeQuerySituationStorage getStorage();

}
