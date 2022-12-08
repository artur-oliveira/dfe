package com.softart.dfe.interfaces.wsdl;

import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.interfaces.internal.config.Config;

import javax.xml.ws.BindingProvider;

public interface ConfigureProvider {

    void configure(BindingProvider port, Config config) throws SecurityException;

}
