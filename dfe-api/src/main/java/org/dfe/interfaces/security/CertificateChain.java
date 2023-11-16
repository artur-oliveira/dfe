package org.dfe.interfaces.security;

import org.dfe.enums.internal.Environment;
import org.dfe.enums.internal.Model;
import org.dfe.enums.internal.UF;

/**
 * Declaring a public interface named `CertificateChain`. This interface defines a contract for classes that implement it
 * to provide methods for retrieving information related to a certificate chain, such as the environment, UF, model, and
 * file name.
 */
public interface CertificateChain {

    /**
     * Returns the environment that this object is in.
     *
     * @return The environment is being returned.
     */
    Environment environment();

    /**
     * It returns the UF of the current state.
     *
     * @return The UF object.
     */
    UF uf();

    /**
     * Returns the model that this view is associated with
     *
     * @return The model is being returned.
     */
    Model model();

    /**
     * Returns the name of the file.
     *
     * @return The file name of the file that is being read.
     */
    String fileName();

}
