package com.softart.dfe.components.internal.xml.marshaller;

import com.softart.dfe.interfaces.xml.marshaller.CteMarshaller;

public abstract class CteMarshallerFactory implements CteMarshaller {

    public static CteMarshallerFactory getInstance() {
        return Holder.INSTANCE;
    }

    private final static class Holder {
        private static final CteMarshallerFactory INSTANCE = new DefaultCteMarshaller();
    }
}
