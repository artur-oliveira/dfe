package com.softart.dfe.interfaces.internal.allow;

import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.UF;

import java.util.Collection;
import java.util.Objects;

public interface AllowUF {

    /**
     * Returns a collection of UFs that are allowed to be used in production.
     *
     * @return A collection of UF objects.
     */
    Collection<UF> allowedUfsProduction();

    /**
     * It returns a collection of UF objects that are allowed to be used in the homologation environment
     *
     * @return A collection of UF objects.
     */
    Collection<UF> allowedUfsHomologation();

    /**
     * If the environment is production, return true if the UF is in the list of allowed UFs for production, otherwise
     * return true if the UF is in the list of allowed UFs for homologation.
     *
     * @param uf          The UF of the user's address.
     * @param environment The environment in which the application is running.
     * @return A boolean value.
     */
    default boolean allow(UF uf, Environment environment) {
        return Objects.equals(environment, Environment.PRODUCTION) ? allowedUfsProduction().contains(uf) : allowedUfsHomologation().contains(uf);
    }
}
