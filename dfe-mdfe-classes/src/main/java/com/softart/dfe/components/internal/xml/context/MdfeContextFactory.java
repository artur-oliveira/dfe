package com.softart.dfe.components.internal.xml.context;

import com.softart.dfe.interfaces.xml.context.MdfeContext;

public abstract class MdfeContextFactory implements MdfeContext {

    public static MdfeContextFactory getInstance() {
        return MdfeContextFactoryHolder.INSTANCE;
    }

    final static class MdfeContextFactoryHolder {
        final static MdfeContextFactory INSTANCE = new DefaultMdfeContext();
    }

}
