package org.dfe.components.security.signer;

import org.dfe.interfaces.xml.XMLSignerService;

public abstract class XmlSigner implements XMLSignerService {
    public static XmlSigner getInstance() {
        return Holder.DEFAULT;
    }

    private static class Holder {
        static final XmlSigner DEFAULT = new DefaultXmlSigner();
    }
}
