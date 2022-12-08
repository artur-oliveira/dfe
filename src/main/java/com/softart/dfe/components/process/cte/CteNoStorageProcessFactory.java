package com.softart.dfe.components.process.cte;

import com.softart.dfe.components.process.cte.distribution.impl.DistributionCteProcessFactory;
import com.softart.dfe.components.process.cte.distribution.impl.nostore.NoStoreDistributionCteFactory;
import com.softart.dfe.components.process.cte.event.impl.EventCteProcessFactory;
import com.softart.dfe.components.process.cte.event.impl.nostore.NoStoreEventCteFactory;
import com.softart.dfe.components.process.cte.inutilization.impl.InutilizationCteProcessFactory;
import com.softart.dfe.components.process.cte.inutilization.impl.nostore.NoStoreInutilizationCteFactory;
import com.softart.dfe.components.process.cte.query_receipt.impl.QueryReceiptCteProcessFactory;
import com.softart.dfe.components.process.cte.query_receipt.impl.nostore.NoStoreQueryReceiptCteFactory;
import com.softart.dfe.components.process.cte.query_situation.impl.QuerySituationCteProcessFactory;
import com.softart.dfe.components.process.cte.query_situation.impl.nostore.NoStoreQuerySituationCteFactory;
import com.softart.dfe.components.process.cte.reception.impl.ReceptionCteProcessFactory;
import com.softart.dfe.components.process.cte.reception.impl.nostore.NoStoreReceptionCteFactory;
import com.softart.dfe.components.process.cte.reception_gtve.impl.GtveProcessFactory;
import com.softart.dfe.components.process.cte.reception_gtve.impl.nostore.NoStoreGtveFactory;
import com.softart.dfe.components.process.cte.reception_os.impl.CteOsProcessFactory;
import com.softart.dfe.components.process.cte.reception_os.impl.nostore.NoStoreCteOsFactory;
import com.softart.dfe.components.process.cte.reception_sync.impl.CteSyncProcessFactory;
import com.softart.dfe.components.process.cte.reception_sync.impl.nostore.NoStoreCteFactory;
import com.softart.dfe.components.process.cte.status_service.impl.StatusServiceCteProcessFactory;
import com.softart.dfe.components.process.cte.status_service.impl.nostore.NoStoreStatusServiceCteFactory;

final class CteNoStorageProcessFactory extends CteProcessFactory {

    @Override
    public DistributionCteProcessFactory distributionCteProcessFactory() {
        return new NoStoreDistributionCteFactory();
    }

    @Override
    public EventCteProcessFactory eventCteProcessFactory() {
        return new NoStoreEventCteFactory();
    }

    @Override
    public InutilizationCteProcessFactory inutilizationCteProcessFactory() {
        return new NoStoreInutilizationCteFactory();
    }

    @Override
    public QueryReceiptCteProcessFactory queryReceiptCteProcessFactory() {
        return new NoStoreQueryReceiptCteFactory();
    }

    @Override
    public QuerySituationCteProcessFactory querySituationCteProcessFactory() {
        return new NoStoreQuerySituationCteFactory();
    }

    @Override
    public ReceptionCteProcessFactory receptionCteProcessFactory() {
        return new NoStoreReceptionCteFactory();
    }

    @Override
    public GtveProcessFactory gtveProcessFactory() {
        return new NoStoreGtveFactory();
    }

    @Override
    public CteSyncProcessFactory cteSyncProcessFactory() {
        return new NoStoreCteFactory();
    }

    @Override
    public CteOsProcessFactory cteOsProcessFactory() {
        return new NoStoreCteOsFactory();
    }

    @Override
    public StatusServiceCteProcessFactory statusServiceCteProcessFactory() {
        return new NoStoreStatusServiceCteFactory();
    }
}
