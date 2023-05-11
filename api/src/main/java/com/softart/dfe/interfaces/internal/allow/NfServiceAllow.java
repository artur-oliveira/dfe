package com.softart.dfe.interfaces.internal.allow;

import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.enums.nf.identification.NFEmissionType;

/**
 * The `public interface NfServiceAllow` is declaring a Java interface named `NfServiceAllow`. The `extends AllowUF` part
 * is indicating that this interface is extending another interface named `AllowUF`. This means that `NfServiceAllow` will
 * inherit all the methods and constants declared in `AllowUF`.
 */
public interface NfServiceAllow extends AllowUF {


    /**
     * The function checks if a certain type of emission is allowed in a given environment based on a UF (Brazilian state)
     * object.
     *
     * @param uf           UF stands for "Unidade Federativa" which is a Brazilian term for "Federative Unit". It refers to the 27
     *                     states and one federal district that make up Brazil. In this context, the parameter "uf" is likely referring to the
     *                     specific state or federal district that the code is
     * @param environment  The `environment` parameter is an object that represents the environment in which the emission is
     *                     being made. It could contain information such as the location, time of day, weather conditions, and other relevant
     *                     factors that could affect the emission. The `allow` method likely uses this information to determine whether the
     *                     emission
     * @param emissionType NFEmissionType is an enum that represents the type of non-fossil fuel emission. It could be one
     *                     of the following values:
     * @return The method `allow` is returning a boolean value.
     */
    boolean allow(UF uf, Environment environment, NFEmissionType emissionType);

}
