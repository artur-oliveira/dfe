package com.softart.dfe.components.internal.xml.unmarshaller;

import com.softart.dfe.interfaces.xml.unmarshaller.MdfeUnmarshaller;

public abstract class MdfeUnmarshallerFactory implements MdfeUnmarshaller {
    public static MdfeUnmarshallerFactory getInstance() {
        return Holder.INSTANCE;
    }

    private final static class Holder {
        private static final MdfeUnmarshallerFactory INSTANCE = new DefaultMdfeUnmarshaller();
    }
}
