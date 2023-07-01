package com.softart.dfe.interfaces.process.cte4;

import com.softart.dfe.interfaces.process.DfProcess;
import com.softart.dfe.interfaces.process.cte.distribution.AfterDistribution;
import com.softart.dfe.interfaces.process.cte.distribution.BeforeDistribution;
import com.softart.dfe.interfaces.process.cte4.event.AfterEvent;
import com.softart.dfe.interfaces.process.cte4.event.BeforeEvent;
import com.softart.dfe.interfaces.process.cte4.query_situation.AfterQuerySituation;
import com.softart.dfe.interfaces.process.cte4.query_situation.BeforeQuerySituation;
import com.softart.dfe.interfaces.process.cte4.reception_gtve.AfterReceptionGtve;
import com.softart.dfe.interfaces.process.cte4.reception_gtve.BeforeReceptionGtve;
import com.softart.dfe.interfaces.process.cte4.reception_os.AfterReceptionCteOs;
import com.softart.dfe.interfaces.process.cte4.reception_os.BeforeReceptionCteOs;
import com.softart.dfe.interfaces.process.cte4.reception_sync.AfterReceptionCteSync;
import com.softart.dfe.interfaces.process.cte4.reception_sync.BeforeReceptionCteSync;
import com.softart.dfe.interfaces.process.cte4.status_service.AfterStatusService;
import com.softart.dfe.interfaces.process.cte4.status_service.BeforeStatusService;

import java.util.Collection;

public interface Cte4ProcessService extends DfProcess {

    Collection<BeforeDistribution> beforeDistribution();

    /**
     * Returns a collection of all the after distributions for this distribution
     *
     * @return A collection of AfterDistribution objects.
     */
    Collection<AfterDistribution> afterDistribution();


    /**
     * Returns a collection of all the BeforeEvent objects that have been created.
     *
     * @return A collection of BeforeEvent objects.
     */
    Collection<BeforeEvent> beforeEvent();

    /**
     * Returns a collection of all the AfterEvent objects that are associated with this event.
     *
     * @return A collection of AfterEvent objects.
     */
    Collection<AfterEvent> afterEvent();

    /**
     * Returns a collection of situations that will be used to determine if the query should be executed
     *
     * @return A collection of BeforeQuerySituation objects.
     */
    Collection<BeforeQuerySituation> beforeQuerySituation();

    /**
     * Returns a collection of all the `AfterQuerySituation`s that have been registered with the `Query` object.
     *
     * @return A collection of AfterQuerySituation objects.
     */
    Collection<AfterQuerySituation> afterQuerySituation();


    /**
     * Return a collection of all the BeforeReceptionGtve objects in the current object.
     *
     * @return A collection of BeforeReceptionGtve objects.
     */
    Collection<BeforeReceptionGtve> beforeGtve();

    /**
     * Return a collection of all the AfterReceptionGtve objects in the database.
     *
     * @return A collection of AfterReceptionGtve objects.
     */
    Collection<AfterReceptionGtve> afterGtve();

    /**
     * Returns a collection of all the BeforeReceptionCteOs in the system.
     *
     * @return A collection of BeforeReceptionCteOs
     */
    Collection<BeforeReceptionCteOs> beforeCteOs();

    /**
     * Return a collection of all the AfterReceptionCteOs in the system.
     *
     * @return A collection of AfterReceptionCteOs
     */
    Collection<AfterReceptionCteOs> afterCteOs();

    /**
     * Return a collection of all the BeforeReceptionCteSync objects that are currently in the system.
     *
     * @return A collection of BeforeReceptionCteSync objects.
     */
    Collection<BeforeReceptionCteSync> beforeCteSync();

    /**
     * After the CTE is received, do this.
     *
     * @return A collection of AfterReceptionCteSync objects.
     */
    Collection<AfterReceptionCteSync> afterCteSync();

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
     * "Return a collection of all the AfterStatusService objects that are available to the system."
     * <p>
     * The function is called by the system when it needs to know what AfterStatusService objects are available
     *
     * @return A collection of AfterStatusService objects.
     */
    Collection<AfterStatusService> afterStatusService();

}
