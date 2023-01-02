package com.softart.dfe.interfaces.internal.allow;

import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.enums.mdfe.identification.MdfeEmissionType;

public interface MdfeServiceAllow extends AllowUF {

    /**
     * "Given a UF, an Environment and an Emission Type, return true if the UF is allowed to emit MDF-e in the given
     * Environment and Emission Type."
     * <p>
     * The function is implemented in the following way:
     *
     * @param uf           The UF of the vehicle.
     * @param environment  Environment.PRODUCTION or Environment.HOMOLOGATION
     * @param emissionType The emission type of the MDF-e.
     * @return A boolean value.
     */
    boolean allow(UF uf, Environment environment, MdfeEmissionType emissionType);

}
