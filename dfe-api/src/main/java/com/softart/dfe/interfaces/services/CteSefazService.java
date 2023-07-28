package com.softart.dfe.interfaces.services;

import com.softart.dfe.interfaces.internal.config.CteConfig;
import com.softart.dfe.interfaces.process.cte.CteProcessService;

/**
 * This line of code is defining a Java interface named `CteSefazService` that extends another interface named
 * `SefazService`. This means that `CteSefazService` inherits all the methods and properties of `SefazService` in addition
 * to any methods and properties defined within `CteSefazService`.
 */
public interface CteSefazService extends SefazService {

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
    CteProcessService getProcess();

}
