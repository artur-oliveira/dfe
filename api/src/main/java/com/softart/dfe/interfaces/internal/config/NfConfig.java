package com.softart.dfe.interfaces.internal.config;

import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.nf.NFSend;
import com.softart.dfe.enums.nf.identification.NFEmissionType;

/**
 * The `public interface NfConfig` is defining a new interface called `NfConfig` that extends the `Config` interface. This
 * means that `NfConfig` inherits all the methods and properties of the `Config` interface and can also define its own
 * methods and properties. This interface is used to define the configuration settings for a NF (Nota Fiscal) system.
 */
public interface NfConfig extends Config {

    /**
     * Returns the emission type of the node
     *
     * @return The emission type of the vehicle.
     */
    NFEmissionType emission();

    /**
     * It returns a new NFSend object.
     *
     * @return A reference to the object itself.
     */
    NFSend send();

    /**
     * Sets the environment to be used
     *
     * @param environment Environment where the request will be sent.
     * @return The same object, but with the environment set.
     */
    @Override
    NfConfig withEnviroment(Environment environment);

    /**
     * This function returns a new MdfeConfig object with the environment set to the value of the tpAmb parameter.
     *
     * @param tpAmb The environment in which the MDFe will be sent.
     * @return A new instance of MdfeConfig with the environment set to the value of the parameter tpAmb.
     */
    @Override
    default NfConfig withEnviroment(String tpAmb) {
        return withEnviroment(Environment.valueOfCode(tpAmb));
    }

}
