package com.softart.dfe.interfaces.validation.nf;

import com.softart.dfe.interfaces.validation.nf.common.NfCommonValidator;

import java.util.Collection;

public interface NfeValidator extends NfCommonValidator {

    /**
     * > Returns a collection of validators that will be used to validate the distribution of the NFE
     *
     * @return A collection of NfeDistributionValidator objects.
     */
    Collection<NfeDistributionValidator> distributionValidators();

    /**
     * Returns a collection of NfeManifestationValidator objects
     *
     * @return A collection of NfeManifestationValidator objects.
     */
    Collection<NfeManifestationValidator> manifestationValidators();

    /**
     * Returns a collection of correction letter validators
     *
     * @return A collection of NfeCorrectionLetterValidator objects.
     */
    Collection<NfeCorrectionLetterValidator> correctionLetterValidators();

    /**
     * "Return a collection of all the NfeEpecValidator instances that are available in the application context."
     * <p>
     * The `@Bean` annotation tells Spring that this method will return an object that should be registered as a bean in
     * the Spring application context. The `@Autowired` annotation tells Spring to inject all beans of type
     * `NfeEpecValidator` into the method parameter
     *
     * @return A collection of NfeEpecValidator objects.
     */
    Collection<NfeEpecValidator> epecValidators();

    /**
     * Return a collection of validators that will be used to validate the interested actor.
     *
     * @return A collection of NfeInterestedActorValidator objects.
     */
    Collection<NfeInterestedActorValidator> interestedActorValidators();

    Collection<NfeQueryRegisterValidator> queryRegisterValidators();

}
