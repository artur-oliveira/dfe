package org.dfe.components.process.cte4;

import org.dfe.components.process.cte4.distribution.impl.DistributionCteProcessFactory;
import org.dfe.components.process.cte4.event.impl.EventCteProcessFactory;
import org.dfe.components.process.cte4.query_situation.impl.QuerySituationCteProcessFactory;
import org.dfe.components.process.cte4.reception_gtve.impl.GtveProcessFactory;
import org.dfe.components.process.cte4.reception_os.impl.CteOsProcessFactory;
import org.dfe.components.process.cte4.reception_sync.impl.CteSyncProcessFactory;
import org.dfe.components.process.cte4.status_service.impl.StatusServiceCteProcessFactory;
import org.dfe.interfaces.process.cte4.Cte4ProcessService;
import org.dfe.interfaces.process.cte4.distribution.AfterDistribution;
import org.dfe.interfaces.process.cte4.distribution.BeforeDistribution;
import org.dfe.interfaces.process.cte4.event.AfterEvent;
import org.dfe.interfaces.process.cte4.event.BeforeEvent;
import org.dfe.interfaces.process.cte4.query_situation.AfterQuerySituation;
import org.dfe.interfaces.process.cte4.query_situation.BeforeQuerySituation;
import org.dfe.interfaces.process.cte4.reception_gtve.AfterReceptionGtve;
import org.dfe.interfaces.process.cte4.reception_gtve.BeforeReceptionGtve;
import org.dfe.interfaces.process.cte4.reception_os.AfterReceptionCteOs;
import org.dfe.interfaces.process.cte4.reception_os.BeforeReceptionCteOs;
import org.dfe.interfaces.process.cte4.reception_sync.AfterReceptionCteSync;
import org.dfe.interfaces.process.cte4.reception_sync.BeforeReceptionCteSync;
import org.dfe.interfaces.process.cte4.status_service.AfterStatusService;
import org.dfe.interfaces.process.cte4.status_service.BeforeStatusService;

import java.util.Collection;

public abstract class Cte4ProcessFactory implements Cte4ProcessService {

    public static Cte4ProcessFactory noStorageProcess() {
        return CteProcessFactoryHolder.NO_STORAGE_INSTANCE;
    }

    public static Cte4ProcessFactory fileStorageProcess() {
        return CteProcessFactoryHolder.FILE_STORAGE_INSTANCE;
    }

    public static Cte4ProcessFactory s3StorageProcess() {
        return S3CteProcessFactoryHolder.S3;
    }

    public abstract DistributionCteProcessFactory distributionCteProcessFactory();

    public abstract EventCteProcessFactory eventCteProcessFactory();

    public abstract QuerySituationCteProcessFactory querySituationCteProcessFactory();

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
    public Collection<BeforeQuerySituation> beforeQuerySituation() {
        return querySituationCteProcessFactory().before();
    }

    @Override
    public Collection<AfterQuerySituation> afterQuerySituation() {
        return querySituationCteProcessFactory().after();
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
        private static final Cte4ProcessFactory S3 = new CteS3StorageProcessFactory();
    }

    private static class CteProcessFactoryHolder {
        private static final Cte4ProcessFactory NO_STORAGE_INSTANCE = new CteNoStorageProcessFactory();
        private static final Cte4ProcessFactory FILE_STORAGE_INSTANCE = new CteFileStorageProcessFactory();
    }
}
