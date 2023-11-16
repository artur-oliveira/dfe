package org.dfe.components.internal.xml.context;

import org.dfe.interfaces.xml.context.MdfeContext;

public abstract class MdfeContextFactory implements MdfeContext {

    public static MdfeContextFactory getInstance() {
        return MdfeContextFactoryHolder.INSTANCE;
    }

    final static class MdfeContextFactoryHolder {
        final static MdfeContextFactory INSTANCE = new DefaultMdfeContext();
    }

}
