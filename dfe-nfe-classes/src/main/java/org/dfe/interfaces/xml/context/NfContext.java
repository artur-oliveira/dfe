package org.dfe.interfaces.xml.context;

import jakarta.xml.bind.JAXBContext;

public interface NfContext {

    JAXBContext getNfeEventContext();

    /**
     * Returns a JAXBContext object that can be used to marshal and unmarshal NFe objects
     *
     * @return A JAXBContext object.
     */
    JAXBContext getNfeSendContext();

    /**
     * Returns a JAXBContext object that can be used to marshal and unmarshal NFeDistribution objects
     *
     * @return The JAXBContext object is being returned.
     */
    JAXBContext getNfeDistributionContext();

    /**
     * Returns a JAXBContext object for the NfeGtin class
     *
     * @return A JAXBContext object.
     */
    JAXBContext getNfeGtinContext();
}
