package org.dfe.interfaces.xml.context;

import jakarta.xml.bind.JAXBContext;

public interface CteContext {

    JAXBContext getCte400SendContext();

    JAXBContext getCteDistributionContext();
}
