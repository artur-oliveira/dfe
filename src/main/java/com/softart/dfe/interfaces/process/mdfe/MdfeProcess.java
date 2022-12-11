package com.softart.dfe.interfaces.process.mdfe;

import com.softart.dfe.interfaces.process.DfProcess;
import com.softart.dfe.interfaces.process.mdfe.distribution.AfterDistribution;
import com.softart.dfe.interfaces.process.mdfe.distribution.BeforeDistribution;
import com.softart.dfe.interfaces.process.mdfe.event.AfterEvent;
import com.softart.dfe.interfaces.process.mdfe.event.BeforeEvent;
import com.softart.dfe.interfaces.process.mdfe.query_receipt.AfterQueryReceipt;
import com.softart.dfe.interfaces.process.mdfe.query_receipt.BeforeQueryReceipt;
import com.softart.dfe.interfaces.process.mdfe.query_situation.AfterQuerySituation;
import com.softart.dfe.interfaces.process.mdfe.query_situation.BeforeQuerySituation;
import com.softart.dfe.interfaces.process.mdfe.query_unclosed.AfterQueryUnclosed;
import com.softart.dfe.interfaces.process.mdfe.query_unclosed.BeforeQueryUnclosed;
import com.softart.dfe.interfaces.process.mdfe.reception.AfterReception;
import com.softart.dfe.interfaces.process.mdfe.reception.BeforeReception;
import com.softart.dfe.interfaces.process.mdfe.reception_sync.AfterReceptionSync;
import com.softart.dfe.interfaces.process.mdfe.reception_sync.BeforeReceptionSync;
import com.softart.dfe.interfaces.process.mdfe.status_service.AfterStatusService;
import com.softart.dfe.interfaces.process.mdfe.status_service.BeforeStatusService;

import java.util.Collection;

public interface MdfeProcess extends DfProcess {

    Collection<BeforeReception> beforeReception();

    Collection<BeforeQueryReceipt> beforeQueryReceipt();

    Collection<BeforeEvent> beforeEvent();

    Collection<BeforeQuerySituation> beforeQuerySituation();

    Collection<BeforeStatusService> beforeStatusService();

    Collection<BeforeQueryUnclosed> beforeQueryUnclosed();

    Collection<BeforeDistribution> beforeDistribution();

    Collection<BeforeReceptionSync> beforeReceptionSync();

    Collection<AfterReception> afterReception();

    Collection<AfterQueryReceipt> afterQueryReceipt();

    Collection<AfterEvent> afterEvent();

    Collection<AfterQuerySituation> afterQuerySituation();

    Collection<AfterStatusService> afterStatusService();

    Collection<AfterQueryUnclosed> afterQueryUnclosed();

    Collection<AfterDistribution> afterDistribution();

    Collection<AfterReceptionSync> afterReceptionSync();

}
