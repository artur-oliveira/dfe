package com.softart.dfe.models.internal.process;

import com.softart.dfe.components.process.cte.CteProcessFactory;
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
import com.softart.dfe.interfaces.process.cte.CteProcessService;
import com.softart.dfe.interfaces.process.cte.distribution.AfterDistribution;
import com.softart.dfe.interfaces.process.cte.distribution.BeforeDistribution;
import com.softart.dfe.interfaces.process.cte.event.AfterEvent;
import com.softart.dfe.interfaces.process.cte.event.BeforeEvent;
import com.softart.dfe.interfaces.process.cte.inutilization.AfterInutilization;
import com.softart.dfe.interfaces.process.cte.inutilization.BeforeInutilization;
import com.softart.dfe.interfaces.process.cte.query_receipt.AfterQueryReceipt;
import com.softart.dfe.interfaces.process.cte.query_receipt.BeforeQueryReceipt;
import com.softart.dfe.interfaces.process.cte.query_situation.AfterQuerySituation;
import com.softart.dfe.interfaces.process.cte.query_situation.BeforeQuerySituation;
import com.softart.dfe.interfaces.process.cte.reception.AfterReception;
import com.softart.dfe.interfaces.process.cte.reception.BeforeReception;
import com.softart.dfe.interfaces.process.cte.reception_gtve.AfterReceptionGtve;
import com.softart.dfe.interfaces.process.cte.reception_gtve.BeforeReceptionGtve;
import com.softart.dfe.interfaces.process.cte.reception_os.AfterReceptionCteOs;
import com.softart.dfe.interfaces.process.cte.reception_os.BeforeReceptionCteOs;
import com.softart.dfe.interfaces.process.cte.reception_sync.AfterReceptionCteSync;
import com.softart.dfe.interfaces.process.cte.reception_sync.BeforeReceptionCteSync;
import com.softart.dfe.interfaces.process.cte.status_service.AfterStatusService;
import com.softart.dfe.interfaces.process.cte.status_service.BeforeStatusService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


public abstract class CteProcess implements CteProcessService {
    public static CteProcess getInstance() {
        switch (System.getProperty("com.softart.dfe.process.cte", "default")) {
            case "s3":
                return HolderS3.INSTANCE;
            case "default":
            default:
                return Holder.INSTANCE;
        }
    }

    public abstract List<CteProcessFactory> getProcessFactories();

    public List<InutilizationCteProcessFactory> inutilizations() {
        return getProcessFactories().stream().map(CteProcessFactory::inutilizationCteProcessFactory).collect(Collectors.toList());
    }

    public List<DistributionCteProcessFactory> distributions() {
        return getProcessFactories().stream().map(CteProcessFactory::distributionCteProcessFactory).collect(Collectors.toList());
    }

    public List<EventCteProcessFactory> events() {
        return getProcessFactories().stream().map(CteProcessFactory::eventCteProcessFactory).collect(Collectors.toList());
    }

    public List<QueryReceiptCteProcessFactory> queryReceipts() {
        return getProcessFactories().stream().map(CteProcessFactory::queryReceiptCteProcessFactory).collect(Collectors.toList());
    }

    public List<QuerySituationCteProcessFactory> querySituations() {
        return getProcessFactories().stream().map(CteProcessFactory::querySituationCteProcessFactory).collect(Collectors.toList());
    }

    public List<ReceptionCteProcessFactory> receptions() {
        return getProcessFactories().stream().map(CteProcessFactory::receptionCteProcessFactory).collect(Collectors.toList());
    }

    public List<GtveProcessFactory> gtves() {
        return getProcessFactories().stream().map(CteProcessFactory::gtveProcessFactory).collect(Collectors.toList());
    }

    public List<CteOsProcessFactory> cteOs() {
        return getProcessFactories().stream().map(CteProcessFactory::cteOsProcessFactory).collect(Collectors.toList());
    }

    public List<CteSyncProcessFactory> cteSync() {
        return getProcessFactories().stream().map(CteProcessFactory::cteSyncProcessFactory).collect(Collectors.toList());
    }

    public List<StatusServiceCteProcessFactory> statusServices() {
        return getProcessFactories().stream().map(CteProcessFactory::statusServiceCteProcessFactory).collect(Collectors.toList());
    }

    @Override
    public Collection<AfterInutilization> afterInutilization() {
        return inutilizations().stream().map(it -> new ArrayList<>(it.after())).flatMap(List::stream).collect(Collectors.toList());
    }

    @Override
    public Collection<BeforeInutilization> beforeInutilization() {
        return inutilizations().stream().map(it -> new ArrayList<>(it.before())).flatMap(List::stream).collect(Collectors.toList());
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
    public Collection<BeforeDistribution> beforeDistribution() {
        return distributions().stream().map(it -> new ArrayList<>(it.before())).flatMap(List::stream).collect(Collectors.toList());
    }

    @Override
    public Collection<AfterDistribution> afterDistribution() {
        return distributions().stream().map(it -> new ArrayList<>(it.after())).flatMap(List::stream).collect(Collectors.toList());
    }

    @Override
    public Collection<BeforeQueryReceipt> beforeQueryReceipt() {
        return queryReceipts().stream().map(it -> new ArrayList<>(it.before())).flatMap(List::stream).collect(Collectors.toList());
    }

    @Override
    public Collection<AfterQueryReceipt> afterQueryReceipt() {
        return queryReceipts().stream().map(it -> new ArrayList<>(it.after())).flatMap(List::stream).collect(Collectors.toList());
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
    public Collection<BeforeReception> beforeReception() {
        return receptions().stream().map(it -> new ArrayList<>(it.before())).flatMap(List::stream).collect(Collectors.toList());
    }

    @Override
    public Collection<AfterReception> afterReception() {
        return receptions().stream().map(it -> new ArrayList<>(it.after())).flatMap(List::stream).collect(Collectors.toList());
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
        final static CteProcess INSTANCE = new S3CteProcess();
    }

    static class Holder {
        final static CteProcess INSTANCE = new DefaultCteProcess();
    }
}
