package com.softart.dfe.components.security.signer;

import com.softart.dfe.interfaces.xml.XMLSigner;

public abstract class XmlSignerFactory implements XMLSigner {
    public static XmlSignerFactory getInstance() {
        return Holder.INSTANCE;
    }

    private static class Holder {
        static final XmlSignerFactory INSTANCE = new DefaultXmlSigner();
    }
}
