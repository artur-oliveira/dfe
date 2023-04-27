package com.softart.dfe.interfaces.internal.config;

import com.softart.dfe.enums.cte.identification.CteEmissionType;
import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.UF;

public interface CteConfig extends Config {
    /**
     * It returns the emission type of the CTE.
     *
     * @return The emission type of the CTE.
     */
    CteEmissionType emission();

    CteConfig withEmissionType(CteEmissionType emissionType);

    default CteConfig withEmissionType(String emissionType) {
        return withEmissionType(CteEmissionType.valueOfCode(emissionType));
    }

    /**
     * Sets the UF of the web service
     *
     * @param uf The UF of the web service to be used.
     * @return The same object, but with the UF set.
     */
    @Override
    CteConfig withWebServiceUf(UF uf);

    /**
     * If the user passes a String, we'll convert it to a UF enum value.
     *
     * @param uf The UF of the state where the CTe will be issued.
     * @return A new instance of CteConfig with the new value of webServiceUf.
     */
    @Override
    default CteConfig withWebServiceUf(String uf) {
        return withWebServiceUf(UF.valueOfCode(uf));
    }

    /**
     * Sets the environment to be used
     *
     * @param environment Environment where the request will be sent.
     * @return The same object, but with the environment set.
     */
    @Override
    CteConfig withEnviroment(Environment environment);

    /**
     * This function returns a new MdfeConfig object with the environment set to the value of the tpAmb parameter.
     *
     * @param tpAmb The environment in which the MDFe will be sent.
     * @return A new instance of MdfeConfig with the environment set to the value of the parameter tpAmb.
     */
    @Override
    default CteConfig withEnviroment(String tpAmb) {
        return withEnviroment(Environment.valueOfCode(tpAmb));
    }
}
