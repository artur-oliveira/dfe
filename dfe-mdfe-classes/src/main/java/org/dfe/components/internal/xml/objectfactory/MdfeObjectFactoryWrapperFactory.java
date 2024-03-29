package org.dfe.components.internal.xml.objectfactory;

import org.dfe.interfaces.xml.objectfactory.MdfeObjectFactoryWrapper;

public abstract class MdfeObjectFactoryWrapperFactory implements MdfeObjectFactoryWrapper {
    public static MdfeObjectFactoryWrapperFactory getInstance() {
        return Holder.INSTANCE;
    }

    private final static class Holder {
        private static final MdfeObjectFactoryWrapperFactory INSTANCE = new DefaultMdfeObjectFactoryWrapper();
    }
}
