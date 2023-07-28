package com.softart.dfe.interfaces.internal.config;

import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.UF;

/**
 * The code is defining a Java interface named `NfceConfig` that extends another interface named `NfConfig`. This means
 * that `NfceConfig` inherits all the methods and constants defined in `NfConfig`, and also adds its own methods and
 * constants. Any class that implements `NfceConfig` must provide implementations for all the methods defined in both
 * `NfceConfig` and `NfConfig`.
 */
public interface NfceConfig extends NfConfig {
    /**
     * Returns the CSC ID of the current user
     *
     * @return A string.
     */
    String cscId();

    /**
     * Returns the CSC of the current element.
     *
     * @return The return value is the value of the csc() function.
     */
    String csc();

    /**
     * Sets the UF of the web service
     *
     * @param uf The UF of the web service to be used.
     * @return The same object, but with the UF set.
     */
    @Override
    NfceConfig withWebServiceUf(UF uf);

    /**
     * If the user passes a String, we'll convert it to a UF enum value.
     *
     * @param uf The UF of the state where the CTe will be issued.
     * @return A new instance of CteConfig with the new value of webServiceUf.
     */
    @Override
    default NfceConfig withWebServiceUf(String uf) {
        return withWebServiceUf(UF.valueOfCode(uf));
    }

    /**
     * Sets the environment to be used
     *
     * @param environment Environment where the request will be sent.
     * @return The same object, but with the environment set.
     */
    @Override
    NfceConfig withEnviroment(Environment environment);

    /**
     * This function returns a new MdfeConfig object with the environment set to the value of the tpAmb parameter.
     *
     * @param tpAmb The environment in which the MDFe will be sent.
     * @return A new instance of MdfeConfig with the environment set to the value of the parameter tpAmb.
     */
    @Override
    default NfceConfig withEnviroment(String tpAmb) {
        return withEnviroment(Environment.valueOfCode(tpAmb));
    }
}
