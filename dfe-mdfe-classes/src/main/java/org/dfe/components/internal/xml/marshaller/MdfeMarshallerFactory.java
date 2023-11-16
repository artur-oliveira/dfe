package org.dfe.components.internal.xml.marshaller;

import org.dfe.interfaces.xml.marshaller.MdfeMarshaller;

public abstract class MdfeMarshallerFactory implements MdfeMarshaller {
    public static MdfeMarshallerFactory getInstance() {
        return Holder.INSTANCE;
    }

    private final static class Holder {
        private static final MdfeMarshallerFactory INSTANCE = new DefaultMdfeMarshaller();
    }
}
