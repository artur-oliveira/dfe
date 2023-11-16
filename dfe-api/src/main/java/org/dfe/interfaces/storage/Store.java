package org.dfe.interfaces.storage;

import org.dfe.interfaces.internal.config.Config;
import org.dfe.interfaces.xml.generic.XML;

public interface Store<T extends XML> {

    /**
     * Get the config object.
     *
     * @return The config object.
     */
    Config config();

    /**
     * GetData() returns a value of type T.
     *
     * @return The data of the node.
     */
    T data();

    /**
     * It returns a String.
     *
     * @return The XML representation of the object.
     */
    String xml();

}
