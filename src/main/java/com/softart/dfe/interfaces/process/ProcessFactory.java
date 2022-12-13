package com.softart.dfe.interfaces.process;

import com.softart.dfe.interfaces.xml.generic.XML;

import java.util.Collection;

public interface ProcessFactory<REQ extends XML, RES extends XML> {

    /**
     * > Returns a collection of functions that will be called after the web service request is made
     *
     * @return A collection of AfterWebServiceRequest objects.
     */
    Collection<? extends AfterWebServiceRequest<REQ, RES>> after();

    /**
     * "Returns a collection of objects that can be used to modify the request before it is sent to the web service."
     * <p>
     * The `before()` function is called by the `WebServiceRequest` object before it sends the request to the web service.
     * The `WebServiceRequest` object will call the `before()` function on each object in the collection returned by the
     * `before()` function
     *
     * @return A collection of BeforeWebServiceRequest objects.
     */
    Collection<? extends BeforeWebServiceRequest<REQ>> before();

}
