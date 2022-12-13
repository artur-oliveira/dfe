package com.softart.dfe.interfaces.validation.nf;

import com.softart.dfe.interfaces.validation.nf.common.NfCommonValidator;

import java.util.Collection;

public interface NfceValidator extends NfCommonValidator {

    /**
     * It returns a collection of validators that will be used to validate the NFC-e substitute cancellation
     *
     * @return A collection of NfceSubstituteCancelValidator objects.
     */
    Collection<NfceSubstituteCancelValidator> substituteCancelValidators();

}
