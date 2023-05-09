package com.softart.dfe.interfaces.xml.context;

import javax.xml.bind.JAXBContext;

public interface CteContext {

    /**
     * Returns a JAXBContext object for the CteSend class
     *
     * @return A JAXBContext object.
     */
    JAXBContext getCteSendContext();

    JAXBContext getCteDistributionContext();
}
