package com.softart.dfe.interfaces.internal.allow;

import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.enums.nf.identification.NFEmissionType;

public interface NfServiceAllow extends AllowUF {

    /**
     * The function returns true if the given emission type is allowed in the given environment, false otherwise
     *
     * @param uf           The UF that is being checked.
     * @param environment  The environment that the emission is being emitted in.
     * @param emissionType The emission type of the NFEmission.
     * @return A boolean value.
     */
    boolean allow(UF uf, Environment environment, NFEmissionType emissionType);

}
