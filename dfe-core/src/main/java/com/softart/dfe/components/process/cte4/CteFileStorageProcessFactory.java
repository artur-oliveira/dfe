package com.softart.dfe.components.process.cte4;

import com.softart.dfe.components.process.cte4.distribution.impl.DistributionCteProcessFactory;
import com.softart.dfe.components.process.cte4.event.impl.EventCteProcessFactory;
import com.softart.dfe.components.process.cte4.query_situation.impl.QuerySituationCteProcessFactory;
import com.softart.dfe.components.process.cte4.reception_gtve.impl.GtveProcessFactory;
import com.softart.dfe.components.process.cte4.reception_os.impl.CteOsProcessFactory;
import com.softart.dfe.components.process.cte4.reception_sync.impl.CteSyncProcessFactory;
import com.softart.dfe.components.process.cte4.status_service.impl.StatusServiceCteProcessFactory;

final class CteFileStorageProcessFactory extends Cte4ProcessFactory {

    @Override
    public DistributionCteProcessFactory distributionCteProcessFactory() {
        return Holder.DISTRIBUTIONCTE;
    }

    @Override
    public EventCteProcessFactory eventCteProcessFactory() {
        return Holder.EVENTCTE;
    }

    @Override
    public QuerySituationCteProcessFactory querySituationCteProcessFactory() {
        return Holder.QUERYSITUATIONCTE;
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
        static final QuerySituationCteProcessFactory QUERYSITUATIONCTE = QuerySituationCteProcessFactory.fileStore();
        static final GtveProcessFactory GTVE = GtveProcessFactory.fileStore();
        static final CteSyncProcessFactory CTESYNC = CteSyncProcessFactory.fileStore();
        static final CteOsProcessFactory CTEOS = CteOsProcessFactory.fileStore();
        static final StatusServiceCteProcessFactory STATUSSERVICECTE = StatusServiceCteProcessFactory.fileStore();
    }
}
