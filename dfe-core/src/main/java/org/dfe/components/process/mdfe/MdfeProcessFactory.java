package org.dfe.components.process.mdfe;

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

import java.util.Collection;

public abstract class MdfeProcessFactory implements MdfeProcessService {

    public static MdfeProcessFactory noStorageProcess() {
        return Holder.NO_STORAGE_INSTANCE;
    }

    public static MdfeProcessFactory fileStorageProcess() {
        return Holder.FILE_STORAGE_INSTANCE;
    }

    public static MdfeProcessFactory s3StorageProcess() {
        return HolderS3.INSTANCE;
    }

    public abstract DistributionMdfeProcessFactory distributionMdfeProcessFactory();

    public abstract EventMdfeProcessFactory eventMdfeProcessFactory();

    public abstract QueryReceiptMdfeProcessFactory queryReceiptMdfeProcessFactory();

    public abstract QuerySituationMdfeProcessFactory querySituationMdfeProcessFactory();

    public abstract QueryUnclosedMdfeProcessFactory queryUnclosedMdfeProcessFactory();

    public abstract ReceptionMdfeProcessFactory receptionMdfeProcessFactory();

    public abstract ReceptionSyncMdfeProcessFactory receptionSyncMdfeProcessFactory();

    public abstract StatusServiceMdfeProcessFactory statusServiceMdfeProcessFactory();

    @Override
    public Collection<BeforeReception> beforeReception() {
        return receptionMdfeProcessFactory().before();
    }

    @Override
    public Collection<BeforeQueryReceipt> beforeQueryReceipt() {
        return queryReceiptMdfeProcessFactory().before();
    }

    @Override
    public Collection<BeforeEvent> beforeEvent() {
        return eventMdfeProcessFactory().before();
    }

    @Override
    public Collection<BeforeQuerySituation> beforeQuerySituation() {
        return querySituationMdfeProcessFactory().before();
    }

    @Override
    public Collection<BeforeStatusService> beforeStatusService() {
        return statusServiceMdfeProcessFactory().before();
    }

    @Override
    public Collection<BeforeQueryUnclosed> beforeQueryUnclosed() {
        return queryUnclosedMdfeProcessFactory().before();
    }

    @Override
    public Collection<BeforeDistribution> beforeDistribution() {
        return distributionMdfeProcessFactory().before();
    }

    @Override
    public Collection<BeforeReceptionSync> beforeReceptionSync() {
        return receptionSyncMdfeProcessFactory().before();
    }

    @Override
    public Collection<AfterReception> afterReception() {
        return receptionMdfeProcessFactory().after();
    }

    @Override
    public Collection<AfterQueryReceipt> afterQueryReceipt() {
        return queryReceiptMdfeProcessFactory().after();
    }

    @Override
    public Collection<AfterEvent> afterEvent() {
        return eventMdfeProcessFactory().after();
    }

    @Override
    public Collection<AfterQuerySituation> afterQuerySituation() {
        return querySituationMdfeProcessFactory().after();
    }

    @Override
    public Collection<AfterStatusService> afterStatusService() {
        return statusServiceMdfeProcessFactory().after();
    }

    @Override
    public Collection<AfterQueryUnclosed> afterQueryUnclosed() {
        return queryUnclosedMdfeProcessFactory().after();
    }

    @Override
    public Collection<AfterDistribution> afterDistribution() {
        return distributionMdfeProcessFactory().after();
    }

    @Override
    public Collection<AfterReceptionSync> afterReceptionSync() {
        return receptionSyncMdfeProcessFactory().after();
    }

    static final class HolderS3 {
        final static MdfeProcessFactory INSTANCE = new MdfeS3StorageProcessFactory();
    }

    static final class Holder {
        final static MdfeProcessFactory NO_STORAGE_INSTANCE = new MdfeNoStorageProcessFactory();
        final static MdfeProcessFactory FILE_STORAGE_INSTANCE = new MdfeFileStorageProcessFactory();
    }
}
