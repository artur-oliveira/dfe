package org.dfe.models.internal.process;

import org.dfe.components.process.mdfe.MdfeProcessFactory;
import org.dfe.components.process.mdfe.distribution.impl.DistributionMdfeProcessFactory;
import org.dfe.components.process.mdfe.event.impl.EventMdfeProcessFactory;
import org.dfe.components.process.mdfe.query_receipt.impl.QueryReceiptMdfeProcessFactory;
import org.dfe.components.process.mdfe.query_situation.impl.QuerySituationMdfeProcessFactory;
import org.dfe.components.process.mdfe.query_unclosed.impl.QueryUnclosedMdfeProcessFactory;
import org.dfe.components.process.mdfe.reception.impl.ReceptionMdfeProcessFactory;
import org.dfe.components.process.mdfe.reception_sync.impl.ReceptionSyncMdfeProcessFactory;
import org.dfe.components.process.mdfe.status_service.impl.StatusServiceMdfeProcessFactory;
import org.dfe.interfaces.process.mdfe.MdfeProcessService;
import org.dfe.interfaces.process.mdfe.distribution.AfterDistribution;
import org.dfe.interfaces.process.mdfe.distribution.BeforeDistribution;
import org.dfe.interfaces.process.mdfe.event.AfterEvent;
import org.dfe.interfaces.process.mdfe.event.BeforeEvent;
import org.dfe.interfaces.process.mdfe.query_receipt.AfterQueryReceipt;
import org.dfe.interfaces.process.mdfe.query_receipt.BeforeQueryReceipt;
import org.dfe.interfaces.process.mdfe.query_situation.AfterQuerySituation;
import org.dfe.interfaces.process.mdfe.query_situation.BeforeQuerySituation;
import org.dfe.interfaces.process.mdfe.query_unclosed.AfterQueryUnclosed;
import org.dfe.interfaces.process.mdfe.query_unclosed.BeforeQueryUnclosed;
import org.dfe.interfaces.process.mdfe.reception.AfterReception;
import org.dfe.interfaces.process.mdfe.reception.BeforeReception;
import org.dfe.interfaces.process.mdfe.reception_sync.AfterReceptionSync;
import org.dfe.interfaces.process.mdfe.reception_sync.BeforeReceptionSync;
import org.dfe.interfaces.process.mdfe.status_service.AfterStatusService;
import org.dfe.interfaces.process.mdfe.status_service.BeforeStatusService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public abstract class MdfeProcess implements MdfeProcessService {

    public static MdfeProcess getInstance() {
        return switch (System.getProperty("org.dfe.process.mdfe", "default")) {
            case "s3" -> HolderS3.INSTANCE;
            default -> Holder.INSTANCE;
        };
    }

    public abstract List<MdfeProcessFactory> getProcessFactories();

    private List<ReceptionMdfeProcessFactory> receptionFactory() {
        return getProcessFactories().stream().map(MdfeProcessFactory::receptionMdfeProcessFactory).collect(Collectors.toList());
    }

    private List<QueryReceiptMdfeProcessFactory> queryReceiptFactory() {
        return getProcessFactories().stream().map(MdfeProcessFactory::queryReceiptMdfeProcessFactory).collect(Collectors.toList());
    }

    private List<EventMdfeProcessFactory> eventFactory() {
        return getProcessFactories().stream().map(MdfeProcessFactory::eventMdfeProcessFactory).collect(Collectors.toList());
    }

    private List<QuerySituationMdfeProcessFactory> querySituationFactory() {
        return getProcessFactories().stream().map(MdfeProcessFactory::querySituationMdfeProcessFactory).collect(Collectors.toList());
    }

    private List<StatusServiceMdfeProcessFactory> statusServiceFactory() {
        return getProcessFactories().stream().map(MdfeProcessFactory::statusServiceMdfeProcessFactory).collect(Collectors.toList());
    }

    private List<QueryUnclosedMdfeProcessFactory> queryUnclosedFactory() {
        return getProcessFactories().stream().map(MdfeProcessFactory::queryUnclosedMdfeProcessFactory).collect(Collectors.toList());
    }

    private List<DistributionMdfeProcessFactory> distributionFactory() {
        return getProcessFactories().stream().map(MdfeProcessFactory::distributionMdfeProcessFactory).collect(Collectors.toList());
    }

    private List<ReceptionSyncMdfeProcessFactory> receptionSyncFactory() {
        return getProcessFactories().stream().map(MdfeProcessFactory::receptionSyncMdfeProcessFactory).collect(Collectors.toList());
    }

    @Override
    public Collection<BeforeReception> beforeReception() {
        return receptionFactory().stream().map(it -> new ArrayList<>(it.before())).flatMap(List::stream).collect(Collectors.toList());
    }

    @Override
    public Collection<BeforeQueryReceipt> beforeQueryReceipt() {
        return queryReceiptFactory().stream().map(it -> new ArrayList<>(it.before())).flatMap(List::stream).collect(Collectors.toList());
    }

    @Override
    public Collection<BeforeEvent> beforeEvent() {
        return eventFactory().stream().map(it -> new ArrayList<>(it.before())).flatMap(List::stream).collect(Collectors.toList());
    }

    @Override
    public Collection<BeforeQuerySituation> beforeQuerySituation() {
        return querySituationFactory().stream().map(it -> new ArrayList<>(it.before())).flatMap(List::stream).collect(Collectors.toList());
    }

    @Override
    public Collection<BeforeStatusService> beforeStatusService() {
        return statusServiceFactory().stream().map(it -> new ArrayList<>(it.before())).flatMap(List::stream).collect(Collectors.toList());
    }

    @Override
    public Collection<BeforeQueryUnclosed> beforeQueryUnclosed() {
        return queryUnclosedFactory().stream().map(it -> new ArrayList<>(it.before())).flatMap(List::stream).collect(Collectors.toList());
    }

    @Override
    public Collection<BeforeDistribution> beforeDistribution() {
        return distributionFactory().stream().map(it -> new ArrayList<>(it.before())).flatMap(List::stream).collect(Collectors.toList());
    }

    @Override
    public Collection<BeforeReceptionSync> beforeReceptionSync() {
        return receptionSyncFactory().stream().map(it -> new ArrayList<>(it.before())).flatMap(List::stream).collect(Collectors.toList());
    }

    @Override
    public Collection<AfterReception> afterReception() {
        return receptionFactory().stream().map(it -> new ArrayList<>(it.after())).flatMap(List::stream).collect(Collectors.toList());
    }

    @Override
    public Collection<AfterQueryReceipt> afterQueryReceipt() {
        return queryReceiptFactory().stream().map(it -> new ArrayList<>(it.after())).flatMap(List::stream).collect(Collectors.toList());
    }

    @Override
    public Collection<AfterEvent> afterEvent() {
        return eventFactory().stream().map(it -> new ArrayList<>(it.after())).flatMap(List::stream).collect(Collectors.toList());
    }

    @Override
    public Collection<AfterQuerySituation> afterQuerySituation() {
        return querySituationFactory().stream().map(it -> new ArrayList<>(it.after())).flatMap(List::stream).collect(Collectors.toList());
    }

    @Override
    public Collection<AfterStatusService> afterStatusService() {
        return statusServiceFactory().stream().map(it -> new ArrayList<>(it.after())).flatMap(List::stream).collect(Collectors.toList());
    }

    @Override
    public Collection<AfterQueryUnclosed> afterQueryUnclosed() {
        return queryUnclosedFactory().stream().map(it -> new ArrayList<>(it.after())).flatMap(List::stream).collect(Collectors.toList());
    }

    @Override
    public Collection<AfterDistribution> afterDistribution() {
        return distributionFactory().stream().map(it -> new ArrayList<>(it.after())).flatMap(List::stream).collect(Collectors.toList());
    }

    @Override
    public Collection<AfterReceptionSync> afterReceptionSync() {
        return receptionSyncFactory().stream().map(it -> new ArrayList<>(it.after())).flatMap(List::stream).collect(Collectors.toList());
    }

    final static class HolderS3 {
        final static MdfeProcess INSTANCE = new S3MdfeProcess();
    }

    final static class Holder {
        final static MdfeProcess INSTANCE = new DefaultMdfeProcess();
    }
}
