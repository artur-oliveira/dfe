package com.softart.dfe.interfaces.process;

import com.softart.dfe.interfaces.internal.config.Config;
import com.softart.dfe.interfaces.xml.generic.XML;

public interface AfterRequest<REQ extends XML, RES extends XML> {

    /**
     * It returns a request object.
     *
     * @return The request object.
     */
    REQ getRequest();

    /**
     * Get the response from the server.
     *
     * @return The response from the server.
     */
    RES getResponse();

    /**
     * Get the config object.
     *
     * @return The config object.
     */
    Config getConfig();

}
