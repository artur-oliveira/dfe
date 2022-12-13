package com.softart.dfe.interfaces.internal.config;

import com.softart.dfe.enums.nf.NFSend;
import com.softart.dfe.enums.nf.identification.NFEmissionType;

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
}
