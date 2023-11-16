package org.dfe.components.process.mdfe;

import org.dfe.components.process.mdfe.distribution.impl.DistributionMdfeProcessFactory;
import org.dfe.components.process.mdfe.event.impl.EventMdfeProcessFactory;
import org.dfe.components.process.mdfe.query_receipt.impl.QueryReceiptMdfeProcessFactory;
import org.dfe.components.process.mdfe.query_situation.impl.QuerySituationMdfeProcessFactory;
import org.dfe.components.process.mdfe.query_unclosed.impl.QueryUnclosedMdfeProcessFactory;
import org.dfe.components.process.mdfe.reception.impl.ReceptionMdfeProcessFactory;
import org.dfe.components.process.mdfe.reception_sync.impl.ReceptionSyncMdfeProcessFactory;
import org.dfe.components.process.mdfe.status_service.impl.StatusServiceMdfeProcessFactory;

final class MdfeNoStorageProcessFactory extends MdfeProcessFactory {

    @Override
    public DistributionMdfeProcessFactory distributionMdfeProcessFactory() {
        return Holder.DISTRIBUTION;
    }

    @Override
    public EventMdfeProcessFactory eventMdfeProcessFactory() {
        return Holder.EVENT;
    }

    @Override
    public QueryReceiptMdfeProcessFactory queryReceiptMdfeProcessFactory() {
        return Holder.QUERYRECEIPT;
    }

    @Override
    public QuerySituationMdfeProcessFactory querySituationMdfeProcessFactory() {
        return Holder.QUERYSITUATION;
    }

    @Override
    public QueryUnclosedMdfeProcessFactory queryUnclosedMdfeProcessFactory() {
        return Holder.QUERYUNCLOSED;
    }

    @Override
    public ReceptionMdfeProcessFactory receptionMdfeProcessFactory() {
        return Holder.RECEPTION;
    }

    @Override
    public ReceptionSyncMdfeProcessFactory receptionSyncMdfeProcessFactory() {
        return Holder.RECEPTIONSYNC;
    }

    @Override
    public StatusServiceMdfeProcessFactory statusServiceMdfeProcessFactory() {
        return Holder.STATUSSERVICE;
    }

    private final static class Holder {
        static final DistributionMdfeProcessFactory DISTRIBUTION = DistributionMdfeProcessFactory.noStore();
        static final EventMdfeProcessFactory EVENT = EventMdfeProcessFactory.noStore();
        static final QueryReceiptMdfeProcessFactory QUERYRECEIPT = QueryReceiptMdfeProcessFactory.noStore();
        static final QuerySituationMdfeProcessFactory QUERYSITUATION = QuerySituationMdfeProcessFactory.noStore();
        static final QueryUnclosedMdfeProcessFactory QUERYUNCLOSED = QueryUnclosedMdfeProcessFactory.noStore();
        static final ReceptionMdfeProcessFactory RECEPTION = ReceptionMdfeProcessFactory.noStore();
        static final ReceptionSyncMdfeProcessFactory RECEPTIONSYNC = ReceptionSyncMdfeProcessFactory.noStore();
        static final StatusServiceMdfeProcessFactory STATUSSERVICE = StatusServiceMdfeProcessFactory.noStore();
    }
}
