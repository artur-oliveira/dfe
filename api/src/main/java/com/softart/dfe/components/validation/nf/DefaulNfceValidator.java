package com.softart.dfe.components.validation.nf;

import com.softart.dfe.interfaces.validation.nf.NfceSubstituteCancelValidator;
import com.softart.dfe.interfaces.validation.nf.NfceValidator;

import java.util.Collection;
import java.util.Collections;

public final class DefaulNfceValidator extends DefaultNfCommonValidator implements NfceValidator {

    private final Collection<NfceSubstituteCancelValidator> substituteCancelValidators = Collections.singletonList(new XSDSubstituteCancelValidator());

    @Override
    public Collection<NfceSubstituteCancelValidator> substituteCancelValidators() {
        return substituteCancelValidators;
    }
}
