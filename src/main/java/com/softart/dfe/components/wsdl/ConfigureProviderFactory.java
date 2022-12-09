package com.softart.dfe.components.wsdl;

import com.softart.dfe.interfaces.wsdl.ConfigureProvider;

public abstract class ConfigureProviderFactory implements ConfigureProvider {

    public static ConfigureProviderFactory getInstance() {
        return ConfigureProviderFactoryHolder.INSTANCE;
    }

    private static class ConfigureProviderFactoryHolder {
        final static ConfigureProviderFactory INSTANCE = new DefaultConfigureProviderFactory();
    }

}
