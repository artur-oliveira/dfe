package org.dfe.components.process.cte;

import org.dfe.components.process.cte.distribution.impl.DistributionCteProcessFactory;
import org.dfe.components.process.cte.event.impl.EventCteProcessFactory;
import org.dfe.components.process.cte.inutilization.impl.InutilizationCteProcessFactory;
import org.dfe.components.process.cte.query_receipt.impl.QueryReceiptCteProcessFactory;
import org.dfe.components.process.cte.query_situation.impl.QuerySituationCteProcessFactory;
import org.dfe.components.process.cte.reception.impl.ReceptionCteProcessFactory;
import org.dfe.components.process.cte.reception_gtve.impl.GtveProcessFactory;
import org.dfe.components.process.cte.reception_os.impl.CteOsProcessFactory;
import org.dfe.components.process.cte.reception_sync.impl.CteSyncProcessFactory;
import org.dfe.components.process.cte.status_service.impl.StatusServiceCteProcessFactory;

final class CteNoStorageProcessFactory extends CteProcessFactory {

    @Override
    public DistributionCteProcessFactory distributionCteProcessFactory() {
        return Holder.DISTRIBUTIONCTE;
    }

    @Override
    public EventCteProcessFactory eventCteProcessFactory() {
        return Holder.EVENTCTE;
    }

    @Override
    public InutilizationCteProcessFactory inutilizationCteProcessFactory() {
        return Holder.INUTILIZATIONCTE;
    }

    @Override
    public QueryReceiptCteProcessFactory queryReceiptCteProcessFactory() {
        return Holder.QUERYRECEIPTCTE;
    }

    @Override
    public QuerySituationCteProcessFactory querySituationCteProcessFactory() {
        return Holder.QUERYSITUATIONCTE;
    }

    @Override
    public ReceptionCteProcessFactory receptionCteProcessFactory() {
        return Holder.RECEPTIONCTE;
    }

    @Override
    public GtveProcessFactory gtveProcessFactory() {
        return Holder.GTVE;
    }

    @Override
    public CteSyncProcessFactory cteSyncProcessFactory() {
        return Holder.CTESYNC;
    }

    @Override
    public CteOsProcessFactory cteOsProcessFactory() {
        return Holder.CTEOS;
    }

    @Override
    public StatusServiceCteProcessFactory statusServiceCteProcessFactory() {
        return Holder.STATUSSERVICECTE;
    }

    static final class Holder {
        static final DistributionCteProcessFactory DISTRIBUTIONCTE = DistributionCteProcessFactory.noStore();
        static final EventCteProcessFactory EVENTCTE = EventCteProcessFactory.noStore();
        static final InutilizationCteProcessFactory INUTILIZATIONCTE = InutilizationCteProcessFactory.noStore();
        static final QueryReceiptCteProcessFactory QUERYRECEIPTCTE = QueryReceiptCteProcessFactory.noStore();
        static final QuerySituationCteProcessFactory QUERYSITUATIONCTE = QuerySituationCteProcessFactory.noStore();
        static final ReceptionCteProcessFactory RECEPTIONCTE = ReceptionCteProcessFactory.noStore();
        static final GtveProcessFactory GTVE = GtveProcessFactory.noStore();
        static final CteSyncProcessFactory CTESYNC = CteSyncProcessFactory.noStore();
        static final CteOsProcessFactory CTEOS = CteOsProcessFactory.noStore();
        static final StatusServiceCteProcessFactory STATUSSERVICECTE = StatusServiceCteProcessFactory.noStore();
    }
}
