package com.softart.dfe.interfaces.process;

import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.interfaces.xml.generic.XML;

public interface BeforeWebServiceRequest<REQ extends XML> {

    /**
     * "This function takes an object of type T, which is a subtype of BeforeRequest, and returns nothing."
     * <p>
     * The first thing to notice is that the function is generic.
     * <p>
     * The second thing to notice is that the function takes an object of type T, which is a subtype of BeforeRequest.
     * <p>
     * The third thing to notice is that the function returns nothing
     *
     * @param o The object that is being processed.
     */
    <T extends BeforeRequest<REQ>> void process(T o) throws ProcessException;

}
