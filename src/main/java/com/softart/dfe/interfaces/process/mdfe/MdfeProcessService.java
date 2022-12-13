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

public interface MdfeProcessService extends DfProcess {

    /**
     * Returns a collection of all the BeforeReception annotations on this element.
     *
     * @return A collection of BeforeReception objects.
     */
    Collection<BeforeReception> beforeReception();

    /**
     * > This function is called before a query is executed
     *
     * @return A collection of BeforeQueryReceipt objects.
     */
    Collection<BeforeQueryReceipt> beforeQueryReceipt();

    /**
     * Returns a collection of all the BeforeEvent objects that have been created.
     *
     * @return A collection of BeforeEvent objects.
     */
    Collection<BeforeEvent> beforeEvent();

    /**
     * > Returns a collection of situations that will be used to determine if the query should be executed
     *
     * @return A collection of BeforeQuerySituation objects.
     */
    Collection<BeforeQuerySituation> beforeQuerySituation();

    /**
     * "Return a collection of all the BeforeStatusService objects that have been registered with the system."
     * <p>
     * The function is a factory function. It returns a collection of objects. The collection is a collection of
     * BeforeStatusService objects. The objects are registered with the system
     *
     * @return A collection of BeforeStatusService objects.
     */
    Collection<BeforeStatusService> beforeStatusService();

    /**
     * > Returns a collection of all the `BeforeQueryUnclosed` objects in the current `Query` object
     *
     * @return A collection of BeforeQueryUnclosed objects.
     */
    Collection<BeforeQueryUnclosed> beforeQueryUnclosed();

    /**
     * > Returns a collection of all the BeforeDistribution objects in the current distribution
     *
     * @return A collection of BeforeDistribution objects.
     */
    Collection<BeforeDistribution> beforeDistribution();

    /**
     * Return a collection of all the BeforeReceptionSync objects in the model.
     *
     * @return A collection of BeforeReceptionSync objects.
     */
    Collection<BeforeReceptionSync> beforeReceptionSync();

    /**
     * Return a collection of all the AfterReception annotations on this method.
     *
     * @return A collection of AfterReception objects.
     */
    Collection<AfterReception> afterReception();

    Collection<AfterQueryReceipt> afterQueryReceipt();

    /**
     * Returns a collection of all the AfterEvent objects that are associated with this event.
     *
     * @return A collection of AfterEvent objects.
     */
    Collection<AfterEvent> afterEvent();

    /**
     * > Returns a collection of all the `AfterQuerySituation`s that have been registered
     *
     * @return A collection of AfterQuerySituation objects.
     */
    Collection<AfterQuerySituation> afterQuerySituation();

    /**
     * "Return a collection of all the AfterStatusService objects that have been registered with the system."
     * <p>
     * The function is a bit more complicated than that, but that's the gist of it
     *
     * @return A collection of AfterStatusService objects.
     */
    Collection<AfterStatusService> afterStatusService();

    /**
     * Returns a collection of all the `AfterQueryUnclosed` objects in the current `Query` object
     *
     * @return A collection of AfterQueryUnclosed objects.
     */
    Collection<AfterQueryUnclosed> afterQueryUnclosed();

    /**
     * > Returns a collection of all the after distributions for this distribution
     *
     * @return A collection of AfterDistribution objects.
     */
    Collection<AfterDistribution> afterDistribution();

    /**
     * Return a collection of all the AfterReceptionSync objects in the model.
     *
     * @return A collection of AfterReceptionSync objects.
     */
    Collection<AfterReceptionSync> afterReceptionSync();

}
