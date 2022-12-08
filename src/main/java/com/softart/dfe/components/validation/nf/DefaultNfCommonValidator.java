package com.softart.dfe.components.validation.nf;

import com.softart.dfe.interfaces.validation.nf.common.*;

import java.util.Collection;
import java.util.Collections;

public abstract class DefaultNfCommonValidator implements NfCommonValidator {

    private final static Collection<NfInutValidator> inutValidators = Collections.singleton(new XSDInutValidator());
    private final static Collection<NfCancelValidator> cancelValidators = Collections.singleton(new XSDCancelValidator());
    private final static Collection<NfAuthorizationValidator> authorizationValidators = Collections.singleton(new XSDAuthorizationValidator());
    private final static Collection<NfReturnAuthorizationValidator> returnAuthorizationValidators = Collections.singleton(new XSDReturnAuthorizationValidator());
    private final static Collection<NfQueryProtocolValidator> queryProtocolValidators = Collections.singleton(new XSDQueryProtocolValidator());
    private final static Collection<NfQueryStatusServiceValidator> queryStatusServiceValidators = Collections.singleton(new XSDQueryStatusServiceValidator());
    private final static Collection<NfQueryGtinValidator> gtinValidators = Collections.singleton(new XSDGtinValidator());

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
