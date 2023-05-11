package com.softart.dfe.interfaces.xml.context;

import jakarta.xml.bind.JAXBContext;

public interface MdfeContext {

    /**
     * Returns a JAXBContext object that can be used to marshal and unmarshal MDF-e objects
     *
     * @return The JAXBContext object is being returned.
     */
    JAXBContext getMdfeContext();

}
