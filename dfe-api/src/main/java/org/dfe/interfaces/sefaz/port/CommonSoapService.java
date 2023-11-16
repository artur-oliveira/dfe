package org.dfe.interfaces.sefaz.port;

import org.dfe.interfaces.internal.config.Config;

/**
 * The code is defining a public interface named `CommonSoapService`. An interface is a collection of abstract methods that
 * can be implemented by any class. In this case, any class that implements the `CommonSoapService` interface must provide
 * implementations for the `isInitialized()` and `getConfig()` methods.
 */
public interface CommonSoapService {
    /**
     * Returns true if the object has been initialized.
     *
     * @return A boolean value.
     */
    boolean isInitialized();

    /**
     * Get the config object.
     *
     * @return The config object.
     */
    Config getConfig();
}
