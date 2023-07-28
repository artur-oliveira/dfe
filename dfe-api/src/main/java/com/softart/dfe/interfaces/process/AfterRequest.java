package com.softart.dfe.interfaces.process;

import com.softart.dfe.interfaces.internal.config.Config;
import com.softart.dfe.interfaces.xml.generic.XML;

/**
 * This is a Java interface declaration for a generic type `AfterRequest` that has two type parameters `REQ` and `RES`,
 * both of which extend the `XML` class. The interface defines three methods: `getRequest()`, `getResponse()`, and
 * `getConfig()`, which return objects of type `REQ`, `RES`, and `Config`, respectively. This interface is likely used to
 * define a contract for classes that handle requests and responses in a system that uses XML.
 */
public interface AfterRequest<REQ extends XML, RES extends XML> {

    /**
     * It returns a request object.
     *
     * @return The request object.
     */
    REQ request();

    /**
     * Get the response from the server.
     *
     * @return The response from the server.
     */
    RES response();

    /**
     * Get the config object.
     *
     * @return The config object.
     */
    Config config();

}
