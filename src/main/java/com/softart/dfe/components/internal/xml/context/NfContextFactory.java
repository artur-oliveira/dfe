package com.softart.dfe.components.internal.xml.context;

import com.softart.dfe.interfaces.xml.context.NfContext;

public abstract class NfContextFactory implements NfContext {

    public static NfContextFactory getInstance() {
        return NfContextFactoryHolder.INSTANCE;
    }

    final static class NfContextFactoryHolder {
        final static NfContextFactory INSTANCE = new DefaultNfContext();
    }

}
