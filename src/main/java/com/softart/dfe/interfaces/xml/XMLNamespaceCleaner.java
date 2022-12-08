package com.softart.dfe.interfaces.xml;

import org.w3c.dom.Node;

public interface XMLNamespaceCleaner {

    /**
     * It removes all the namespace elements from the given node.
     *
     * @param node The node to clean.
     */
    void clean(Node node);
}
