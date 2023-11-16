package org.dfe.interfaces.services;

import org.dfe.interfaces.internal.config.CteConfig;
import org.dfe.interfaces.process.cte4.Cte4ProcessService;

/**
 * This line of code is defining a Java interface named `CteSefazService` that extends another interface named
 * `SefazService`. This means that `CteSefazService` inherits all the methods and properties of `SefazService` in addition
 * to any methods and properties defined within `CteSefazService`.
 */
public interface Cte4SefazService extends SefazService {

    /**
     * This function returns a CteConfig object that contains the configuration information for the CTE
     *
     * @return The CteConfig object.
     */
    CteConfig getConfig();

    /**
     * Returns the process service
     *
     * @return The process service.
     */
    Cte4ProcessService getProcess();

}
