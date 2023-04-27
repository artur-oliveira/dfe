package com.softart.dfe.interfaces.process;

import com.softart.dfe.interfaces.internal.config.Config;
import com.softart.dfe.interfaces.xml.generic.XML;

public interface BeforeRequest<REQ extends XML> {

    /**
     * It returns a request object.
     *
     * @return The request object.
     */
    REQ getRequest();

    /**
     * Get the config object.
     *
     * @return The config object.
     */
    Config getConfig();

}
