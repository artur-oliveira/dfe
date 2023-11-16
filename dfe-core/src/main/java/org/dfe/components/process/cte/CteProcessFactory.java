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

import java.util.Collection;

public abstract class CteProcessFactory implements CteProcessService {

    public static CteProcessFactory noStorageProcess() {
        return CteProcessFactoryHolder.NO_STORAGE_INSTANCE;
    }

    public static CteProcessFactory fileStorageProcess() {
        return CteProcessFactoryHolder.FILE_STORAGE_INSTANCE;
    }

    public static CteProcessFactory s3StorageProcess() {
        return S3CteProcessFactoryHolder.S3;
    }

    public abstract DistributionCteProcessFactory distributionCteProcessFactory();

    public abstract EventCteProcessFactory eventCteProcessFactory();

    public abstract InutilizationCteProcessFactory inutilizationCteProcessFactory();

    public abstract QueryReceiptCteProcessFactory queryReceiptCteProcessFactory();

    public abstract QuerySituationCteProcessFactory querySituationCteProcessFactory();

    public abstract ReceptionCteProcessFactory receptionCteProcessFactory();

    public abstract GtveProcessFactory gtveProcessFactory();

    public abstract CteSyncProcessFactory cteSyncProcessFactory();

    public abstract CteOsProcessFactory cteOsProcessFactory();

    public abstract StatusServiceCteProcessFactory statusServiceCteProcessFactory();

    @Override
    public Collection<BeforeDistribution> beforeDistribution() {
        return distributionCteProcessFactory().before();
    }

    @Override
    public Collection<AfterDistribution> afterDistribution() {
        return distributionCteProcessFactory().after();
    }

    @Override
    public Collection<AfterEvent> afterEvent() {
        return eventCteProcessFactory().after();
    }

    @Override
    public Collection<BeforeEvent> beforeEvent() {
        return eventCteProcessFactory().before();
    }

    @Override
    public Collection<BeforeInutilization> beforeInutilization() {
        return inutilizationCteProcessFactory().before();
    }

    @Override
    public Collection<AfterInutilization> afterInutilization() {
        return inutilizationCteProcessFactory().after();
    }

    @Override
    public Collection<BeforeQueryReceipt> beforeQueryReceipt() {
        return queryReceiptCteProcessFactory().before();
    }

    @Override
    public Collection<AfterQueryReceipt> afterQueryReceipt() {
        return queryReceiptCteProcessFactory().after();
    }

    @Override
    public Collection<BeforeQuerySituation> beforeQuerySituation() {
        return querySituationCteProcessFactory().before();
    }

    @Override
    public Collection<AfterQuerySituation> afterQuerySituation() {
        return querySituationCteProcessFactory().after();
    }

    @Override
    public Collection<BeforeReception> beforeReception() {
        return receptionCteProcessFactory().before();
    }

    @Override
    public Collection<AfterReception> afterReception() {
        return receptionCteProcessFactory().after();
    }

    @Override
    public Collection<BeforeReceptionGtve> beforeGtve() {
        return gtveProcessFactory().before();
    }

    @Override
    public Collection<AfterReceptionGtve> afterGtve() {
        return gtveProcessFactory().after();
    }

    @Override
    public Collection<BeforeReceptionCteOs> beforeCteOs() {
        return cteOsProcessFactory().before();
    }

    @Override
    public Collection<AfterReceptionCteOs> afterCteOs() {
        return cteOsProcessFactory().after();
    }

    @Override
    public Collection<BeforeReceptionCteSync> beforeCteSync() {
        return cteSyncProcessFactory().before();
    }

    @Override
    public Collection<AfterReceptionCteSync> afterCteSync() {
        return cteSyncProcessFactory().after();
    }

    @Override
    public Collection<BeforeStatusService> beforeStatusService() {
        return statusServiceCteProcessFactory().before();
    }

    @Override
    public Collection<AfterStatusService> afterStatusService() {
        return statusServiceCteProcessFactory().after();
    }

    private static class S3CteProcessFactoryHolder {
        private static final CteProcessFactory S3 = new CteS3StorageProcessFactory();
    }

    private static class CteProcessFactoryHolder {
        private static final CteProcessFactory NO_STORAGE_INSTANCE = new CteNoStorageProcessFactory();
        private static final CteProcessFactory FILE_STORAGE_INSTANCE = new CteFileStorageProcessFactory();
    }
}
