package org.dfe.interfaces.security;

import org.dfe.exceptions.security.SSLContextException;
import org.dfe.interfaces.internal.config.Config;

import javax.net.ssl.SSLContext;

/**
 * This is declaring a public interface named `SocketFactoryService`. An interface is a collection of abstract methods that
 * define a contract for implementing classes. In this case, the interface defines a method `context` that takes a `Config`
 * object as a parameter and returns an `SSLContext` object. Any class that implements this interface must provide an
 * implementation for the `context` method.
 */
public interface SocketFactoryService {
    /**
     * Creates an SSLContext from the given configuration
     *
     * @param config The configuration object that contains the configuration for the SSLContext.
     * @return An SSLContext object.
     * @throws SSLContextException SSLContextException
     */
    SSLContext context(Config config) throws SSLContextException;
}
