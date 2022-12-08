package com.softart.dfe.components.internal.xml.context;

import com.softart.dfe.interfaces.xml.CteContext;
import com.softart.dfe.interfaces.xml.NfContext;

public abstract class CteContextFactory implements CteContext {

    public static CteContextFactory getInstance() {
        return NfContextFactoryHolder.INSTANCE;
    }

    final static class NfContextFactoryHolder {
        final static CteContextFactory INSTANCE = new DefaultCteContext();
    }

}
