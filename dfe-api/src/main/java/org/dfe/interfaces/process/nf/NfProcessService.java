package org.dfe.interfaces.process.nf;

import org.dfe.interfaces.process.DfProcess;
import org.dfe.interfaces.process.nf.authorization.AfterAuthorization;
import org.dfe.interfaces.process.nf.authorization.BeforeAuthorization;
import org.dfe.interfaces.process.nf.distribution.AfterDistribution;
import org.dfe.interfaces.process.nf.distribution.BeforeDistribution;
import org.dfe.interfaces.process.nf.event.AfterEvent;
import org.dfe.interfaces.process.nf.event.BeforeEvent;
import org.dfe.interfaces.process.nf.inut.AfterInut;
import org.dfe.interfaces.process.nf.inut.BeforeInut;
import org.dfe.interfaces.process.nf.query_gtin.AfterQueryGtin;
import org.dfe.interfaces.process.nf.query_gtin.BeforeQueryGtin;
import org.dfe.interfaces.process.nf.query_protocol.AfterQueryProtocol;
import org.dfe.interfaces.process.nf.query_protocol.BeforeQueryProtocol;
import org.dfe.interfaces.process.nf.query_register.AfterQueryRegister;
import org.dfe.interfaces.process.nf.query_register.BeforeQueryRegister;
import org.dfe.interfaces.process.nf.query_status_service.AfterQueryStatusService;
import org.dfe.interfaces.process.nf.query_status_service.BeforeQueryStatusService;
import org.dfe.interfaces.process.nf.return_authorization.AfterReturnAuthorization;
import org.dfe.interfaces.process.nf.return_authorization.BeforeReturnAuthorization;

import java.util.Collection;

public interface NfProcessService extends DfProcess {

    /**
     * It returns a collection of AfterInut objects.
     *
     * @return A collection of AfterInut objects.
     */
    Collection<AfterInut> afterInutilization();

    /**
     * It returns a collection of BeforeInut objects.
     *
     * @return A collection of BeforeInut objects.
     */
    Collection<BeforeInut> beforeInutilization();

    /**
     * Returns a collection of all the afterEvent objects in the current process.
     *
     * @return A collection of afterEvent objects.
     */
    Collection<AfterEvent> afterEvent();

    /**
     * Returns a collection of all the beforeEvent objects in the current object.
     *
     * @return A collection of beforeEvent objects.
     */
    Collection<BeforeEvent> beforeEvent();

    /**
     * "Return a collection of AfterAuthorization objects that will be called after the user has been authorized."
     * <p>
     * The AfterAuthorization interface has a single method:
     * <p>
     * // Java
     * void afterAuthorization(HttpServletRequest request, HttpServletResponse response, User user);
     *
     * @return A collection of AfterAuthorization objects.
     */
    Collection<AfterAuthorization> afterAuthorization();

    /**
     * Return a collection of BeforeAuthorization objects that will be executed before authorization.
     *
     * @return A collection of BeforeAuthorization objects.
     */
    Collection<BeforeAuthorization> beforeAuthorization();

    /**
     * Return a collection of all the AfterReturnAuthorization objects that are associated with this object.
     *
     * @return A collection of AfterReturnAuthorization objects.
     */
    Collection<AfterReturnAuthorization> afterReturnAuthorization();

    /**
     * Returns a collection of all the BeforeReturnAuthorization objects that have been registered with the current
     * instance of the AuthorizationManager
     *
     * @return A collection of BeforeReturnAuthorization objects.
     */
    Collection<BeforeReturnAuthorization> beforeReturnAuthorization();

    /**
     * Returns a collection of all the `AfterQueryProtocol`s that have been registered with the `QueryManager`
     *
     * @return A collection of AfterQueryProtocol objects.
     */
    Collection<AfterQueryProtocol> afterQueryProtocol();

    /**
     * This function returns a collection of all the BeforeQueryProtocol objects that are registered with the
     * QueryManager.
     *
     * @return A collection of BeforeQueryProtocol objects.
     */
    Collection<BeforeQueryProtocol> beforeQueryProtocol();

    /**
     * This function returns a collection of services that are called after the query status is set
     *
     * @return A collection of AfterQueryStatusService objects.
     */
    Collection<AfterQueryStatusService> afterQueryStatusService();

    /**
     * Return a collection of services that will be called before the query status is executed.
     *
     * @return A collection of BeforeQueryStatusService objects.
     */
    Collection<BeforeQueryStatusService> beforeQueryStatusService();

    /**
     * Returns a collection of all the after distributions for this distribution
     *
     * @return A collection of AfterDistribution objects.
     */
    Collection<AfterDistribution> afterDistribution();

    /**
     * Returns a collection of all the BeforeDistribution objects in the current distribution
     *
     * @return A collection of BeforeDistribution objects.
     */
    Collection<BeforeDistribution> beforeDistribution();

    /**
     * It returns a collection of AfterQueryGtin objects.
     *
     * @return A collection of AfterQueryGtin objects.
     */
    Collection<AfterQueryGtin> afterQueryGtin();

    /**
     * This function returns a collection of BeforeQueryGtin objects
     *
     * @return A collection of BeforeQueryGtin objects.
     */
    Collection<BeforeQueryGtin> beforeQueryGtin();

    /**
     * This function is called after the query is executed and the results are returned
     *
     * @return A collection of AfterQueryRegister objects.
     */
    Collection<AfterQueryRegister> afterQueryRegister();

    /**
     * This function is called before the query is executed
     *
     * @return A collection of BeforeQueryRegister objects.
     */
    Collection<BeforeQueryRegister> beforeQueryRegister();
}
