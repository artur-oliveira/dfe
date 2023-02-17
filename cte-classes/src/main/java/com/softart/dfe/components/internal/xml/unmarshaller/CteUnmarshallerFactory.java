package com.softart.dfe.components.internal.xml.unmarshaller;

import com.softart.dfe.interfaces.xml.unmarshaller.CteUnmarshaller;

public abstract class CteUnmarshallerFactory implements CteUnmarshaller {

    public static CteUnmarshallerFactory getInstance() {
        return Holder.INSTANCE;
    }

    private final static class Holder {
        private static final CteUnmarshallerFactory INSTANCE = new DefaultCteUnmarshaller();
    }
}
