package com.softart.dfe.interfaces.process;

import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.interfaces.xml.generic.XML;

// Defining a generic interface that will be used to process objects that implement the AfterRequest interface.
public interface AfterWebServiceRequest<REQ extends XML, RES extends XML> {

    /**
     * > Processes the given object, which is an object that implements the AfterRequest interface
     *
     * @param o The object that is being processed.
     */
    <T extends AfterRequest<REQ, RES>> void process(T o) throws ProcessException;

}
