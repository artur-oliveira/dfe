package com.softart.dfe.components.validation.nf;

import com.softart.dfe.interfaces.validation.nf.*;

import java.util.Collection;
import java.util.Collections;

public final class DefaulNfeValidator extends DefaultNfCommonValidator implements NfeValidator {

    private final Collection<NfeDistributionValidator> distributionValidators = Collections.singleton(new XSDDistributionValidator());
    private final Collection<NfeManifestationValidator> manifestationValidators = Collections.singleton(new XSDManifestationValidator());
    private final Collection<NfeCorrectionLetterValidator> correctionLetterValidators = Collections.singleton(new XSDCorrectionLetterValidator());
    private final Collection<NfeEpecValidator> epecValidators = Collections.singleton(new XSDEpecValidator());
    private final Collection<NfeInterestedActorValidator> interestedActorValidators = Collections.singleton(new XSDInterestedActorValidator());
    private final Collection<NfeQueryRegisterValidator> queryRegistersValidators = Collections.singleton(new XSDQueryRegisterValidator());

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

    @Override
    public Collection<NfeQueryRegisterValidator> queryRegisterValidators() {
        return queryRegistersValidators;
    }
}
