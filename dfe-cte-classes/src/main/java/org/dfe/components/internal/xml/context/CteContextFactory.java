package org.dfe.components.internal.xml.context;

import org.dfe.interfaces.xml.context.CteContext;

public abstract class CteContextFactory implements CteContext {

    public static CteContextFactory getInstance() {
        return CteContextFactoryHolder.INSTANCE;
    }

    final static class CteContextFactoryHolder {
        final static CteContextFactory INSTANCE = new DefaultCteContext();
    }

}
