package com.softart.dfe.interfaces.services;

import com.softart.dfe.interfaces.internal.config.MdfeConfig;
import com.softart.dfe.interfaces.process.mdfe.MdfeProcessService;

/**
 * This code is defining a Java interface named `MdfeSefazService` that extends another interface named `SefazService`.
 * This means that `MdfeSefazService` inherits all the methods and constants defined in `SefazService`, and can also define
 * its own methods and constants. This interface declares two methods: `getConfig()` and `getProcess()`, which must be
 * implemented by any class that implements `MdfeSefazService`.
 */
public interface MdfeSefazService extends SefazService {

    /**
     * Returns the configuration object used by the MDF-e library
     *
     * @return The configuration object.
     */
    MdfeConfig getConfig();

    /**
     * Returns the process service
     *
     * @return The MdfeProcessService object.
     */
    MdfeProcessService getProcess();

}
