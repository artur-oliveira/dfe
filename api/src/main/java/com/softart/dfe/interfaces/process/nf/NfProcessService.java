package com.softart.dfe.interfaces.process.nf;

import com.softart.dfe.interfaces.process.DfProcess;
import com.softart.dfe.interfaces.process.nf.authorization.AfterAuthorization;
import com.softart.dfe.interfaces.process.nf.authorization.BeforeAuthorization;
import com.softart.dfe.interfaces.process.nf.cancel.AfterCancel;
import com.softart.dfe.interfaces.process.nf.cancel.BeforeCancel;
import com.softart.dfe.interfaces.process.nf.correction_letter.AfterCorrectionLetter;
import com.softart.dfe.interfaces.process.nf.correction_letter.BeforeCorrectionLetter;
import com.softart.dfe.interfaces.process.nf.distribution.AfterDistribution;
import com.softart.dfe.interfaces.process.nf.distribution.BeforeDistribution;
import com.softart.dfe.interfaces.process.nf.epec.AfterEpec;
import com.softart.dfe.interfaces.process.nf.epec.BeforeEpec;
import com.softart.dfe.interfaces.process.nf.interested_actor.AfterInterestedActor;
import com.softart.dfe.interfaces.process.nf.interested_actor.BeforeInterestedActor;
import com.softart.dfe.interfaces.process.nf.inut.AfterInut;
import com.softart.dfe.interfaces.process.nf.inut.BeforeInut;
import com.softart.dfe.interfaces.process.nf.manifestation.AfterManifestation;
import com.softart.dfe.interfaces.process.nf.manifestation.BeforeManifestation;
import com.softart.dfe.interfaces.process.nf.query_gtin.AfterQueryGtin;
import com.softart.dfe.interfaces.process.nf.query_gtin.BeforeQueryGtin;
import com.softart.dfe.interfaces.process.nf.query_protocol.AfterQueryProtocol;
import com.softart.dfe.interfaces.process.nf.query_protocol.BeforeQueryProtocol;
import com.softart.dfe.interfaces.process.nf.query_register.AfterQueryRegister;
import com.softart.dfe.interfaces.process.nf.query_register.BeforeQueryRegister;
import com.softart.dfe.interfaces.process.nf.query_status_service.AfterQueryStatusService;
import com.softart.dfe.interfaces.process.nf.query_status_service.BeforeQueryStatusService;
import com.softart.dfe.interfaces.process.nf.return_authorization.AfterReturnAuthorization;
import com.softart.dfe.interfaces.process.nf.return_authorization.BeforeReturnAuthorization;
import com.softart.dfe.interfaces.process.nf.substitute_cancel.AfterSubstituteCancel;
import com.softart.dfe.interfaces.process.nf.substitute_cancel.BeforeSubstituteCancel;

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
     * Returns a collection of all the AfterCancel objects in the current process.
     *
     * @return A collection of AfterCancel objects.
     */
    Collection<AfterCancel> afterCancel();

    /**
     * Returns a collection of all the BeforeCancel objects in the current object.
     *
     * @return A collection of BeforeCancel objects.
     */
    Collection<BeforeCancel> beforeCancel();

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
     * > Returns a collection of all the BeforeReturnAuthorization objects that have been registered with the current
     * instance of the AuthorizationManager
     *
     * @return A collection of BeforeReturnAuthorization objects.
     */
    Collection<BeforeReturnAuthorization> beforeReturnAuthorization();

    /**
     * > Returns a collection of all the `AfterQueryProtocol`s that have been registered with the `QueryManager`
     *
     * @return A collection of AfterQueryProtocol objects.
     */
    Collection<AfterQueryProtocol> afterQueryProtocol();

    /**
     * > This function returns a collection of all the BeforeQueryProtocol objects that are registered with the
     * QueryManager.
     *
     * @return A collection of BeforeQueryProtocol objects.
     */
    Collection<BeforeQueryProtocol> beforeQueryProtocol();

    /**
     * > This function returns a collection of services that are called after the query status is set
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
     * > Returns a collection of all the after distributions for this distribution
     *
     * @return A collection of AfterDistribution objects.
     */
    Collection<AfterDistribution> afterDistribution();

    /**
     * > Returns a collection of all the BeforeDistribution objects in the current distribution
     *
     * @return A collection of BeforeDistribution objects.
     */
    Collection<BeforeDistribution> beforeDistribution();

    /**
     * Returns a collection of all the AfterManifestation objects in the model.
     *
     * @return A collection of AfterManifestation objects.
     */
    Collection<AfterManifestation> afterManifestation();

    /**
     * Returns a collection of all the BeforeManifestation objects in the model.
     *
     * @return A collection of BeforeManifestation objects.
     */
    Collection<BeforeManifestation> beforeManifestation();

    /**
     * It returns a collection of AfterCorrectionLetter objects.
     *
     * @return A collection of AfterCorrectionLetter objects.
     */
    Collection<AfterCorrectionLetter> afterCorrectionLetter();

    /**
     * Returns a collection of all the BeforeCorrectionLetter objects in the database.
     *
     * @return A collection of BeforeCorrectionLetter objects.
     */
    Collection<BeforeCorrectionLetter> beforeCorrectionLetter();

    /**
     * It returns a collection of AfterEpec objects.
     *
     * @return A collection of AfterEpec objects.
     */
    Collection<AfterEpec> afterEpec();

    /**
     * Returns a collection of all the BeforeEpec objects in the database.
     *
     * @return A collection of BeforeEpec objects.
     */
    Collection<BeforeEpec> beforeEpec();

    /**
     * Returns a collection of all the actors interested in the after event
     *
     * @return A collection of AfterInterestedActor objects.
     */
    Collection<AfterInterestedActor> afterInterestedActor();

    /**
     * Returns a collection of all the actors interested in the before event
     *
     * @return A collection of BeforeInterestedActor objects.
     */
    Collection<BeforeInterestedActor> beforeInterestedActor();

    /**
     * It returns a collection of AfterQueryGtin objects.
     *
     * @return A collection of AfterQueryGtin objects.
     */
    Collection<AfterQueryGtin> afterQueryGtin();

    /**
     * > This function returns a collection of BeforeQueryGtin objects
     *
     * @return A collection of BeforeQueryGtin objects.
     */
    Collection<BeforeQueryGtin> beforeQueryGtin();

    /**
     * Returns a collection of all the AfterSubstituteCancel objects in the current document.
     *
     * @return A collection of AfterSubstituteCancel objects.
     */
    Collection<AfterSubstituteCancel> afterSubstituteCancel();

    /**
     * Returns a collection of all the BeforeSubstituteCancel objects in the current document
     *
     * @return A collection of BeforeSubstituteCancel objects.
     */
    Collection<BeforeSubstituteCancel> beforeSubstituteCancel();

    /**
     * > This function is called after the query is executed and the results are returned
     *
     * @return A collection of AfterQueryRegister objects.
     */
    Collection<AfterQueryRegister> afterQueryRegister();

    /**
     * > This function is called before the query is executed
     *
     * @return A collection of BeforeQueryRegister objects.
     */
    Collection<BeforeQueryRegister> beforeQueryRegister();
}
