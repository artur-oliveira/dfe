package com.softart.dfe.interfaces.security;

import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.Model;
import com.softart.dfe.enums.internal.UF;

public interface CertificateChain {

    /**
     * Returns the environment that this object is in.
     *
     * @return The environment is being returned.
     */
    Environment getEnvironment();

    /**
     * It returns the UF of the current state.
     *
     * @return The UF object.
     */
    UF getUf();

    /**
     * Returns the model that this view is associated with
     *
     * @return The model is being returned.
     */
    Model getModel();

    /**
     * Returns the name of the file.
     *
     * @return The file name of the file that is being read.
     */
    String fileName();

}
