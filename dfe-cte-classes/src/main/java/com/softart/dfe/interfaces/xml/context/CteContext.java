package com.softart.dfe.interfaces.xml.context;

import jakarta.xml.bind.JAXBContext;

public interface CteContext {

    /**
     * Returns a JAXBContext object for the CteSend class
     *
     * @return A JAXBContext object.
     */
    JAXBContext getCteSendContext();

    JAXBContext getCte400SendContext();

    JAXBContext getCteDistributionContext();
}
