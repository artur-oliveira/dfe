package com.softart.dfe.components.internal.xml.namespace;

import com.softart.dfe.interfaces.xml.XMLNamespaceCleaner;

public abstract class NameSpaceCleanerFactory implements XMLNamespaceCleaner {

    public static NameSpaceCleanerFactory getInstance() {
        return NameSpaceCleanerFactoryHolder.INSTANCE;
    }

    static final class NameSpaceCleanerFactoryHolder {
        static final NameSpaceCleanerFactory INSTANCE = new DefaultNamespaceCleaner();
    }

}
