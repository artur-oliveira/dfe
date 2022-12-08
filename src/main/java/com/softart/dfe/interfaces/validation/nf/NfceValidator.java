package com.softart.dfe.interfaces.validation.nf;

import com.softart.dfe.interfaces.validation.nf.common.NfCommonValidator;

import java.util.Collection;

public interface NfceValidator extends NfCommonValidator {

    Collection<NfceSubstituteCancelValidator> substituteCancelValidators();

}
