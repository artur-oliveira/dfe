package com.softart.dfe.components.wsdl;

import com.softart.dfe.interfaces.wsdl.ConfigureProvider;

public abstract class ConfigureProviderFactory implements ConfigureProvider {

    public static ConfigureProviderFactory getInstance() {
        return new DefaultConfigureProviderFactory();
    }

}
