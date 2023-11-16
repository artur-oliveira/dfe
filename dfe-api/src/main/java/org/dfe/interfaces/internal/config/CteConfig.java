package org.dfe.interfaces.internal.config;

import org.dfe.enums.cte.identification.CteEmissionType;
import org.dfe.enums.internal.Environment;
import org.dfe.enums.internal.UF;

/**
 * The `public interface CteConfig` is defining a new interface called `CteConfig` that extends the `Config` interface.
 * This means that `CteConfig` inherits all the methods and properties of the `Config` interface, and can also define its
 * own methods and properties. This interface is likely used to define a configuration object for a specific type of
 * document or process related to the Brazilian electronic invoicing system.
 */
public interface CteConfig extends Config {
    /**
     * It returns the emission type of the CTE.
     *
     * @return The emission type of the CTE.
     */
    CteEmissionType emission();

    /**
     * The function `withEmissionType` sets the emission type for a CteConfig object.
     *
     * @param emissionType emissionType is a parameter of type CteEmissionType which is used to specify the type of
     *                     emission for a CteConfig object. CteEmissionType is an enumeration that defines the possible emission types, such as
     *                     "JSON", "XML", "CSV", etc. By passing an
     * @return The method `withEmissionType` is likely returning an instance of the `CteConfig` class with the specified
     * `emissionType` set. However, without more context or the implementation of the method, it is difficult to provide a
     * more specific answer.
     */
    CteConfig withEmissionType(CteEmissionType emissionType);

    /**
     * This Java function returns a CteConfig object with a specified CteEmissionType value.
     *
     * @param emissionType The parameter "emissionType" is a String that represents the type of emission for a CteConfig
     *                     object. It is used as input for the method "withEmissionType" to set the emission type of the CteConfig object.
     * @return The method `withEmissionType` is returning an instance of `CteConfig` with the `emissionType` set to the
     * value of the `CteEmissionType` enum corresponding to the given `emissionType` code.
     */
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
