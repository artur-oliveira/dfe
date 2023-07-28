package com.softart.dfe.interfaces.internal.config;

import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.UF;

/**
 * The code is defining a Java interface named `NfeConfig` that extends another interface named `NfConfig`. This means that
 * `NfeConfig` inherits all the methods and properties of `NfConfig`, and can also define its own methods and properties.
 */
public interface NfeConfig extends NfConfig {
    /**
     * Sets the UF of the web service
     *
     * @param uf The UF of the web service to be used.
     * @return The same object, but with the UF set.
     */
    @Override
    NfeConfig withWebServiceUf(UF uf);

    /**
     * If the user passes a String, we'll convert it to a UF enum value.
     *
     * @param uf The UF of the state where the CTe will be issued.
     * @return A new instance of CteConfig with the new value of webServiceUf.
     */
    @Override
    default NfeConfig withWebServiceUf(String uf) {
        return withWebServiceUf(UF.valueOfCode(uf));
    }

    /**
     * Sets the environment to be used
     *
     * @param environment Environment where the request will be sent.
     * @return The same object, but with the environment set.
     */
    @Override
    NfeConfig withEnviroment(Environment environment);

    /**
     * This function returns a new MdfeConfig object with the environment set to the value of the tpAmb parameter.
     *
     * @param tpAmb The environment in which the MDFe will be sent.
     * @return A new instance of MdfeConfig with the environment set to the value of the parameter tpAmb.
     */
    default NfeConfig withEnviroment(String tpAmb) {
        return withEnviroment(Environment.valueOfCode(tpAmb));
    }

}
