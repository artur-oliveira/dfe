package org.dfe.components.wsdl;

import org.dfe.interfaces.wsdl.ConfigureProvider;

public abstract class ConfigureProviderFactory implements ConfigureProvider {

    /**
     * The function returns a singleton instance of the ConfigureProviderFactory class
     *
     * @return The ConfigureProviderFactoryHolder.INSTANCE
     */
    public static ConfigureProviderFactory getInstance() {
        return ConfigureProviderFactoryHolder.INSTANCE;
    }

    private static class ConfigureProviderFactoryHolder {
        final static ConfigureProviderFactory INSTANCE = new DefaultConfigureProviderFactory();
    }

}
