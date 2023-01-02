package com.softart.dfe.interfaces.internal.config;

import com.softart.dfe.enums.cte.identification.CteEmissionType;

public interface CteConfig extends Config {
    /**
     * It returns the emission type of the CTE.
     *
     * @return The emission type of the CTE.
     */
    CteEmissionType emission();

}
