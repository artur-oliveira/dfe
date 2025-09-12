package org.dfe.components.validation.nf;

import org.dfe.interfaces.validation.nf.NfeDistributionValidator;
import org.dfe.interfaces.validation.nf.NfeQueryRegisterValidator;
import org.dfe.interfaces.validation.nf.NfeValidator;

import java.util.Collection;
import java.util.Collections;

public final class DefaulNfeValidator extends DefaultNfCommonValidator implements NfeValidator {

    private final Collection<NfeDistributionValidator> distributionValidators = Collections.singleton(new XSDDistributionValidator());
    private final Collection<NfeQueryRegisterValidator> queryRegistersValidators = Collections.singleton(new XSDQueryRegisterValidator());

    @Override
    public Collection<NfeDistributionValidator> distributionValidators() {
        return distributionValidators;
    }

    @Override
    public Collection<NfeQueryRegisterValidator> queryRegisterValidators() {
        return queryRegistersValidators;
    }
}
