package com.softart.dfe.components.process.cte;

import com.softart.dfe.components.process.cte.distribution.impl.DistributionCteProcessFactory;
import com.softart.dfe.components.process.cte.distribution.impl.file.FileSystemDistributionCteFactory;
import com.softart.dfe.components.process.cte.event.impl.EventCteProcessFactory;
import com.softart.dfe.components.process.cte.event.impl.file.FileSystemEventCteFactory;
import com.softart.dfe.components.process.cte.inutilization.impl.InutilizationCteProcessFactory;
import com.softart.dfe.components.process.cte.inutilization.impl.file.FileSystemInutilizationCteFactory;
import com.softart.dfe.components.process.cte.query_receipt.impl.QueryReceiptCteProcessFactory;
import com.softart.dfe.components.process.cte.query_receipt.impl.file.FileSystemQueryReceiptCteFactory;
import com.softart.dfe.components.process.cte.query_situation.impl.QuerySituationCteProcessFactory;
import com.softart.dfe.components.process.cte.query_situation.impl.file.FileSystemQuerySituationCteFactory;
import com.softart.dfe.components.process.cte.reception.impl.ReceptionCteProcessFactory;
import com.softart.dfe.components.process.cte.reception.impl.file.FileSystemReceptionCteFactory;
import com.softart.dfe.components.process.cte.reception_gtve.impl.GtveProcessFactory;
import com.softart.dfe.components.process.cte.reception_gtve.impl.file.FileSystemGtveFactory;
import com.softart.dfe.components.process.cte.reception_os.impl.CteOsProcessFactory;
import com.softart.dfe.components.process.cte.reception_os.impl.file.FileSystemCteOsFactory;
import com.softart.dfe.components.process.cte.reception_sync.impl.CteSyncProcessFactory;
import com.softart.dfe.components.process.cte.reception_sync.impl.file.FileSystemCteFactory;
import com.softart.dfe.components.process.cte.status_service.impl.StatusServiceCteProcessFactory;
import com.softart.dfe.components.process.cte.status_service.impl.file.FileSystemStatusServiceCteFactory;

final class CteFileStorageProcessFactory extends CteProcessFactory {
    @Override
    public DistributionCteProcessFactory distributionCteProcessFactory() {
        return new FileSystemDistributionCteFactory();
    }

    @Override
    public EventCteProcessFactory eventCteProcessFactory() {
        return new FileSystemEventCteFactory();
    }

    @Override
    public InutilizationCteProcessFactory inutilizationCteProcessFactory() {
        return new FileSystemInutilizationCteFactory();
    }

    @Override
    public QueryReceiptCteProcessFactory queryReceiptCteProcessFactory() {
        return new FileSystemQueryReceiptCteFactory();
    }

    @Override
    public QuerySituationCteProcessFactory querySituationCteProcessFactory() {
        return new FileSystemQuerySituationCteFactory();
    }

    @Override
    public ReceptionCteProcessFactory receptionCteProcessFactory() {
        return new FileSystemReceptionCteFactory();
    }

    @Override
    public GtveProcessFactory gtveProcessFactory() {
        return new FileSystemGtveFactory();
    }

    @Override
    public CteSyncProcessFactory cteSyncProcessFactory() {
        return new FileSystemCteFactory();
    }

    @Override
    public CteOsProcessFactory cteOsProcessFactory() {
        return new FileSystemCteOsFactory();
    }

    @Override
    public StatusServiceCteProcessFactory statusServiceCteProcessFactory() {
        return new FileSystemStatusServiceCteFactory();
    }
}
