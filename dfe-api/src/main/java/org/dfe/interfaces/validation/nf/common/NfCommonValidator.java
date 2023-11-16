package org.dfe.interfaces.validation.nf.common;

import java.util.Collection;

public interface NfCommonValidator {

    /**
     * It returns a collection of validators that will be used to validate the NF-e Inut XML
     *
     * @return A collection of NfInutValidator objects.
     */
    Collection<NfInutValidator> inutValidators();

    /**
     * Returns a collection of validators that will be used to validate the cancellation of a notification
     *
     * @return A collection of NfCancelValidator objects.
     */
    Collection<NfCancelValidator> cancelValidators();

    /**
     * This function returns a collection of authorization validators that will be used to validate the authorization of
     * the user
     *
     * @return A collection of authorization validators.
     */
    Collection<NfAuthorizationValidator> authorizationValidators();

    /**
     * Returns a collection of validators that will be used to validate the return authorization
     *
     * @return A collection of NfReturnAuthorizationValidator objects.
     */
    Collection<NfReturnAuthorizationValidator> returnAuthorizationValidators();

    /**
     * Returns a collection of validators that will be used to validate the query protocol
     *
     * @return A collection of NfQueryProtocolValidator objects.
     */
    Collection<NfQueryProtocolValidator> queryProtocolValidators();

    /**
     * This function returns a collection of validators that will be used to validate the query status service
     *
     * @return A collection of NfQueryStatusServiceValidator objects.
     */
    Collection<NfQueryStatusServiceValidator> queryStatusServiceValidators();

    /**
     * Returns a collection of all the query GTIN validators
     *
     * @return A collection of NfQueryGtinValidator objects.
     */
    Collection<NfQueryGtinValidator> queryGtinValidators();

}
