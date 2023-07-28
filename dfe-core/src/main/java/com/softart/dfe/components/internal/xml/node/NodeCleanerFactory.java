package com.softart.dfe.components.internal.xml.node;

import com.softart.dfe.interfaces.xml.XMLNodeCleaner;

public abstract class NodeCleanerFactory implements XMLNodeCleaner {

    public static NodeCleanerFactory getInstance() {
        return NameSpaceCleanerFactoryHolder.INSTANCE;
    }

    static final class NameSpaceCleanerFactoryHolder {
        static final NodeCleanerFactory INSTANCE = new DefaultNodeCleaner();
    }

}
