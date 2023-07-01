package com.softart.dfe.models.internal.process;


import com.softart.dfe.components.process.cte4.Cte4ProcessFactory;
import com.softart.dfe.components.process.cte4.distribution.impl.DistributionCteProcessFactory;
import com.softart.dfe.components.process.cte4.event.impl.EventCteProcessFactory;
import com.softart.dfe.components.process.cte4.query_situation.impl.QuerySituationCteProcessFactory;
import com.softart.dfe.components.process.cte4.reception_gtve.impl.GtveProcessFactory;
import com.softart.dfe.components.process.cte4.reception_os.impl.CteOsProcessFactory;
import com.softart.dfe.components.process.cte4.reception_sync.impl.CteSyncProcessFactory;
import com.softart.dfe.components.process.cte4.status_service.impl.StatusServiceCteProcessFactory;
import com.softart.dfe.interfaces.process.cte.distribution.AfterDistribution;
import com.softart.dfe.interfaces.process.cte.distribution.BeforeDistribution;
import com.softart.dfe.interfaces.process.cte4.Cte4ProcessService;
import com.softart.dfe.interfaces.process.cte4.event.AfterEvent;
import com.softart.dfe.interfaces.process.cte4.event.BeforeEvent;
import com.softart.dfe.interfaces.process.cte4.query_situation.AfterQuerySituation;
import com.softart.dfe.interfaces.process.cte4.query_situation.BeforeQuerySituation;
import com.softart.dfe.interfaces.process.cte4.reception_gtve.AfterReceptionGtve;
import com.softart.dfe.interfaces.process.cte4.reception_gtve.BeforeReceptionGtve;
import com.softart.dfe.interfaces.process.cte4.reception_os.AfterReceptionCteOs;
import com.softart.dfe.interfaces.process.cte4.reception_os.BeforeReceptionCteOs;
import com.softart.dfe.interfaces.process.cte4.reception_sync.AfterReceptionCteSync;
import com.softart.dfe.interfaces.process.cte4.reception_sync.BeforeReceptionCteSync;
import com.softart.dfe.interfaces.process.cte4.status_service.AfterStatusService;
import com.softart.dfe.interfaces.process.cte4.status_service.BeforeStatusService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


public abstract class Cte4Process implements Cte4ProcessService {
    public static Cte4Process getInstance() {
        return switch (System.getProperty("com.softart.dfe.process.cte4", "default")) {
            case "s3" -> HolderS3.INSTANCE;
            default -> Holder.INSTANCE;
        };
    }

    public abstract List<Cte4ProcessFactory> getProcessFactories();

    public List<DistributionCteProcessFactory> distributions() {
        return getProcessFactories().stream().map(Cte4ProcessFactory::distributionCteProcessFactory).collect(Collectors.toList());
    }

    public List<EventCteProcessFactory> events() {
        return getProcessFactories().stream().map(Cte4ProcessFactory::eventCteProcessFactory).collect(Collectors.toList());
    }

    public List<QuerySituationCteProcessFactory> querySituations() {
        return getProcessFactories().stream().map(Cte4ProcessFactory::querySituationCteProcessFactory).collect(Collectors.toList());
    }

    public List<GtveProcessFactory> gtves() {
        return getProcessFactories().stream().map(Cte4ProcessFactory::gtveProcessFactory).collect(Collectors.toList());
    }

    public List<CteOsProcessFactory> cteOs() {
        return getProcessFactories().stream().map(Cte4ProcessFactory::cteOsProcessFactory).collect(Collectors.toList());
    }

    public List<CteSyncProcessFactory> cteSync() {
        return getProcessFactories().stream().map(Cte4ProcessFactory::cteSyncProcessFactory).collect(Collectors.toList());
    }

    public List<StatusServiceCteProcessFactory> statusServices() {
        return getProcessFactories().stream().map(Cte4ProcessFactory::statusServiceCteProcessFactory).collect(Collectors.toList());
    }

    @Override
    public Collection<BeforeDistribution> beforeDistribution() {
        return distributions().stream().map(it -> new ArrayList<>(it.before())).flatMap(List::stream).collect(Collectors.toList());
    }

    @Override
    public Collection<AfterDistribution> afterDistribution() {
        return distributions().stream().map(it -> new ArrayList<>(it.after())).flatMap(List::stream).collect(Collectors.toList());
    }


    @Override
    public Collection<AfterEvent> afterEvent() {
        return events().stream().map(it -> new ArrayList<>(it.after())).flatMap(List::stream).collect(Collectors.toList());
    }

    @Override
    public Collection<BeforeEvent> beforeEvent() {
        return events().stream().map(it -> new ArrayList<>(it.before())).flatMap(List::stream).collect(Collectors.toList());
    }

    @Override
    public Collection<BeforeQuerySituation> beforeQuerySituation() {
        return querySituations().stream().map(it -> new ArrayList<>(it.before())).flatMap(List::stream).collect(Collectors.toList());
    }

    @Override
    public Collection<AfterQuerySituation> afterQuerySituation() {
        return querySituations().stream().map(it -> new ArrayList<>(it.after())).flatMap(List::stream).collect(Collectors.toList());
    }

    @Override
    public Collection<BeforeReceptionGtve> beforeGtve() {
        return gtves().stream().map(it -> new ArrayList<>(it.before())).flatMap(List::stream).collect(Collectors.toList());
    }

    @Override
    public Collection<AfterReceptionGtve> afterGtve() {
        return gtves().stream().map(it -> new ArrayList<>(it.after())).flatMap(List::stream).collect(Collectors.toList());
    }

    @Override
    public Collection<BeforeReceptionCteOs> beforeCteOs() {
        return cteOs().stream().map(it -> new ArrayList<>(it.before())).flatMap(List::stream).collect(Collectors.toList());
    }

    @Override
    public Collection<AfterReceptionCteOs> afterCteOs() {
        return cteOs().stream().map(it -> new ArrayList<>(it.after())).flatMap(List::stream).collect(Collectors.toList());
    }

    @Override
    public Collection<BeforeReceptionCteSync> beforeCteSync() {
        return cteSync().stream().map(it -> new ArrayList<>(it.before())).flatMap(List::stream).collect(Collectors.toList());
    }

    @Override
    public Collection<AfterReceptionCteSync> afterCteSync() {
        return cteSync().stream().map(it -> new ArrayList<>(it.after())).flatMap(List::stream).collect(Collectors.toList());
    }

    @Override
    public Collection<BeforeStatusService> beforeStatusService() {
        return statusServices().stream().map(it -> new ArrayList<>(it.before())).flatMap(List::stream).collect(Collectors.toList());
    }

    @Override
    public Collection<AfterStatusService> afterStatusService() {
        return statusServices().stream().map(it -> new ArrayList<>(it.after())).flatMap(List::stream).collect(Collectors.toList());
    }

    static class HolderS3 {
        final static Cte4Process INSTANCE = new S3Cte4Process();
    }

    static class Holder {
        final static Cte4Process INSTANCE = new DefaultCte4Process();
    }
}
