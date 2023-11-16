package org.dfe.interfaces.internal.config;

import org.dfe.enums.internal.Environment;
import org.dfe.enums.internal.UF;
import org.dfe.enums.mdfe.identification.MdfeEmissionType;

/**
 * The code is defining a Java interface named `MdfeConfig` that extends another interface named `Config`. This means that
 * `MdfeConfig` inherits all the methods and constants defined in `Config`, and also adds its own methods and constants.
 * This is a way to create a new interface that builds on top of an existing one, without having to redefine all the
 * methods and constants from scratch.
 */
public interface MdfeConfig extends Config {

    /**
     * It returns the emission type of the MDF-e.
     *
     * @return The emission type of the MDF-e.
     */
    MdfeEmissionType emission();

    /**
     * Sets the UF of the web service
     *
     * @param uf The UF of the web service to be used.
     * @return The same object, but with the UF set.
     */
    @Override
    MdfeConfig withWebServiceUf(UF uf);


    /**
     * Sets the environment to be used
     *
     * @param environment Environment where the request will be sent.
     * @return The same object, but with the environment set.
     */
    @Override
    MdfeConfig withEnviroment(Environment environment);

    /**
     * This function returns a new MdfeConfig object with the environment set to the value of the tpAmb parameter.
     *
     * @param tpAmb The environment in which the MDFe will be sent.
     * @return A new instance of MdfeConfig with the environment set to the value of the parameter tpAmb.
     */
    @Override
    default MdfeConfig withEnviroment(String tpAmb) {
        return withEnviroment(Environment.valueOfCode(tpAmb));
    }

}
