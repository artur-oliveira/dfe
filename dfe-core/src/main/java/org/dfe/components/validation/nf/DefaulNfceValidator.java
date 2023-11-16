package org.dfe.components.validation.nf;

import org.dfe.interfaces.validation.nf.NfceSubstituteCancelValidator;
import org.dfe.interfaces.validation.nf.NfceValidator;

import java.util.Collection;
import java.util.Collections;

public final class DefaulNfceValidator extends DefaultNfCommonValidator implements NfceValidator {

    private final Collection<NfceSubstituteCancelValidator> substituteCancelValidators = Collections.singletonList(new XSDSubstituteCancelValidator());

    @Override
    public Collection<NfceSubstituteCancelValidator> substituteCancelValidators() {
        return substituteCancelValidators;
    }
}
