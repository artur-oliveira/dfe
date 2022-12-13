package com.softart.dfe.interfaces.internal.config;

import com.softart.dfe.enums.mdfe.identification.MdfeEmissionType;

public interface MdfeConfig extends Config {

    /**
     * It returns the emission type of the MDF-e.
     *
     * @return The emission type of the MDF-e.
     */
    MdfeEmissionType emission();

}
