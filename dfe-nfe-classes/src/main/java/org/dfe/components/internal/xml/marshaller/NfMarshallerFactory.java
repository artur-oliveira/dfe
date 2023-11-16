package org.dfe.components.internal.xml.marshaller;

import org.dfe.interfaces.xml.marshaller.NfMarshaller;

public abstract class NfMarshallerFactory implements NfMarshaller {

    public static NfMarshallerFactory getInstance() {
        return Holder.INSTANCE;
    }

    private final static class Holder {
        static final NfMarshallerFactory INSTANCE = new DefaultNfMarshaller();
    }
}
