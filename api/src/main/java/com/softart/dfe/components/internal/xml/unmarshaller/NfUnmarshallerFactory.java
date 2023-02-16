package com.softart.dfe.components.internal.xml.unmarshaller;

import com.softart.dfe.interfaces.xml.unmarshaller.NfUnmarshaller;

public abstract class NfUnmarshallerFactory implements NfUnmarshaller {

    public static NfUnmarshallerFactory getInstance() {
        return Holder.INSTANCE;
    }

    private final static class Holder {
        static final NfUnmarshallerFactory INSTANCE = new DefaultNfUnmarshaller();
    }
}
