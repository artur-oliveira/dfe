package org.dfe.components.process.cte4;

import org.dfe.components.process.cte4.distribution.impl.DistributionCteProcessFactory;
import org.dfe.components.process.cte4.event.impl.EventCteProcessFactory;
import org.dfe.components.process.cte4.query_situation.impl.QuerySituationCteProcessFactory;
import org.dfe.components.process.cte4.reception_gtve.impl.GtveProcessFactory;
import org.dfe.components.process.cte4.reception_os.impl.CteOsProcessFactory;
import org.dfe.components.process.cte4.reception_sync.impl.CteSyncProcessFactory;
import org.dfe.components.process.cte4.status_service.impl.StatusServiceCteProcessFactory;

final class CteNoStorageProcessFactory extends Cte4ProcessFactory {

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
        static final DistributionCteProcessFactory DISTRIBUTIONCTE = DistributionCteProcessFactory.noStore();
        static final EventCteProcessFactory EVENTCTE = EventCteProcessFactory.noStore();
        static final QuerySituationCteProcessFactory QUERYSITUATIONCTE = QuerySituationCteProcessFactory.noStore();
        static final GtveProcessFactory GTVE = GtveProcessFactory.noStore();
        static final CteSyncProcessFactory CTESYNC = CteSyncProcessFactory.noStore();
        static final CteOsProcessFactory CTEOS = CteOsProcessFactory.noStore();
        static final StatusServiceCteProcessFactory STATUSSERVICECTE = StatusServiceCteProcessFactory.noStore();
    }
}
