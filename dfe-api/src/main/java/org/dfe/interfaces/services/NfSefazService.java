package org.dfe.interfaces.services;

import org.dfe.interfaces.internal.config.NfConfig;
import org.dfe.interfaces.process.nf.NfProcessService;

/**
 * This line of code is creating a Java interface called `NfSefazService` that extends another interface called
 * `SefazService`. This means that `NfSefazService` inherits all the methods and properties of `SefazService`, and can also
 * define its own methods and properties.
 */
public interface NfSefazService extends SefazService {

    /**
     * Returns the current configuration of the NF
     *
     * @return The NfConfig object.
     */
    NfConfig getConfig();

    /**
     * Returns the process service.
     *
     * @return A reference to the process service.
     */
    NfProcessService getProcess();

}
