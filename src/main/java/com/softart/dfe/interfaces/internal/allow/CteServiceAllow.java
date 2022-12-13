package com.softart.dfe.interfaces.internal.allow;

import com.softart.dfe.enums.cte.identification.CteEmissionType;
import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.UF;

public interface CteServiceAllow extends AllowUF {

    /**
     * Given a UF, an Environment, and an EmissionType, return true if the UF is allowed to emit the given EmissionType in
     * the given Environment.
     *
     * @param uf           The UF object that represents the state of the user.
     * @param environment  The environment that the emission is being emitted in.
     * @param emissionType The emission type that is being checked.
     * @return A boolean value.
     */
    boolean allow(UF uf, Environment environment, CteEmissionType emissionType);

}
