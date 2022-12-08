package com.softart.dfe.components.validation.nf;

import com.softart.dfe.interfaces.validation.nf.*;

import java.util.Collection;
import java.util.Collections;

public final class DefaulNfeValidator extends DefaultNfCommonValidator implements NfeValidator {

    private final static Collection<NfeDistributionValidator> distributionValidators = Collections.singleton(new XSDDistributionValidator());
    private final static Collection<NfeManifestationValidator> manifestationValidators = Collections.singleton(new XSDManifestationValidator());
    private final static Collection<NfeCorrectionLetterValidator> correctionLetterValidators = Collections.singleton(new XSDCorrectionLetterValidator());
    private final static Collection<NfeEpecValidator> epecValidators = Collections.singleton(new XSDEpecValidator());
    private final static Collection<NfeInterestedActorValidator> interestedActorValidators = Collections.singleton(new XSDInterestedActorValidator());

    @Override
    public Collection<NfeDistributionValidator> distributionValidators() {
        return distributionValidators;
    }

    @Override
    public Collection<NfeManifestationValidator> manifestationValidators() {
        return manifestationValidators;
    }

    @Override
    public Collection<NfeCorrectionLetterValidator> correctionLetterValidators() {
        return correctionLetterValidators;
    }

    @Override
    public Collection<NfeEpecValidator> epecValidators() {
        return epecValidators;
    }

    @Override
    public Collection<NfeInterestedActorValidator> interestedActorValidators() {
        return interestedActorValidators;
    }
}
