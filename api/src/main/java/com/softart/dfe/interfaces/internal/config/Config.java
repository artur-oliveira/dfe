package com.softart.dfe.interfaces.internal.config;

import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.interfaces.internal.KeyStoreInfo;

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

}
