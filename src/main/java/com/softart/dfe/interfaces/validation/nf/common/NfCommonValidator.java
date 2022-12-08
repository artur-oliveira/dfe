package com.softart.dfe.interfaces.validation.nf.common;

import java.util.Collection;

public interface NfCommonValidator {

    Collection<NfInutValidator> inutValidators();

    Collection<NfCancelValidator> cancelValidators();

    Collection<NfAuthorizationValidator> authorizationValidators();

    Collection<NfReturnAuthorizationValidator> returnAuthorizationValidators();

    Collection<NfQueryProtocolValidator> queryProtocolValidators();

    Collection<NfQueryStatusServiceValidator> queryStatusServiceValidators();

    Collection<NfQueryGtinValidator> queryGtinValidators();

}
