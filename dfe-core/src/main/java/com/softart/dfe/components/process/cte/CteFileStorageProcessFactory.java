package com.softart.dfe.components.process.cte;

import com.softart.dfe.components.process.cte.distribution.impl.DistributionCteProcessFactory;
import com.softart.dfe.components.process.cte.event.impl.EventCteProcessFactory;
import com.softart.dfe.components.process.cte.inutilization.impl.InutilizationCteProcessFactory;
import com.softart.dfe.components.process.cte.query_receipt.impl.QueryReceiptCteProcessFactory;
import com.softart.dfe.components.process.cte.query_situation.impl.QuerySituationCteProcessFactory;
import com.softart.dfe.components.process.cte.reception.impl.ReceptionCteProcessFactory;
import com.softart.dfe.components.process.cte.reception_gtve.impl.GtveProcessFactory;
import com.softart.dfe.components.process.cte.reception_os.impl.CteOsProcessFactory;
import com.softart.dfe.components.process.cte.reception_sync.impl.CteSyncProcessFactory;
import com.softart.dfe.components.process.cte.status_service.impl.StatusServiceCteProcessFactory;

final class CteFileStorageProcessFactory extends CteProcessFactory {

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
        static final DistributionCteProcessFactory DISTRIBUTIONCTE = DistributionCteProcessFactory.fileStore();
        static final EventCteProcessFactory EVENTCTE = EventCteProcessFactory.fileStore();
        static final InutilizationCteProcessFactory INUTILIZATIONCTE = InutilizationCteProcessFactory.fileStore();
        static final QueryReceiptCteProcessFactory QUERYRECEIPTCTE = QueryReceiptCteProcessFactory.fileStore();
        static final QuerySituationCteProcessFactory QUERYSITUATIONCTE = QuerySituationCteProcessFactory.fileStore();
        static final ReceptionCteProcessFactory RECEPTIONCTE = ReceptionCteProcessFactory.fileStore();
        static final GtveProcessFactory GTVE = GtveProcessFactory.fileStore();
        static final CteSyncProcessFactory CTESYNC = CteSyncProcessFactory.fileStore();
        static final CteOsProcessFactory CTEOS = CteOsProcessFactory.fileStore();
        static final StatusServiceCteProcessFactory STATUSSERVICECTE = StatusServiceCteProcessFactory.fileStore();
    }
}
