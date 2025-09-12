package org.dfe.interfaces.wsdl;

import org.dfe.exceptions.security.SecurityException;
import org.dfe.interfaces.internal.config.Config;
import org.dfe.models.internal.wsdl.ProviderConfig;
import jakarta.xml.ws.BindingProvider;

/**
 * Declaring a Java interface named `ConfigureProvider`. This interface defines a method `configure` that takes a
 * `ProviderConfig` object as a parameter and throws a `SecurityException`. It also has a deprecated method `configure`
 * that takes a `BindingProvider` and a `Config` object as parameters and throws a `SecurityException`. This interface can
 * be implemented by classes that need to configure a provider with specific configuration parameters.
 */
public interface ConfigureProvider {

    /**
     * Configures the provider with the specified configuration
     *
     * @param config The configuration object that contains the configuration parameters for the provider.
     * @throws SecurityException SecurityException
     */
    void configure(ProviderConfig config) throws SecurityException;
}
