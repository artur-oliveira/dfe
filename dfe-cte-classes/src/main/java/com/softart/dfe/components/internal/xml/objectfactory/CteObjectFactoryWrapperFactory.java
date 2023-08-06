package com.softart.dfe.components.internal.xml.objectfactory;

import com.softart.dfe.interfaces.xml.objectfactory.CteObjectFactoryWrapper;

public abstract class CteObjectFactoryWrapperFactory implements CteObjectFactoryWrapper {

    public static CteObjectFactoryWrapperFactory getInstance() {
        return Holder.INSTANCE;
    }

    private final static class Holder {
        private static final CteObjectFactoryWrapperFactory INSTANCE = new DefaultCteObjectFactoryWrapper();
    }
}
