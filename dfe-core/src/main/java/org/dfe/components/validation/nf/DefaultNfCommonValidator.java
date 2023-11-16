package org.dfe.components.validation.nf;

import org.dfe.interfaces.validation.nf.common.*;

import java.util.Collection;
import java.util.Collections;

public abstract class DefaultNfCommonValidator implements NfCommonValidator {

    private final Collection<NfInutValidator> inutValidators = Collections.singleton(new XSDInutValidator());
    private final Collection<NfCancelValidator> cancelValidators = Collections.singleton(new XSDCancelValidator());
    private final Collection<NfAuthorizationValidator> authorizationValidators = Collections.singleton(new XSDAuthorizationValidator());
    private final Collection<NfReturnAuthorizationValidator> returnAuthorizationValidators = Collections.singleton(new XSDReturnAuthorizationValidator());
    private final Collection<NfQueryProtocolValidator> queryProtocolValidators = Collections.singleton(new XSDQueryProtocolValidator());
    private final Collection<NfQueryStatusServiceValidator> queryStatusServiceValidators = Collections.singleton(new XSDQueryStatusServiceValidator());
    private final Collection<NfQueryGtinValidator> gtinValidators = Collections.singleton(new XSDGtinValidator());

    @Override
    public Collection<NfInutValidator> inutValidators() {
        return inutValidators;
    }

    @Override
    public Collection<NfCancelValidator> cancelValidators() {
        return cancelValidators;
    }

    @Override
    public Collection<NfAuthorizationValidator> authorizationValidators() {
        return authorizationValidators;
    }

    @Override
    public Collection<NfReturnAuthorizationValidator> returnAuthorizationValidators() {
        return returnAuthorizationValidators;
    }

    @Override
    public Collection<NfQueryProtocolValidator> queryProtocolValidators() {
        return queryProtocolValidators;
    }

    @Override
    public Collection<NfQueryStatusServiceValidator> queryStatusServiceValidators() {
        return queryStatusServiceValidators;
    }

    @Override
    public Collection<NfQueryGtinValidator> queryGtinValidators() {
        return gtinValidators;
    }
}
