package com.softart.dfe.interfaces.process;

import com.softart.dfe.interfaces.internal.config.Config;
import com.softart.dfe.interfaces.xml.generic.XML;

/**
 * This is a Java interface declaration with a generic type parameter `REQ` that extends the `XML` class/interface. The
 * interface is named `BeforeRequest` and it defines two methods: `request()` which returns an object of type `REQ`, and
 * `config()` which returns an object of type `Config`. The purpose of this interface is to define a contract for classes
 * that need to perform some action before making a request, and it provides a way to obtain the request object and the
 * configuration object. The specific implementation of the `request()` method will depend on the class that implements
 * this interface.
 */
public interface BeforeRequest<REQ extends XML> {

    /**
     * It returns a request object.
     *
     * @return The request object.
     */
    REQ request();

    /**
     * Get the config object.
     *
     * @return The config object.
     */
    Config config();

}
