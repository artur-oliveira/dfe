package org.dfe.models.internal.process;

import org.dfe.components.process.cte.CteProcessFactory;
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
import org.dfe.interfaces.process.cte.CteProcessService;
import org.dfe.interfaces.process.cte.distribution.AfterDistribution;
import org.dfe.interfaces.process.cte.distribution.BeforeDistribution;
import org.dfe.interfaces.process.cte.event.AfterEvent;
import org.dfe.interfaces.process.cte.event.BeforeEvent;
import org.dfe.interfaces.process.cte.inutilization.AfterInutilization;
import org.dfe.interfaces.process.cte.inutilization.BeforeInutilization;
import org.dfe.interfaces.process.cte.query_receipt.AfterQueryReceipt;
import org.dfe.interfaces.process.cte.query_receipt.BeforeQueryReceipt;
import org.dfe.interfaces.process.cte.query_situation.AfterQuerySituation;
import org.dfe.interfaces.process.cte.query_situation.BeforeQuerySituation;
import org.dfe.interfaces.process.cte.reception.AfterReception;
import org.dfe.interfaces.process.cte.reception.BeforeReception;
import org.dfe.interfaces.process.cte.reception_gtve.AfterReceptionGtve;
import org.dfe.interfaces.process.cte.reception_gtve.BeforeReceptionGtve;
import org.dfe.interfaces.process.cte.reception_os.AfterReceptionCteOs;
import org.dfe.interfaces.process.cte.reception_os.BeforeReceptionCteOs;
import org.dfe.interfaces.process.cte.reception_sync.AfterReceptionCteSync;
import org.dfe.interfaces.process.cte.reception_sync.BeforeReceptionCteSync;
import org.dfe.interfaces.process.cte.status_service.AfterStatusService;
import org.dfe.interfaces.process.cte.status_service.BeforeStatusService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


public abstract class CteProcess implements CteProcessService {
    public static CteProcess getInstance() {
        return switch (System.getProperty("org.dfe.process.cte", "default")) {
            case "s3" -> HolderS3.INSTANCE;
            default -> Holder.INSTANCE;
        };
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
