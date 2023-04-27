package com.softart.dfe.components.security.signer;

import com.softart.dfe.interfaces.xml.XMLSignerService;

public abstract class XmlSigner implements XMLSignerService {
    public static XmlSigner getInstance() {
        return Holder.DEFAULT;
    }

    private static class Holder {
        static final XmlSigner DEFAULT = new DefaultXmlSigner();
    }
}
