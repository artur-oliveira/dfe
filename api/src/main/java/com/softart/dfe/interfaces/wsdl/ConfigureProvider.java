package com.softart.dfe.interfaces.wsdl;

import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.interfaces.internal.config.Config;
import com.softart.dfe.models.internal.wsdl.ProviderConfig;
import jakarta.xml.ws.BindingProvider;

/**
 * Declaring a Java interface named `ConfigureProvider`. This interface defines a method `configure` that takes a
 * `ProviderConfig` object as a parameter and throws a `SecurityException`. It also has a deprecated method `configure`
 * that takes a `BindingProvider` and a `Config` object as parameters and throws a `SecurityException`. This interface can
 * be implemented by classes that need to configure a provider with specific configuration parameters.
 */
public interface ConfigureProvider {

    /**
     * This is a deprecated method in the `ConfigureProvider` interface that takes a `BindingProvider` object and a
     * `Config` object as parameters and configures the provider with the specified configuration. It throws a
     * `SecurityException` if there is a security issue. This method is deprecated, which means it is no longer recommended
     * to use it and may be removed in future versions.
     *
     * @throws SecurityException SecurityException
     */
    @Deprecated
    default void configure(BindingProvider port, Config config) throws SecurityException {
        configure(ProviderConfig.builder().config(config).port(port).build());
    }

    /**
     * Configures the provider with the specified configuration
     *
     * @param config The configuration object that contains the configuration parameters for the provider.
     * @throws SecurityException SecurityException
     */
    void configure(ProviderConfig config) throws SecurityException;
}
