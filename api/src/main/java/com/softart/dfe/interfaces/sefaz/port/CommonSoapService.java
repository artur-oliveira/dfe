package com.softart.dfe.interfaces.sefaz.port;

import com.softart.dfe.interfaces.internal.config.Config;

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
