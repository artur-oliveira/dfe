package com.softart.dfe.interfaces.validation.nf;

import com.softart.dfe.interfaces.validation.nf.common.NfCommonValidator;

import java.util.Collection;

/**
 * This line of code is defining a Java interface named `NfceValidator` that extends the `NfCommonValidator` interface.
 * This means that `NfceValidator` inherits all the methods and constants defined in `NfCommonValidator`. Any class that
 * implements `NfceValidator` must implement all the methods defined in both `NfceValidator` and `NfCommonValidator`.
 */
public interface NfceValidator extends NfCommonValidator {

    /**
     * It returns a collection of validators that will be used to validate the NFC-e substitute cancellation
     *
     * @return A collection of NfceSubstituteCancelValidator objects.
     */
    Collection<NfceSubstituteCancelValidator> substituteCancelValidators();

}
