package org.dfe.components.internal.xml.objectfactory;

import org.dfe.interfaces.xml.objectfactory.NfObjectFactoryWrapper;

public abstract class NfObjectFactoryWrapperFactory implements NfObjectFactoryWrapper {

    public static NfObjectFactoryWrapperFactory getInstance() {
        return NfContextFactoryHolder.INSTANCE;
    }

    final static class NfContextFactoryHolder {
        final static NfObjectFactoryWrapperFactory INSTANCE = new DefaultNfObjectFactoryWrapper();
    }

}
