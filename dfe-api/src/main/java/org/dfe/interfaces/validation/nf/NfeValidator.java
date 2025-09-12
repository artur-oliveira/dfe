package org.dfe.interfaces.validation.nf;

import org.dfe.interfaces.validation.nf.common.NfCommonValidator;

import java.util.Collection;

/**
 * This line of code is defining a Java interface named `NfeValidator` that extends another interface named
 * `NfCommonValidator`. By extending `NfCommonValidator`, `NfeValidator` inherits all the methods and properties of
 * `NfCommonValidator`. This interface is used to define a set of methods that must be implemented by any class that wants
 * to be considered a validator for NFE (Nota Fiscal Eletrônica) in the context of the application. The methods defined in
 * this interface are used to validate different aspects of the NFE, such as distribution, manifestation, correction
 * letter, EPEC (Evento Prévio da Emissão em Contingência), interested actor, and query register.
 */
public interface NfeValidator extends NfCommonValidator {

    /**
     * Returns a collection of validators that will be used to validate the distribution of the NFE
     *
     * @return A collection of NfeDistributionValidator objects.
     */
    Collection<NfeDistributionValidator> distributionValidators();

    Collection<NfeQueryRegisterValidator> queryRegisterValidators();

}
