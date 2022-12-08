package com.softart.dfe.interfaces.process.cte;

import com.softart.dfe.interfaces.process.DfProcess;
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

import java.util.Collection;

public interface CteProcess extends DfProcess {

    Collection<BeforeDistribution> beforeDistribution();

    Collection<AfterDistribution> afterDistribution();

    Collection<BeforeEvent> beforeEvent();

    Collection<AfterEvent> afterEvent();

    Collection<BeforeInutilization> beforeInutilization();

    Collection<AfterInutilization> afterInutilization();

    Collection<BeforeQueryReceipt> beforeQueryReceipt();

    Collection<AfterQueryReceipt> afterQueryReceipt();

    Collection<BeforeQuerySituation> beforeQuerySituation();

    Collection<AfterQuerySituation> afterQuerySituation();

    Collection<BeforeReception> beforeReception();

    Collection<AfterReception> afterReception();

    Collection<BeforeReceptionGtve> beforeGtve();

    Collection<AfterReceptionGtve> afterGtve();

    Collection<BeforeReceptionCteOs> beforeCteOs();

    Collection<AfterReceptionCteOs> afterCteOs();

    Collection<BeforeReceptionCteSync> beforeCteSync();

    Collection<AfterReceptionCteSync> afterCteSync();

    Collection<BeforeStatusService> beforeStatusService();

    Collection<AfterStatusService> afterStatusService();

}
