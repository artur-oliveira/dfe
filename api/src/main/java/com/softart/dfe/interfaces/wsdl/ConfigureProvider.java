package com.softart.dfe.interfaces.wsdl;

import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.interfaces.internal.config.Config;
import com.softart.dfe.models.internal.wsdl.ProviderConfig;

import javax.xml.ws.BindingProvider;

public interface ConfigureProvider {

    @Deprecated
    default void configure(BindingProvider port, Config config) throws SecurityException {
        configure(ProviderConfig.builder().config(config).port(port).build());
    }

    /**
     * Configures the provider with the specified configuration
     *
     * @param config The configuration object that contains the configuration parameters for the provider.
     */
    void configure(ProviderConfig config) throws SecurityException;
}
