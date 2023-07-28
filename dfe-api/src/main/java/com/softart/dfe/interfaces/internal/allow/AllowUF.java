package com.softart.dfe.interfaces.internal.allow;

import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.UF;

import java.util.Collection;
import java.util.Objects;

/**
 * The `public interface AllowUF {` is defining a Java interface named `AllowUF`. This interface contains three methods:
 * `allowedUfsProduction()`, `allowedUfsHomologation()`, and `allow(UF uf, Environment environment)`. The interface is
 * intended to be implemented by classes that need to check whether a given UF is allowed in a specific environment
 * (production or homologation).
 */
public interface AllowUF {

    /**
     * The function returns a collection of UF objects that are allowed for production.
     *
     * @return A collection of objects of type `UF` that represent the Brazilian states where production is allowed.
     */
    Collection<UF> allowedUfsProduction();


    /**
     * The function returns a collection of UF objects that are allowed for homologation.
     *
     * @return A collection of objects of type `UF` that represent the Brazilian states that are allowed for homologation.
     */
    Collection<UF> allowedUfsHomologation();


    /**
     * This function checks if a given UF is allowed in a specific environment (production or homologation).
     *
     * @param uf          "uf" is likely an abbreviation for "Unit of Federation", which refers to a state or federal district in
     *                    Brazil. It is used as a parameter in the method to determine whether a particular UF is allowed in a given
     *                    environment (production or homologation).
     * @param environment The `environment` parameter is an enum type `Environment` that represents the environment in
     *                    which the code is running. It can have two possible values: `PRODUCTION` or `HOMOLOGATION`.
     * @return A boolean value is being returned. The value depends on whether the given `uf` parameter is present in the
     * list of allowed UF's for the given `environment` parameter. If the `environment` is `PRODUCTION`, the method checks
     * if the `uf` is present in the list of allowed UF's for production environment, otherwise it checks if the `uf` is
     * present in the list of
     */
    default boolean allow(UF uf, Environment environment) {
        return Objects.equals(environment, Environment.PRODUCTION) ? allowedUfsProduction().contains(uf) : allowedUfsHomologation().contains(uf);
    }
}
