package com.softart.dfe.interfaces.xml;

import javax.xml.bind.JAXBContext;

public interface CteContext {

    JAXBContext getCteSendContext();

    JAXBContext getCteDistributionContext();
}
