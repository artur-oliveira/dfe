package org.dfe.interfaces.internal.config;

import org.dfe.enums.internal.Environment;
import org.dfe.enums.internal.UF;
import org.dfe.interfaces.internal.KeyStoreInfo;

/**
 * Declaring a public interface named "Config". This interface defines a set of methods that must be implemented by any
 * class that implements this interface. The methods defined in this interface are related to configuration settings for a
 * specific application or system.
 */
public interface Config {

    /**
     * Create a new UF object.
     *
     * @return The UF object.
     */
    UF uf();

    /**
     * It returns the CNPJ of the company.
     *
     * @return A String
     */
    String cnpj();

    /**
     * Returns the CPF of the person.
     *
     * @return A String
     */
    String cpf();

    /**
     * Returns the environment in which the current thread is running.
     *
     * @return The environment object.
     */
    Environment environment();

    /**
     * If the environment is production, return true, otherwise return false.
     *
     * @return The environment.
     */
    default boolean production() {
        return environment().production();
    }

    /**
     * Returns the keystore information
     *
     * @return The KeyStoreInfo object.
     */
    KeyStoreInfo info();

    /**
     * It returns a UF object.
     *
     * @return A web service object.
     */
    UF webServiceUF();

    /**
     * Configure the web service to use the given UF.
     *
     * @param uf The UF of the state where the webservice is located.
     * @return A new instance of the class.
     */
    Config withWebServiceUf(UF uf);

    /**
     * If the user passes a String, we'll convert it to a UF enum value.
     *
     * @param uf The UF of the state where the CTe will be issued.
     * @return A new instance of CteConfig with the new value of webServiceUf.
     */
    default Config withWebServiceUf(String uf) {
        return withWebServiceUf(UF.valueOfCode(uf));
    }


    /**
     * Sets the environment to be used
     *
     * @param environment Environment where the request will be sent.
     * @return The same object, but with the environment set.
     */
    Config withEnviroment(Environment environment);

    /**
     * This function returns a new MdfeConfig object with the environment set to the value of the tpAmb parameter.
     *
     * @param tpAmb The environment in which the MDFe will be sent.
     * @return A new instance of MdfeConfig with the environment set to the value of the parameter tpAmb.
     */
    default Config withEnviroment(String tpAmb) {
        return withEnviroment(Environment.valueOfCode(tpAmb));
    }


}
