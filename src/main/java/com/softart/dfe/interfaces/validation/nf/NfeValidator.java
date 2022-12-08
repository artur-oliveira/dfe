package com.softart.dfe.interfaces.validation.nf;

import com.softart.dfe.interfaces.validation.nf.common.NfCommonValidator;

import java.util.Collection;

public interface NfeValidator extends NfCommonValidator {

    Collection<NfeDistributionValidator> distributionValidators();

    Collection<NfeManifestationValidator> manifestationValidators();

    Collection<NfeCorrectionLetterValidator> correctionLetterValidators();

    Collection<NfeEpecValidator> epecValidators();

    Collection<NfeInterestedActorValidator> interestedActorValidators();

}
