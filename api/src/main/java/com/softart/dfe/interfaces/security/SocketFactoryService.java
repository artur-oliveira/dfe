package com.softart.dfe.interfaces.security;

import com.softart.dfe.exceptions.security.SSLContextException;
import com.softart.dfe.interfaces.internal.config.Config;

import javax.net.ssl.SSLContext;

public interface SocketFactoryService {
    /**
     * Creates an SSLContext from the given configuration
     *
     * @param config The configuration object that contains the configuration for the SSLContext.
     * @return An SSLContext object.
     */
    SSLContext context(Config config) throws SSLContextException;
}
